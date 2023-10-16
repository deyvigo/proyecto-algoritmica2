package com.mycompany.juezcachimbo.clases;

import java.util.Vector;

public class Pregunta {
    private String pregunta;
    private Vector<String> alternativas;
    private String respuesta;
    private String razonamiento;

    public Pregunta (String pregunta){
        this.pregunta = pregunta;
        this.alternativas = new Vector<>();
    }

    public void agregarAlternativa(String a){
        this.alternativas.add(a);
    }

    public void agregarRespuesta(String r){
        this.respuesta = r;
    }

    public void agregarRazonamiento(String r){
        this.razonamiento = r;
    }

    public String getPregunta(){
        return this.pregunta;
    }

    public String getRespuesta(){
        return this.respuesta;
    }

    public Vector<String> getAlternativas(){
        return this.alternativas;
    }
}
