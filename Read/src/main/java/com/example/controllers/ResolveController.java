
package com.example.controllers;

import com.example.entities.*;
import com.example.repositories.AlumnRepository;
import com.example.repositories.QuestionRepository;
import com.example.repositories.SolveRepository;
import com.example.repositories.TextRepository;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping (path="/enter")
public class ResolveController {

    private final AlumnRepository alumnRepository;
    private final TextRepository textRepository;
    private final QuestionRepository questionRepository;
    private final SolveRepository solveRepository;

    @Autowired
    public ResolveController(AlumnRepository alumnRepository, TextRepository textRepository, QuestionRepository questionRepository, SolveRepository solveRepository) {
        this.alumnRepository = alumnRepository;
        this.textRepository = textRepository;
        this.questionRepository = questionRepository;
        this.solveRepository = solveRepository;
    }

    @ModelAttribute(name = "alumnName")
    public String getAlumnName(Authentication auth){
        if (auth != null){
            AlumnEntity alumn = alumnRepository.findByUsername(((UserDetails) auth.getPrincipal()).getUsername()).get();
            return alumn.fullName();
        } else {
            return null;
        }
    }


    // Mostrar texto y preguntas
    @GetMapping(path = "/text")
    public String show(@RequestParam(name = "idText") Long id, Model model) {
        TextEntity t = new TextEntity();
        Optional<TextEntity> tOptional = textRepository.findById(id);

        List<List<Object>> textDates = new ArrayList<>();
        if (tOptional.isPresent()) {
            t = tOptional.get();
            List<Object> textInfo = new ArrayList<>();
            textInfo.add(t.getContent());
            List<List<String>> questionsAndOptions = new ArrayList<>();

            for (QuestionEntity pregunta : t.getPreguntas()) {
                List<String> questionInfo = new ArrayList<>();
                questionInfo.add(pregunta.getPregunta());

                List<String> options = pregunta.getAlternativas().stream()
                        .map(AlternativeEntity::getAlternativa)
                        .collect(Collectors.toList());
                questionInfo.addAll(options);
                questionsAndOptions.add(questionInfo);
            }

            textInfo.add(questionsAndOptions);
            textDates.add(textInfo);
        }

        model.addAttribute("idText", id);
        model.addAttribute("textDates", textDates);
        return "alumn-text";
    }


    @PostMapping(path = "/solvetext")
    public String solve(@RequestParam(name = "idText") Long id,
                      @RequestParam Map<String, String> userAnswers, Model model, Authentication auth){

        SolveEntity solveEntity = new SolveEntity();  //Solución del alumno
        Optional<TextEntity> text = textRepository.findById(id);
        text.ifPresent(solveEntity::setSolvedText);

        //Buscar al alumno
        AlumnEntity existAlum = null;

        if (auth != null){
            existAlum = alumnRepository.findByUsername(((UserDetails) auth.getPrincipal()).getUsername()).get();
            solveEntity.setAlumnSolve(existAlum);
        }
        List<QuestionEntity> questions= questionRepository.findQuestionsByTextId(id);        
        
        model.addAttribute("userAnswers", userAnswers);
        model.addAttribute("questions", questions);

        DecimalFormat decimalPattern = new DecimalFormat("#.##"); //Patron para redondear a 2 decimales

        // Calcula puntaje
        int correctas = 0;
        int incorrectas = 0;
        double nota = 0;

        int i=0; //indice de pregunta
        //Iterar sobre las preguntas y comparar con las respuestas del usuario
        for (Map.Entry<String, String> entry : userAnswers.entrySet()) {
            String grupo = entry.getKey();
            String opcionSeleccionada = entry.getValue();

            if (opcionSeleccionada.equals(questions.get(i).getRespuesta())){
                correctas++;
            }
            i++;
            if (questions.size() == i){
                break;
            }
        }

        incorrectas = questions.size() - correctas;  //question.size() por si deja preguntas sin marcar

        nota = (double) (correctas*20)/(correctas + incorrectas);

        nota = Double.parseDouble(decimalPattern.format(nota)); //Redondear a 2 decimales

        solveEntity.setCorrects(correctas);
        solveEntity.setWrongs(incorrectas);
        solveEntity.setNota(nota);
        solveEntity.setDateOfSolution(LocalDate.now());

        solveRepository.save(solveEntity);

        //Actualizar nota del alumno
        assert existAlum != null;
        existAlum.setNota(Double.parseDouble(decimalPattern.format(existAlum.calcularPromedio()))); //Redondear a 2 decimales
        alumnRepository.save(existAlum);

        model.addAttribute("correctas", correctas);
        model.addAttribute("incorrectas", incorrectas);
        model.addAttribute("nota", nota);

        return "alumn-text-solution";
    }
}
