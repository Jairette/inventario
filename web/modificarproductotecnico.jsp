<%-- 
    Document   : modificarproductotecnico
    Created on : 28-may-2021, 11:01:26
    Author     : macniacos
--%>

<%@page import="es.ModeloDAO.CategoriaDAO"%>
<%@page import="es.modelo.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="es.ModeloDAO.TiendaDAO"%>
<%@page import="es.modelo.Tienda"%>
<%@page import="es.modelo.Producto"%>
<%@page import="es.ModeloDAO.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/javascript.js"></script>
    </head>
    <body>
        <%
            session = request.getSession();
            if (((Boolean)session.getAttribute("usuarioValido"))){
                String rol = (String) session.getAttribute("rol");
                    if(rol!=null&&rol.equals("tecnico")) {
            //Producto p=new ProductoDAO().list((int)session.getAttribute("idproducto"));
        %>
        <%= session.getId() %>   
        MENU EVALUA PRODUCTO
        
                    <%}else{%>
                        <%= rol %>
                    <%}
            }%>
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
