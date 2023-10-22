
package com.mycompany.juezcachimbo.clases;

public class Solucion {
    private Texto texto;
    private Estudiante estudiante;
    private int preguntasC;
    private int preguntasI;

    public Solucion(Texto texto, Estudiante estudiante, int preguntasC, int preguntasI) {
        this.texto = texto;
        this.estudiante = estudiante;
        this.preguntasC = preguntasC;
        this.preguntasI = preguntasI;
    }
    
    public boolean valorPerfecto(){
        boolean valor=false;
                
        return valor;
    }
    public boolean valorDeficiente(){
        boolean valor=true;
                
        return valor;
    }
}
