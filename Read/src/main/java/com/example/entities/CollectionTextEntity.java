package com.example.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CollectionTextEntity {

    private List<TextEntity> texts;

    public List<TextEntity> getTexts() {
        return texts;
    }

    public void setTexts(List<TextEntity> texts) {
        this.texts = texts;
    }

    public CollectionTextEntity() {
        this.texts = new ArrayList<>();
    }

    public void buscarTextos(String token, List<SolveEntity> resueltos){
        List<String> tokens = limpiarToken(token);
        System.out.println(tokens.toString());
        List<TextEntity> textosEncontrados = new ArrayList<>();
        for (TextEntity t : this.texts){
            for (String tk : tokens){
                if (t.getContent().toLowerCase().contains(tk)){
                    textosEncontrados.add(t);
                }
            }
        }
        this.texts = textosEncontrados;
        eliminarResueltos(resueltos);
    }

    public void eliminarResueltos(List<SolveEntity> resueltos){
        if (!resueltos.isEmpty()){
            // Iterador para evitar problemas de concurrencia
            Iterator<TextEntity> iterator = this.texts.iterator(); 
            while (iterator.hasNext()) {
                TextEntity t = iterator.next();

                for (SolveEntity s : resueltos) {
                    if (t.getId() == s.getSolvedText().getId()) {
                        iterator.remove();
                    }
                }
            }
        }
    }

    public List<String> limpiarToken(String token){
        String[] tokens = token.toLowerCase().split(" ");
        List<String> tokensLimpios = new ArrayList<>();
        String[] stopwords = {"el", "la", "los", "las", "un", "una", "unos", "unas", "y", "o", "u", "a", "ante", "bajo", "cabe", "con", "contra", "de", "desde",
                "en", "entre", "hacia", "hasta", "para", "por", "segun", "sin", "so", "sobre", "tras", "durante", "mediante", "versus", "via", "como", "pero", "mas", "aunque",
                "sino", "si", "no", "ni", "que", "cuando", "donde", "quien", "cual", "cuya", "cuyos", "cuales", "cuanto", "cuanta", "cuantos", "cuantas",
                "todo", "toda", "todos", "todas", "mismo", "misma", "mismos", "mismas", "otro", "otra", "otros", "otras", "tal", "tales", "tanto", "tanta", "tantos", "tantas",
                "algo", "alguien", "alguna", "alguno", "algunos", "algunas"};

        for (String t : tokens){
            boolean esStopword = false;
            for (String s : stopwords){
                if (t.equals(s)){
                    esStopword = true;
                    break;
                }
            }
            if (!esStopword){
                String pat = "\\b\\w+[aeiou]\\b";
                Pattern regex = Pattern.compile(pat);
                Matcher match = regex.matcher(t);
                //Si termina en vocal, quitar la vocal
                if (match.find()) {
                    tokensLimpios.add(t.substring(0, t.length() - 1));
                    continue;
                }
                //Si termina en [aeiou]s, quitar las dos ultimas letras
                pat = "\\b\\w+(as|es|is|os|us)\\b";
                regex = Pattern.compile(pat);
                match = regex.matcher(t);
                //ver si es plural
                if (match.find()){
                    //si es plural, quitar la s
                    tokensLimpios.add(t.substring(0, t.length()-2));
                } else {
                    tokensLimpios.add(t);
                }
            }
        }
        return tokensLimpios;
    }
}

