
<%@page import="com.mycompany.educationpage.clases.Texto"%>
<%@page import="com.mycompany.educationpage.clases.Pregunta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="<%=request.getContextPath()%>/Images/raccoon-with-headphones-and-reading-a-book.svg">
        <title>Education</title>
        <link rel="stylesheet" href="Styles/search-text.css">
        <link rel="stylesheet" href="Styles/mostrarTextos.css">
        <script src="https://kit.fontawesome.com/4fb2d199eb.js" crossorigin="anonymous"></script>
    </head>
    <body>

        <div class="background">
            <div class="container">
                <nav>

                </nav>
                <div class="content-box">
                    <div class="user">
                        <div class="user-info">
                            <img src="<%=request.getContextPath()%>/Images/raccoon-with-headphones-and-reading-a-book-on-back (1).svg" alt="user-img">
                            <p><strong>Deyvi Gomez</strong></p>
                            <div class="user-nav">
                                <a href="#"><strong>Mis Notas</strong></a>
                                <a href="#"><strong>Mis Textos Leídos</strong></a>
                                <a href="#"><strong>Notas</strong></a>
                                <a href="#"><strong>Notas</strong></a>
                            </div>
                        </div>
                        <div class="log-out">
                            <a href="#"><strong>Salir</strong></a>
                        </div>
                    </div>
                    <div class="search-text">
                        <form class="container-search" action="TextosPrueba" method="GET">
                            <input class="busqueda" type="text" name="busqueda">
                            <button class="button-search" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                        </form>
                        <div class="text-content">
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
                            <h5 class="title-question">Pregunta <%=c%></h5>
                            <h5><%=preg.getPregunta()%></h5>
                            <%c++;%>
                            <%}%>
                            <%cont++;%>
                            <% } %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
    
</html>