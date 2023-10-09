
package com.mycompany.educationpage.clases;

import java.util.Vector;

public class Texto {
    private String texto;
    private Vector<Pregunta> preguntas;
    
    public Texto(String texto){
        this.texto = texto;
        preguntas = new Vector<Pregunta>();
    }
    
    public void agregarPregunta(String a){
        getPreguntas().add(new Pregunta(a));
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Vector<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Vector<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}