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
            String rol = (String) session.getAttribute("rol");
            if ((Boolean) session.getAttribute("usuarioValido")&& rol.equals("tecnico")) {
            Producto p=new ProductoDAO().list((int)session.getAttribute("idproducto"));
        %>
        MENU EVALUA PRODUCTO
        
        <%}%>
    </body>
</html>
