<%-- 
    Document   : modificarproductotecnico
    Created on : 28-may-2021, 11:01:26
    Author     : macniacos
--%>

<%@page import="es.ModeloDAO.DisponibilidadDAO"%>
<%@page import="es.modelo.Disponibilidad"%>
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
            if (((Boolean) session.getAttribute("usuarioValido"))) {
                String rol = (String) session.getAttribute("rol");
                if (rol != null && rol.equals("tecnico")) {
                    session.setAttribute("formulario", true);
                    int idproducto = Integer.parseInt((String)session.getAttribute("idproducto"));
                    Producto p = new ProductoDAO().list(idproducto);
        %>
        <h1>MENU EVALUA PRODUCTO</h1>
        <form action="Controlador" method="post">
            <label>Disponibilidad:
                <select name="disponibilidad" id="">
                    <%  ArrayList<Disponibilidad> listaDisponibilidad = new DisponibilidadDAO().listar();
                        for (Disponibilidad d : listaDisponibilidad) {%>
                    <option value="<%= d.getIdDisponibilidad()%>"><%= d.getNombreDisponibilidad()%></option>
                    <%}%>
                </select>
            </label>
            <label>sku<input type="text" name="sku" value="<%= p.getSku()%>"></label>
            <label>numero de serie<input type="text" name="numSerie" value="<%= p.getNumSerie()%> "></label>
            <label>nombre  de producto<input type="text" name="nombreproducto" value="<%= p.getNombreProducto()%>"></label>
            <label>color<input type="text" name="color" value="<%= p.getColor()%>"></label>
            <label>teclado<input type="text" name="teclado" value="<%= p.getTeclado()%>"></label>
            <label>Accesorios incluidos<input type="text" name="accesoriosincluidos" value="<%= p.getAccesoriosIncluidos()%>"></label>
            <label>Estados
                <select name="estado">
                    <option value="A">Como nuevo A</option>
                    <option value="B">Bueno B</option>
                    <option value="C">Correcto C</option>
                </select>
            </label>
            <label>N.Estado <input type="text" name="defectos" value="<%= p.getDefectos()%>"></label>
            <label>Tienda
                <select name="tienda">
                    <% ArrayList<Tienda> listatienda = new TiendaDAO().listar();
                        for (Tienda t : listatienda) {
                            if (p.getIdTienda() == t.getIdTienda()) {%>
                    <option value="<%= t.getIdTienda()%>" selected> <%= t.getNombreTienda()%></option>
                    <%   } else {
                    %>
                    <option value="<%= t.getIdTienda()%>"> <%= t.getNombreTienda()%></option>
                    <%}
                }%>
                </select>
            </label>
            <h3>anotaciones</h3>
            <p><%= p.getAnotaciones()%></p>
            <label>ciclos <input type="text" name="ciclos" value="<%= p.getCiclos()%>"></label>
            <input type="hidden" name="todo" value="modificarprodte">
            <input type="submit" value="Guardar cambios">
        </form>

        <%} else {%>
        Ha habido un problema con el rol de tu usuario
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
