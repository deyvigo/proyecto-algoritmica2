package com.example.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadTextsForTXT {

    public static String leerArch(String path){
        File arch = new File(path);
        String texto = "";
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(arch));
            String lineaLeida = "";
            while ((lineaLeida = entrada.readLine()) != null) {
                texto += lineaLeida;
            }
            entrada.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return texto;
    };

}
