package com.example.controllers;

import com.example.entities.AlumnEntity;
import com.example.entities.GroupEntity;
import com.example.entities.SolveEntity;
import com.example.entities.TeacherEntity;
import com.example.repositories.AlumnRepository;
import com.example.repositories.GroupRepository;
import com.example.utilities.SearchGroupsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/alumn")
public class AlumnController {

    @Autowired
    private AlumnRepository alumnRepository;

    @Autowired
    private GroupRepository groupRepository;

    public String getUsernameAlumn(Authentication authentication){
        if (authentication != null){
            return ((UserDetails)authentication.getPrincipal()).getUsername();
        }
        return null;
    }

    @ModelAttribute(name = "alumnName")
    public String getTeacherName(Authentication auth){
        if (auth != null){
            AlumnEntity alumn = alumnRepository.findByUsername(((UserDetails) auth.getPrincipal()).getUsername()).get();
            return alumn.fullName();
        } else {
            return null;
        }
    }

    @GetMapping(path = "/get/{id}")
    public String addToGroup(@PathVariable("id") Long id, Authentication auth){
        Optional<AlumnEntity> optionalAlumn = alumnRepository.findByUsername(getUsernameAlumn(auth));
        Optional<GroupEntity> optionalGroup = groupRepository.findById(id);

        if (optionalAlumn.isPresent() && optionalGroup.isPresent()){

            AlumnEntity alumn = optionalAlumn.get();
            GroupEntity group = optionalGroup.get();
            //group.getGroup_alumns().add(alumn);
            alumn.setAlumn_group(group);
            groupRepository.save(group);

            return "alumn-screen-1";
        }
        return "/error";   //Luego crear este endpoint
    }

    @GetMapping("/profile")
    public String showAlumnProfile(Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        AlumnEntity alumn = alumnRepository.findByUsername(userDetails.getUsername()).orElse(null);

        if (alumn != null) {
            model.addAttribute("alumn", alumn);
            return "alumn-profile";
        } else {
            return "/error";
        }
    }
    @GetMapping("/statistics")
    public String showAlumnStatistics(Model model, Authentication authentication) {
    
        AlumnEntity alumn = alumnRepository.findByUsername(getUsernameAlumn(authentication)).orElse(null);

        if (alumn != null) {
            // Calcular los porcentajes y promedios
            double promedioNotas = alumn.calcularPromedio();
            double porcentajePreguntasCorrectas = alumn.calcularPromedioPreguntasCorrectasPorTexto();
            double porcentajeTextosAcertadosCompletamente = alumn.calcularPorcentajeTextosAcertadosCompletamente();
            double porcentajeTextosFalladosCompletamente = alumn.calcularPorcentajeTextosFalladosCompletamente();


            model.addAttribute("promedioNotas", promedioNotas);
            model.addAttribute("porcentajePreguntasCorrectas", porcentajePreguntasCorrectas);
            model.addAttribute("porcentajeTextosAcertadosCompletamente", porcentajeTextosAcertadosCompletamente);
            model.addAttribute("porcentajeTextosFalladosCompletamente", porcentajeTextosFalladosCompletamente);

            return "alumn-statistics";
        } else {
            return "/error";
        }
    }

    @GetMapping("/companeros")
    public String getCompaneros(Authentication authentication, Model model){
        AlumnEntity alumn = alumnRepository.findByUsername(getUsernameAlumn(authentication)).get();
        GroupEntity group = alumn.getAlumn_group();

        List<AlumnEntity> companeros = group.getGroup_alumns();
        //Eliminar al alumno de la lista
        companeros.remove(alumn);
        model.addAttribute("companeros", companeros);
        return "alumn-companeros";
    }

    @GetMapping("/leidos")
    public String getTextosLeidos(Authentication auth, Model model){
        AlumnEntity alumn = alumnRepository.findByUsername(getUsernameAlumn(auth)).get();
        List<SolveEntity> solves = alumn.getSolutions();
        model.addAttribute("solves", solves);
        return "alumn-textos-leidos";
    }
}
