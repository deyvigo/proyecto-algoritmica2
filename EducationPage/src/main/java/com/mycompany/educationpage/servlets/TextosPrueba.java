
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
        
        Texto textUno = new Texto("Incididunt aliquip laboris sunt aute culpa do qui ipsum veniam occaecat sit eiusmod. Aliquip non excepteur dolor aliqua est. Anim ullamco ea eiusmod adipisicing anim officia deserunt labore. Magna veniam nulla sunt proident. Ut eiusmod excepteur excepteur elit officia enim exercitation. Ad ea et nulla aliqua aute est enim commodo commodo ea dolore excepteur. Minim ullamco nisi adipisicing nostrud laborum. Eu consectetur nostrud est elit aute cillum aliquip ullamco exercitation occaecat aliqua amet. Cupidatat qui cillum ex do sunt magna ex duis sunt nisi proident. Sint consectetur culpa labore enim. Fugiat magna mollit nulla laborum adipisicing Lorem proident velit ea. Ipsum eiusmod ut non sunt incididunt officia laborum reprehenderit sunt pariatur.");
        textUno.agregarPregunta("¿Cómo te llamas?");
        textUno.agregarPregunta("kajshdaf");
        textUno.agregarPregunta("laksjdasd");
        
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
