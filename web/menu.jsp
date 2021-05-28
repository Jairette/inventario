<%-- 
    Document   : menu
    Created on : 26-may-2021, 15:28:15
    Author     : Guanat
--%>

<%@page import="es.ModeloDAO.ProductoDAO"%>
<%@page import="es.modelo.Producto"%>
<%@page import="es.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="es.ModeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session = request.getSession();
    String sessionId = session.getId();
    String usuario = (String) session.getAttribute("usuario");
    String contra = (String) session.getAttribute("contra");
    if ((Boolean) session.getAttribute("usuarioValido")) {
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
        <%
            String rol = (String) session.getAttribute("rol");
            ArrayList<Producto> listaProducto=new ProductoDAO().listar();
            switch (rol) {
                case "tecnico":
        %>
        <form action="Controlador">
            <table>
                <thead>
                    <tr>
                        <th>Nombre del Producto</th>
                        <th>Sku</th>
                        <th>Numero de serie</th>
                        <th>Nombre del poducto</th>
                        <th>Color</th>
                        <th>Teclado</th>
                        <th>Accesorios incluidos</th>
                        <th>Estado</th>
                        <th>N estado</th>
                        <th>Tienda</th>
                        <th>ciclos</th>
                        <th>Notas supervisor</th>
                        <th>Quien</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        
                    %>
                </tbody>
            </table>

            <a href="Controlador">Realizar evaluacion del producto</a>
        </form>
        <%          break;
                case "web":%>

        <%          break;
            case "Supervisor":
                session.setAttribute("estado", "login");%>


        <%          break;
                case "":
                default:
                    session.setAttribute("estado", "login");%>
        <h1>error con los premisos</h1>
        <a href="Controlador">volver al login</a>
        <%     break;
            }%>
    </body>
</html>
