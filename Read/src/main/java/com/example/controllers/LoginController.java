package com.example.controllers;

import com.example.entities.AlumnEntity;
import com.example.entities.GroupEntity;
import com.example.entities.RoleEntity;
import com.example.entities.TeacherEntity;
import com.example.repositories.AlumnRepository;
import com.example.repositories.GroupRepository;
import com.example.repositories.RoleRepository;
import com.example.repositories.TeacherRepository;
import com.example.utilities.RoleName;
import com.example.utilities.SearchGroupsUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/")
public class LoginController {

    private final AlumnRepository alumnRepository;
    private final TeacherRepository teacherRepository;
    private final RoleRepository roleRepository;
    private final GroupRepository groupRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(AlumnRepository alumnRepository, TeacherRepository teacherRepository, RoleRepository roleRepository, GroupRepository groupRepository, PasswordEncoder passwordEncoder) {
        this.alumnRepository = alumnRepository;
        this.teacherRepository = teacherRepository;
        this.roleRepository = roleRepository;
        this.groupRepository = groupRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(path = "/")
    public String index(HttpServletRequest request){
        if (request.isUserInRole("ROLE_ALUMN") || request.isUserInRole("ROLE_TEACHER")){
            return "redirect:/logRedirect";
        }
        return "index";
    }

    @GetMapping(path = "/login")
    public String login(HttpServletRequest request){
        if (request.isUserInRole("ROLE_ALUMN") || request.isUserInRole("ROLE_TEACHER")){
            return "redirect:/logRedirect";
        }
        return "login";
    }

    @GetMapping(path = "/logRedirect")
    public String logRedirect(HttpServletRequest request, Model model, Authentication authentication){
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        if (request.isUserInRole("ROLE_ALUMN")){
            AlumnEntity alumn = alumnRepository.findByUsername(userDetails.getUsername()).orElse(null);
            assert alumn != null;
            model.addAttribute("alumnName", alumn.fullName());
            if (alumn.getAlumn_group() == null){
                //List<GroupEntity> grupos = groupRepository.findAll();
                model.addAttribute("grupos", SearchGroupsUtil.getAllGroupDates(groupRepository));
                return "group-select";
            }
            return "alumn-screen-1";
        } else {
            TeacherEntity teacher = teacherRepository.findByUsername(userDetails.getUsername()).orElse(null);
            assert teacher != null;
            model.addAttribute("teacherName", teacher.fullName());
            model.addAttribute("gruposProfesor", SearchGroupsUtil.getGroupDatesPerTeacher(groupRepository, userDetails.getUsername()));
            return "teacher-screen-1";
        }
    }

    @GetMapping(path = "/signup")
    public ModelAndView registerUser(HttpServletRequest request){
        if(roleRepository.count() == 0){
            roleRepository.saveAll(List.of(
                    RoleEntity.builder().name(RoleName.ROLE_ALUMN).build(),
                    RoleEntity.builder().name(RoleName.ROLE_TEACHER).build()
            ));
        }
        if (request.isUserInRole("ROLE_ALUMN") || request.isUserInRole("ROLE_TEACHER")){
            return new ModelAndView("redirect:/logRedirect");
        }
        //Objetos para los form del registro
        return new ModelAndView("signup").addObject("teacher", new TeacherEntity()).addObject("alumn", new AlumnEntity());
    }

    @PostMapping(path = "/add-alumn")
    public String addNewAlumn(@ModelAttribute AlumnEntity alumn){
        if(teacherRepository.findByUsername(alumn.getUsername()).isEmpty() && alumnRepository.findByUsername(alumn.getUsername()).isEmpty()){
            alumn.setAlumn_rol(roleRepository.findByName(RoleName.ROLE_ALUMN).orElse(null));
            alumn.setPassword(passwordEncoder.encode(alumn.getPassword()));
            alumn.setAge(alumn.calculateAge());
            alumnRepository.save(alumn);
        }
        return "redirect:/login";
    }

    @PostMapping(path = "/add-teacher")
    public String addNewTeacher(@ModelAttribute TeacherEntity teacher){
        if(teacherRepository.findByUsername(teacher.getUsername()).isEmpty() && alumnRepository.findByUsername(teacher.getUsername()).isEmpty()){
            teacher.setTeacher_rol(roleRepository.findByName(RoleName.ROLE_TEACHER).orElse(null));
            teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
            teacherRepository.save(teacher);
        }
        return "redirect:/login";
    }
}
