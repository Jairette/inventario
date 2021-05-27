
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
            <!--<a class="btn btn-success btn-lg" href="Controlador?accion=listar">Listar Persona</a>-->
            <form action="Controlador" method="post">
                <%
                    session = request.getSession();
                    String sessionid = session.getId();
                    session.setAttribute("estado", "menu");
                %>
                <input type="text" name="usuario" id="user">
                <input type="password" name="contrasena" id="password">
                <input type="submit" value="enviar">
            </form>
        </div>
    </body>
</html>
