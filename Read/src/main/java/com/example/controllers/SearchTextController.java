package com.example.controllers;

import com.example.entities.AlumnEntity;
import com.example.entities.TextEntity;
import com.example.repositories.AlumnRepository;
import com.example.repositories.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(path = "/search")
public class SearchTextController {

    @Autowired
    private AlumnRepository alumnRepository;

    @Autowired
    private TextRepository textRepository;

    @ModelAttribute(name = "alumnName")
    public String getTeacherName(Authentication auth){
        if (auth != null){
            AlumnEntity teacher = alumnRepository.findByUsername(((UserDetails) auth.getPrincipal()).getUsername()).get();
            return teacher.getFirstName() + " " + teacher.getLastName();
        } else {
            return null;
        }
    }

    @GetMapping(path = "/text")
    public String search(@RequestParam(name = "searchTokens")String keywords){
        System.out.println(keywords);
        Long id = 1L;
        Optional<TextEntity> optionalText = textRepository.findById(id);
        if (optionalText.isPresent()){
            TextEntity text =  optionalText.get();
            System.out.println(text.getContent());
        }
        return "alumn-search";
    }
}
