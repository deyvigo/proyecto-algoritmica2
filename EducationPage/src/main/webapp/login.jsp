
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="<%=request.getContextPath()%>/Images/raccoon-with-headphones-and-reading-a-book.svg">
        <title>Registrarse</title>
        <link rel="stylesheet" href="Styles/login.css">
    </head>
    <body>
        <div class="background">
            <div class="container">
                <div class="title">REGISTRARSE</div>
                <form action="">
                    <div class="text-field">
                        <label>Nombres</label>
                        <input type="text" name="nombre">
                    </div>
                    <div class="text-field">
                        <label>Apellidos</label>
                        <input type="text" name="apellidos">
                    </div>
                    <div class="text-field">
                        <label>Usuario</label>
                        <input type="text" name="usuario">
                    </div>
                    <div class="text-field">
                        <label>Contraseña</label>
                        <input type="password" pattern=".{6,12}" name="password" placeholder="6-12 caracteres">
                    </div>
                    <div class="button">
                        <a href="search-text.jsp">Registrarse
                            <!-- <button type="submit">Registrarse</button> -->
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
