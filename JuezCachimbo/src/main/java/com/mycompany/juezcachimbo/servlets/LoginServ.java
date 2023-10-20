
package com.mycompany.juezcachimbo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mycompany.juezcachimbo.clases.Usuario;

@WebServlet(name = "LoginServ", urlPatterns = {"/LoginServ"})
public class LoginServ extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Creacion del objeto usuario
        Usuario user = new Usuario("mokoko", "mokoker", "Mokoko", "Mokoko");

        String nombre = request.getParameter("user");
        String contrasena = request.getParameter("contrasena");

        if(nombre.equals(user.getNombreUsuario()) && contrasena.equals(user.getContrasena())){
            HttpSession miSession = request.getSession();
            miSession.setAttribute("user", user);
            response.sendRedirect("user.jsp");
        } else {
            response.sendRedirect("error.html");
        }

        System.out.println(nombre);
        System.out.println(contrasena);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
