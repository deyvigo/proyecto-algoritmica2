
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
        
        Texto textUno = new Texto("Lorem ipsum ...");
        textUno.agregarPregunta("¿Cómo te llamas?");
        textUno.agregarPregunta("kajshdaf");
        textUno.agregarPregunta("laksjdasd");
        
        textos.add(textUno);
        textUno = new Texto("Lorem ipsum lorem...");
        textUno.agregarPregunta("¿Cómo te llamasasdas?");
        textUno.agregarPregunta("kajshdafasdas");
        
        textos.add(textUno);

        textos.add(textUno);
        textUno = new Texto("Labore ea ea incididunt sunt pariatur sunt ipsum. Duis ex esse exercitation enim laborum anim reprehenderit sint anim. Eiusmod et aliqua cillum mollit aute consectetur proident sit. Culpa nulla commodo enim incididunt elit nisi est consectetur pariatur eu culpa.");
        textUno.agregarPregunta("Commodo non ut elit excepteur est magna laboris.");
        textUno.agregarPregunta("kajshdafasdas");
        textUno.agregarPregunta("Occaecat proident ex voluptate exercitation.");
        textUno.agregarPregunta("Laboris ullamco veniam ut non nisi excepteur.");
        
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
