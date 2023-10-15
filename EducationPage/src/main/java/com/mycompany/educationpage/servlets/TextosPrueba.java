
package com.mycompany.educationpage.servlets;

import com.mycompany.educationpage.clases.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author deyvigo
 */
@WebServlet(name = "TextosPrueba", urlPatterns = {"/TextosPrueba"})
public class TextosPrueba extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Texto> textos = new ArrayList<>();
        
        Texto textUno = new Texto("Incididunt aliquip laboris sunt aute culpa do qui ipsum veniam occaecat sit eiusmod. Aliquip non excepteur dolor aliqua est. Anim ullamco ea eiusmod adipisicing anim officia deserunt labore. Magna veniam nulla sunt proident. Ut eiusmod excepteur excepteur elit officia enim exercitation. Ad ea et nulla aliqua aute est enim commodo commodo ea dolore excepteur. Minim ullamco nisi adipisicing nostrud laborum. Eu consectetur nostrud est elit aute cillum aliquip ullamco exercitation occaecat aliqua amet. Cupidatat qui cillum ex do sunt magna ex duis sunt nisi proident. Sint consectetur culpa labore enim. Fugiat magna mollit nulla laborum adipisicing Lorem proident velit ea. Ipsum eiusmod ut non sunt incididunt officia laborum reprehenderit sunt pariatur. Anim commodo reprehenderit est consequat consectetur nisi in reprehenderit. Do anim qui in aliquip ullamco qui mollit voluptate fugiat elit et enim cillum. Velit esse consectetur id anim eu enim eiusmod ipsum nisi nisi irure et. Sunt tempor voluptate cillum minim duis cillum pariatur eu mollit. Consequat ullamco in aute ad duis. Dolor sint dolore aute anim. Quis laborum enim velit veniam velit anim sit duis. Irure sunt officia commodo laboris nisi aliqua Lorem. Ad commodo veniam adipisicing voluptate incididunt elit cupidatat ea eiusmod cupidatat excepteur ad officia pariatur. Exercitation tempor in id aute ea mollit. Nulla labore labore velit aliquip laboris mollit duis. Pariatur sunt commodo esse sit sint. Ad ad velit aliquip in sunt. Lorem amet incididunt aute dolore.");
        textUno.agregarPregunta("¿Cómo te llamas?");
        textUno.agregarPregunta("Quis culpa sunt veniam culpa.");
        textUno.agregarPregunta("Nulla nulla esse laboris enim occaecat dolore culpa ex adipisicing laborum.");
        textUno.agregarPregunta("Reprehenderit irure nostrud Lorem culpa.");
        textUno.agregarPregunta("Elit ipsum sit aliqua deserunt fugiat anim deserunt.");
        textUno.agregarPregunta("Do elit nulla excepteur sint laboris aliquip deserunt ad elit laborum et tempor anim.");
        textUno.agregarPregunta("Aute mollit incididunt quis consectetur exercitation fugiat consectetur cillum sunt ex mollit ipsum.");
        textUno.agregarPregunta("Proident laboris incididunt elit est.");
        
        textos.add(textUno);
        
        HttpSession miSession = request.getSession();
        miSession.setAttribute("textos", textos);
        response.sendRedirect("mostrarTextos.jsp");
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
