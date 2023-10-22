
package com.mycompany.juezcachimbo.clases;

import java.util.Vector;


public class ColeccionSoluciones {
    Vector<Solucion> soluciones;
    
    public void agregarSolucion(Solucion solucion){
        soluciones.add(solucion);
    }

    public Vector<Solucion> getSoluciones() {
        return soluciones;
    }

    public void setSoluciones(Vector<Solucion> soluciones) {
        this.soluciones = soluciones;
    }
    
}
