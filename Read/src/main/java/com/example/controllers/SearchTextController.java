package com.example.controllers;

import com.example.entities.AlumnEntity;
import com.example.entities.TextEntity;
import com.example.repositories.AlumnRepository;
import com.example.repositories.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

import java.util.Set;

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
            AlumnEntity alumn = alumnRepository.findByUsername(((UserDetails) auth.getPrincipal()).getUsername()).get();
            return alumn.fullName();
        } else {
            return null;
        }
    }

    @GetMapping(path = "/text")
    public String search(@RequestParam(name = "searchTokens")String keywords, Model model){
        System.out.println(keywords);
        Set<TextEntity> setOfTexts = textRepository.findByKeyword(keywords);
        List<List<String>> text = new ArrayList<>();
        if (!setOfTexts.isEmpty()){
            for (TextEntity t: setOfTexts){
                text.add( List.of(t.getContent(), String.valueOf(t.getId())) );
            }
        }
        model.addAttribute("textDates", text);
        return "alumn-search";
    }
}
