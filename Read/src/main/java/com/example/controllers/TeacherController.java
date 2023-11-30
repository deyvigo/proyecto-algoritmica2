package com.example.controllers;

import com.example.entities.AlternativeEntity;
import com.example.entities.AlumnEntity;
import com.example.entities.GroupEntity;
import com.example.entities.QuestionEntity;
import com.example.entities.TeacherEntity;
import com.example.entities.TextEntity;
import com.example.repositories.AlternativeRepository;
import com.example.repositories.AlumnRepository;
import com.example.repositories.GroupRepository;
import com.example.repositories.QuestionRepository;
import com.example.repositories.SolveRepository;
import com.example.repositories.TeacherRepository;
import com.example.repositories.TextRepository;
import com.example.utilities.SearchGroupsUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.directory.SearchControls;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(path = "/teach")
public class TeacherController {

    private final TeacherRepository teacherRepository;
    private final GroupRepository groupRepository;
    private final AlumnRepository alumnRepository;
    private final TextRepository textRepository;
    private final QuestionRepository questionRepository;
    private final SolveRepository solveRepository;
    private final AlternativeRepository alternativeRepository;

    //Constructor
    @Autowired
    public TeacherController(TeacherRepository teacherRepository, GroupRepository groupRepository, AlumnRepository alumnRepository, TextRepository textRepository, QuestionRepository questionRepository, SolveRepository solveRepository, AlternativeRepository alternativeRepository) {
        this.teacherRepository = teacherRepository;
        this.groupRepository = groupRepository;
        this.alumnRepository = alumnRepository;
        this.textRepository = textRepository;
        this.questionRepository = questionRepository;
        this.solveRepository = solveRepository;
        this.alternativeRepository = alternativeRepository;
    }


    //Funcion para obtener el nombre del profesor
    public String getUsernameTeacher(Authentication authentication){
        if (authentication != null){
            return ((UserDetails)authentication.getPrincipal()).getUsername();
        }
        return null;
    }

    //Pasa el nombre del profesor a todos los templates
    @ModelAttribute(name = "teacherName")
    public String getTeacherName(Authentication auth){
        if (auth != null){
            TeacherEntity teacher = teacherRepository.findByUsername(((UserDetails) auth.getPrincipal()).getUsername()).get();
            return teacher.getFirstName() + " " + teacher.getLastName();
        } else {
            return null;
        }
    }

    @GetMapping(path = "/toAddGroup")
    public ModelAndView toAddGroup(Authentication auth){
        return new ModelAndView("create-group").addObject("grupo", new GroupEntity());
    }

    @PostMapping(path = "/addGroup")
    public String addGroup(@ModelAttribute GroupEntity groupEntity, Authentication auth, Model model){
        if (groupRepository.findByGroupName(groupEntity.getGroupName()).isEmpty()){
            TeacherEntity teacher = teacherRepository.findByUsername(getUsernameTeacher(auth)).get();
            groupEntity.setGroup_teacher(teacher);
            groupEntity.setGroup_alumns(new ArrayList<>());
            groupRepository.save(groupEntity);
        }
        model.addAttribute("gruposProfesor", SearchGroupsUtil.getGroupDatesPerTeacher(groupRepository, getUsernameTeacher(auth)));
        return "teacher-screen-1";
    }

    @GetMapping("/profile")
    public String showTeacherProfile(Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        TeacherEntity teacher = teacherRepository.findByUsername(userDetails.getUsername()).orElse(null);
    
        if (teacher != null) {
            model.addAttribute("teacher", teacher);
            return "teacher-profile";
        } else {
            return "/error";
        }
    }

    @GetMapping("/group")
    public String getGroups(Authentication auth, Model model){
        model.addAttribute("gruposProfesor", SearchGroupsUtil.getGroupDatesPerTeacher(groupRepository, getUsernameTeacher(auth)));
        return "teacher-screen-1";
    }

