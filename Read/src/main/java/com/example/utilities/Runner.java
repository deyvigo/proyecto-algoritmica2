package com.example.utilities;

import com.example.entities.*;
import com.example.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class Runner implements CommandLineRunner {

    private TextRepository textRepository;
    private QuestionRepository questionRepository;
    private AlternativeRepository alternativeRepository;

    @Autowired
    public Runner(TextRepository textRepository, QuestionRepository questionRepository, AlternativeRepository alternativeRepository) {
        this.textRepository = textRepository;
        this.questionRepository = questionRepository;
        this.alternativeRepository = alternativeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int j = 1; j<=183; j++){
            String texto = ReadTextsForTXT.leerArch("../Textos/" + (j) + ".txt");

            /////////////////////////////////////////////////////////////////////////////////////

            TextEntity textToSave = new TextEntity();
            textToSave.setContent(separarTexto(texto).trim());
            textRepository.save(textToSave);

            /////////////////////////////////////////////////////////////////////////////////////

            String pat = "==PREGUNTA";
            Pattern regex = Pattern.compile(pat);
            Matcher match = regex.matcher(texto);
            int cantPreguntas = 0;
            while (match.find()) {
                cantPreguntas++;
            }
            for(int i = 1; i<=cantPreguntas; i++){

                String[] partes = separarPregunta(texto, i).split("=====================ALTERNATIVAS======================");
                String pregunta = partes[0];
                /////////////////////////////////////////////////////////////////////////////////////

                QuestionEntity questToSave = new QuestionEntity();
                questToSave.setAlternativas(new ArrayList<>());
                questToSave.setPregunta(pregunta.trim());
                questToSave.setText(textToSave);

                /////////////////////////////////////////////////////////////////////////////////////
                partes = partes[1].split("=====================ALTERNATIVA CORRECTA======================");
                List<String> alternativas = separarAlternativas(partes[0]);

                partes = partes[1].split("=====================RAZONAMIENTO======================");

                String respuesta = partes[0];
                String razonamiento = partes[1];
                /////////////////////////////////////////////////////////////////////////////////////

                questToSave.setRespuesta(respuesta.trim());
                questToSave.setRazonamiento(razonamiento.trim());

                questionRepository.save(questToSave);
                /////////////////////////////////////////////////////////////////////////////////////

                for (String s: alternativas){
                    /////////////////////////////////////////////////////////////////////////////////////

                    AlternativeEntity alternativa = new AlternativeEntity();
                    alternativa.setAlternativa(s.trim());
                    alternativa.setPreg(questToSave);
                    alternativeRepository.save(alternativa);

                    /////////////////////////////////////////////////////////////////////////////////////
                }
            }

        }

    }

    public static String separarTexto(String content){
        String[] partes = content.split("=====================TEXTO======================");
        partes = partes[1].split("=====================PREGUNTA 1======================");
        return partes[0];
    }

    public static String separarPregunta(String content, int index){
        String[] partes = content.split("=====================PREGUNTA " + (index) + "======================");
        partes = partes[1].split("=====================PREGUNTA " + (index+1) + "======================");
        return partes[0];
    }

    public static List<String> separarAlternativas(String alt){
        String reg = "([A-Z]\\))(.+?)(?=[A-Z]\\)|$)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(alt);
        List<String> alternatives = new ArrayList<>();
        while (matcher.find()) {
            alternatives.add(matcher.group());
        }
        return alternatives;
    }
}

