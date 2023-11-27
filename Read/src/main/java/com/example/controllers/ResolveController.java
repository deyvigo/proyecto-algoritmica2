
package com.example.controllers;

import com.example.entities.AlternativeEntity;
import com.example.entities.AlumnEntity;
import com.example.entities.QuestionEntity;
import com.example.entities.TextEntity;
import com.example.repositories.AlumnRepository;
import com.example.repositories.QuestionRepository;
import com.example.repositories.TextRepository;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    
    @Autowired
    private AlumnRepository alumnRepository;

    @Autowired
    private TextRepository textRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @ModelAttribute(name = "alumnName")
    public String getTeacherName(Authentication auth){
        if (auth != null){
            AlumnEntity alumn = alumnRepository.findByUsername(((UserDetails) auth.getPrincipal()).getUsername()).get();
            return alumn.fullName();
        } else {
            return null;
        }
    }


    // Mostrar texto y preguntas
    @GetMapping(path = "/text")
    public String show(@RequestParam(name = "idText") BigInteger id, Model model) {
        TextEntity t = textRepository.findById(id);

        List<List<Object>> textDates = new ArrayList<>();
        if (t != null) {
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
                      @RequestParam Map<String, String> userAnswers,Model model){
                       
        List<QuestionEntity> questions= questionRepository.findQuestionsByTextId(id);        
        
        model.addAttribute("userAnswers", userAnswers);
        model.addAttribute("questions", questions);

        //Lo de aquí se puede eliminar, es solo para comprobar


        int i=0; //indice de pregunta

        //Iterar sobre las preguntas y comparar con las respuestas del usuario
        for (Map.Entry<String, String> entry : userAnswers.entrySet()) {

            String grupo = entry.getKey();
            String opcionSeleccionada = entry.getValue();

            // Imprimir para comprobar cada respuesta
            System.out.println(grupo + ": " + opcionSeleccionada);
            System.out.println("Correcta: " + questions.get(i).getRespuesta());
            System.out.println(opcionSeleccionada.equals(questions.get(i).getRespuesta()));
            i++;
            if (questions.size() == i){
                break;
            }
        }


        return "alumn-text-solution";
    }
}
