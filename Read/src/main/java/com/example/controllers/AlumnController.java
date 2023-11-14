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

}
