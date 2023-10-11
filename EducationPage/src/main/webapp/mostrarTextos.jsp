
<%@page import="com.mycompany.educationpage.clases.Texto"%>
<%@page import="com.mycompany.educationpage.clases.Pregunta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Styles/mostrarTextos.css"/>
        <link rel="stylesheet" href="Components/nav.css">
        <title>Textos</title>
    </head>
    <body>
        <%@include file="Components/nav.jsp" %>
        <h1>Textos</h1>
        
        <%
            List<Texto> textos = (List)request.getSession().getAttribute("textos");
            int cont=1;
            for(Texto text: textos){
        %>
            <h3>Texto <%=cont%></h3>
            <h4>Contenido <%=text.getTexto()%></h4>
                <%  
                    int c=1;
                    for(Pregunta preg: text.getPreguntas()){
                %>
                    <h5>Pregunta <%=c%></h5>
                    <h5><%=preg.getPregunta()%></h5>
                    <%c++;%>
                <%}%>
            
            
            
            
            <%cont++;%>
        <% } %>
    </body>
</html>

