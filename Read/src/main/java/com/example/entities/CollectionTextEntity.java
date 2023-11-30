package com.example.entities;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            for (TextEntity t : this.texts){
                for (SolveEntity s : resueltos){
                    if (t.getId() == s.getId()){
                        this.texts.remove(t);
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
                //ver si es plural
                if (t.charAt(t.length()-1) == 's'){
                    //si es plural, quitar la s
                    tokensLimpios.add(t.substring(0, t.length()-1));
                } else {
                    tokensLimpios.add(t);
                }
            }
        }

        return tokensLimpios;
    }
}

