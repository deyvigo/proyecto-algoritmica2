package com.example.controllers;

import com.example.entities.AlumnEntity;
import com.example.entities.GroupEntity;
import com.example.entities.TeacherEntity;
import com.example.repositories.AlumnRepository;
import com.example.repositories.GroupRepository;
import com.example.utilities.SearchGroupsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/alumn")
public class AlumnController extends SearchGroupsUtil {

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
            AlumnEntity teacher = alumnRepository.findByUsername(((UserDetails) auth.getPrincipal()).getUsername()).get();
            return teacher.getFirstName() + " " + teacher.getLastName();
        } else {
            return null;
        }
    }

    @GetMapping(path = "/get/{counter}")
    public String addToGroup(@PathVariable("counter") int counter, Authentication auth){
        System.out.println(counter);
        List<GroupEntity> optionalGroup = groupRepository.findAll();
        Optional<AlumnEntity> optionalAlumn = alumnRepository.findByUsername(getUsernameAlumn(auth));

        if (optionalAlumn.isPresent()){

            GroupEntity group = optionalGroup.get(counter-1);
            AlumnEntity alumn = optionalAlumn.get();
            group.getGroup_alumns().add(alumn);
            alumn.setAlumn_group(group);
            groupRepository.save(group);  //Comprobar si se necesita. Volviendo....

            return "alumn-screen-1";
        }
        return "erorrrrr";
    }

    @GetMapping("/hola")
    public void saludar(){
        System.out.println("Hola");
    }

}
