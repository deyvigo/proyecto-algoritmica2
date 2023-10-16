package com.mycompany.juezcachimbo.clases;

import java.util.Vector;

public class Texto {
    private int id;
    private String texto;
    private Vector<Pregunta> preguntas;

    public Texto(int id, String texto){
        this.id = id;
        this.texto = texto;
        this.preguntas = new Vector<>();
    }

    public void agregarPregunta(Pregunta p){
        preguntas.add(p);
    }

    public String getTexto(){
        return this.texto;
    }

    public int getId(){
        return this.id;
    }

    public Vector<Pregunta> getPreguntas(){
        return this.preguntas;
    }
}
