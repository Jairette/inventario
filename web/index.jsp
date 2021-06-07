
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <br>
        <div class="container">
            <form action="Controlador" method="post">
                <%
                    session = request.getSession();
                    session.setAttribute("usuarioValido", false);
                    session.setAttribute("estado", "menu");
                %>
                <label>Nombre de usuario
                    <input type="text" name="email" id="user">
                </label>
                <label>Contraseña
                    <input type="password" name="contrasena" id="password"></label>
                <input type="submit" value="enviar">
            </form>
        </div>
    </body>
</html>
