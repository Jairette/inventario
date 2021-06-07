<%-- 
    Document   : menu
    Created on : 26-may-2021, 15:28:15
    Author     : Guanat
--%>

<%@page import="es.modelo.Disponibilidad"%>
<%@page import="es.ModeloDAO.TiendaDAO"%>
<%@page import="es.ModeloDAO.ProductoDAO"%>
<%@page import="es.ModeloDAO.DisponibilidadDAO"%>
<%@page import="es.modelo.Producto"%>
<%@page import="es.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="es.ModeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
        <%
            session = request.getSession();
            session.setAttribute("formulario", false);
            if ((Boolean) session.getAttribute("usuarioValido")) {
        %>
        <h1>Menu</h1>
        <%
            String rol = (String) session.getAttribute("rol");
            ArrayList<Producto> listaProducto = new ProductoDAO().listar();%>
        <%= rol %>
        <%= session.getId() %>
        <%    switch (rol) {
                case "tecnico":
        %>
        <form action="Controlador">
            <%= listaProducto.size()%>
            <table>
                <thead>
                    <tr>
                        <th>Sku</th>
                        <th>Numero de serie</th>
                        <th>Nombre del Producto</th>
                        <th>Estado final</th>
                        <th>Ciclos</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%  
                        for (Producto p : listaProducto) {%>
                    <tr>
                        <th><%= p.getSku()%></th>
                        <th><%=  p.getNumSerie()%></th>
                        <th><%=  p.getNombreProducto()%></th>
                        <th><%=  p.getEsFinal()%></th>
                        <th><%=  p.getCiclos()%></th>
                        <th>
                            <form method="POST" action="Controlador">
                                
                                <input type="hidden" name="idproducto" value="<%=p.getIdProducto()%>">
                                <input type="hidden" name="todo" value="modificarprodte">
                                <input type="submit" value="evalua producto" name="evaluaprooducto">
                            </form>
                        </th>
                    </tr>                   
                    <%  }
                    %>
                </tbody>
            </table>
        </form>

        <%          break;
            default:
                session.setAttribute("estado", "login"); %>
        <h1>error con los premisos</h1>
        <a href="Controlador">volver al login</a>
        <%    break;
            }
        } else { %>-->
        <h1>estamos en el a del menu usuario no valido</h1>
        <%}%>
        <form action="Controlador" method="post">
            <input type="hidden" name="todo" value="salir">
            <input type="submit" value="Cerrar sesion" name="cerrarsesion">
        </form>
    </body>
</html>
