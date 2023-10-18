
package com.mycompany.juezcachimbo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mycompany.juezcachimbo.clases.Texto;
import com.mycompany.juezcachimbo.clases.Pregunta;

/**
 *
 * @author deyvigo
 */
@WebServlet(name = "SearchButtonServ", urlPatterns = {"/SearchButtonServ"})
public class SearchButtonServ extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String texto = "Eu occaecat ad esse dolor dolore in ut laborum. Pariatur labore pariatur proident deserunt consequat dolor id officia qui quis dolor amet. Tempor aute eu nisi commodo. Aliqua labore sint eiusmod esse incididunt ut nostrud magna duis tempor exercitation velit. Occaecat fugiat et irure sint reprehenderit exercitation est minim eiusmod occaecat. Incididunt id ad nostrud amet sit eu officia anim commodo adipisicing officia tempor. Ullamco et minim consectetur non occaecat. Reprehenderit id occaecat consequat culpa laborum esse elit veniam ut cupidatat fugiat. Veniam esse incididunt commodo ipsum incididunt quis excepteur voluptate do sint labore cillum ea cupidatat. Ad do enim labore consectetur pariatur sit. Fugiat velit voluptate aute exercitation veniam consequat dolore duis. Elit cupidatat aliquip non voluptate ea consectetur consequat nulla adipisicing est minim non officia. Magna aute commodo cillum occaecat. Sit eu nulla voluptate eu eiusmod non mollit non aliqua do dolore. Laborum dolor Lorem Lorem ea proident elit. Velit officia id minim excepteur ad et ad officia. Minim cupidatat Lorem amet fugiat commodo eu. Cupidatat fugiat sint qui et consectetur consectetur.";
        Texto text = new Texto(1, texto);
        Pregunta p;
        p = new Pregunta("¿Qué lenguaje sabes?");
        p.agregarAlternativa("JavaScript");
        p.agregarAlternativa("Dart");
        p.agregarAlternativa("C++");
        p.agregarAlternativa("Java");
        p.agregarAlternativa("Python");

        text.agregarPregunta(p);

        p = new Pregunta("¿Has ido a alguno de estos lugares?");
        p.agregarAlternativa("Lima");
        p.agregarAlternativa("Huaraz");
        p.agregarAlternativa("Arequipa");
        p.agregarAlternativa("Trujillo");
        p.agregarAlternativa("La Libertad");
        
        text.agregarPregunta(p);

        p = new Pregunta("¿Has jugado alguno de estos juegos?");
        p.agregarAlternativa("Terraria");
        p.agregarAlternativa("Dark Souls");
        p.agregarAlternativa("Hollow Knight");
        p.agregarAlternativa("Celeste");
        p.agregarAlternativa("Ori");
        
        text.agregarPregunta(p);

        p = new Pregunta("¿Has visto alguna de estas películas?");
        p.agregarAlternativa("Interestelar");
        p.agregarAlternativa("Mr. Nobody");
        p.agregarAlternativa("El Efecto Mariposa");
        p.agregarAlternativa("Kimi No Na Wa");
        p.agregarAlternativa("Up: Una aventura de altura");
        
        text.agregarPregunta(p);

        HttpSession miSession = request.getSession();
        miSession.setAttribute("text", text);
        response.sendRedirect("user-screen-1.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
