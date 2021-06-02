<%-- 
    Document   : verdatosproductowo
    Created on : 28-may-2021, 15:50:50
    Author     : macniacos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="Controlador" method="post">
            <input type="hidden" name="todo" value="salir">
            <input type="submit" value="Cerrar sesion" name="cerrarsesion">
        </form>
        <form action="Controlador" method="post">
            <input type="hidden" name="todo" value="menu">
            <input type="submit" value="volver al menu" name="vueltamenu">
        </form>
    </body>
</html>
