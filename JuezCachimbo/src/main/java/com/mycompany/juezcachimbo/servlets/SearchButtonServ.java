
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
        p = new Pregunta("Qui ipsum ut commodo amet sit magna reprehenderit occaecat.");
        p.agregarAlternativa("Deyvi");
        p.agregarAlternativa("David");
        p.agregarAlternativa("Deyvi");
        p.agregarAlternativa("David");
        p.agregarAlternativa("Deyvi");

        text.agregarPregunta(p);

        p = new Pregunta("Lorem consectetur proident elit mollit nostrud ullamco incididunt tempor et reprehenderit irure ut nisi laborum.");
        p.agregarAlternativa("Alskdjasd");
        p.agregarAlternativa("KASJDLKASJD");
        p.agregarAlternativa("Deyvi");
        p.agregarAlternativa("David");
        p.agregarAlternativa("Deyvi");
        
        text.agregarPregunta(p);

        p = new Pregunta("In reprehenderit proident proident magna fugiat dolore tempor laboris.");
        p.agregarAlternativa("Alskdjasd");
        p.agregarAlternativa("KASJDLKASJD");
        p.agregarAlternativa("Deyvi");
        p.agregarAlternativa("David");
        p.agregarAlternativa("Deyvi");
        
        text.agregarPregunta(p);

        p = new Pregunta("Aute fugiat anim nostrud sit eiusmod incididunt tempor sit labore sit.");
        p.agregarAlternativa("Alskdjasd");
        p.agregarAlternativa("KASJDLKASJD");
        p.agregarAlternativa("Deyvi");
        p.agregarAlternativa("David");
        p.agregarAlternativa("Deyvi");
        
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