    @GetMapping("/group/{groupId}/students")
    public String showGroupStudents(@PathVariable("groupId") Long groupId, Model model) {
        Optional<GroupEntity> groupOptional = SearchGroupsUtil.getGroupById(groupRepository, groupId);

        if (groupOptional.isPresent()) {
            GroupEntity group = groupOptional.get();
            List<AlumnEntity> studentsInGroup = group.getGroup_alumns();

            model.addAttribute("students", studentsInGroup);
            return "teacher-group-alumnos";
        } else {
            return "/error";
        }
    }
    @GetMapping(path = "/toAddExercise")
    public String showExerciseForm() {
        return "create-text";
    }

    /*
    @PostMapping("/addExercise")
    public String crearEjercicio(@RequestParam String content, @RequestParam String pregunta, @RequestParam String respuesta, @RequestParam String razonamiento, @RequestParam List<String> alternativas) {
        
        TextEntity texto = new TextEntity();
        texto.setContent(content);
        textRepository.save(texto);

        QuestionEntity question = new QuestionEntity();
        question.setPregunta(pregunta);
        question.setRazonamiento(razonamiento);
        question.setText(texto);
        questionRepository.save(question);

        for (String alternativa : alternativas) {
            AlternativeEntity alternative = new AlternativeEntity();
            alternative.setAlternativa(alternativa);
            alternative.setPreg(question);
            alternativeRepository.save(alternative);
        }

        question.setRespuesta(respuesta);
        questionRepository.save(question);

        return "create-text";
    }
*/

    @PostMapping("/addExercise")
    public String crearEjercicio(@RequestParam Map<String, String> textParams){
        TextEntity textToSave = TextEntity.builder().content(textParams.get("content").trim()).build();
        textRepository.save(textToSave);
        int indexQuestion = 1;
        while (textParams.get("pregunta_" + indexQuestion) != null){
            QuestionEntity questToSave = new QuestionEntity();
            questToSave.setAlternativas(new ArrayList<>());
            questToSave.setPregunta(textParams.get("pregunta_" + indexQuestion).trim());
            questToSave.setText(textToSave);
            questToSave.setRespuesta(textParams.get("respuesta_" + indexQuestion));
            questToSave.setRazonamiento(textParams.get("razonamiento_" + indexQuestion));
            questionRepository.save(questToSave);
            int indexAlternative = 1;
            while (textParams.get("alternativas_" + indexQuestion + "_" + indexAlternative) != null){
                AlternativeEntity alternToSave = new AlternativeEntity();
                alternToSave.setAlternativa(textParams.get("alternativas_" + indexQuestion + "_" + indexAlternative).trim());
                alternToSave.setPreg(questToSave);
                alternativeRepository.save(alternToSave);
                indexAlternative++;
            }
            indexQuestion++;
        }

        return "create-text";
    }

    @GetMapping("/statistics")
    public String showStatistics(Model model, Authentication authentication) {
        String username = authentication.getName();
        
        List<GroupEntity> groups = SearchGroupsUtil.getGroupsPerTeacher(groupRepository,username);
        List<Integer> totalTextosResueltosPorGrupo = new ArrayList<>();
        
        for (GroupEntity groupDate : groups) {
            Long groupId = groupDate.getId();
            List<AlumnEntity> alumnosDelGrupo = alumnRepository.getAlumnsPerGroup(groupId);
            int totalTextosResueltos = 0;
            
            for (AlumnEntity alumno : alumnosDelGrupo) {
                int textosResueltosPorAlumno = solveRepository.countSolvesByAlumnId(alumno.getId());
                totalTextosResueltos += textosResueltosPorAlumno;
            }
            
            totalTextosResueltosPorGrupo.add(totalTextosResueltos);
        }
        int totalTextosResueltosGlobal = totalTextosResueltosPorGrupo.stream().mapToInt(Integer::intValue).sum();

        model.addAttribute("groupDates", groups);
        model.addAttribute("totalTextosResueltosPorGrupo", totalTextosResueltosPorGrupo);
        model.addAttribute("totalTextosResueltosGlobal", totalTextosResueltosGlobal);

        return "teacher-statistics";
    }
}
