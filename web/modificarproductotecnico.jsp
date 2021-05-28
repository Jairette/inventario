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
<%
    session = request.getSession();
    String usuario = (String) session.getAttribute("usuario");
    String contra = (String) session.getAttribute("contra");
    if ((Boolean) session.getAttribute("usuarioValido")) {
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/javascript.js"></script>
    </head>
    <body>
        <%String rol = (String) session.getAttribute("rol");
            if (rol.equals("tecnico")) {
                ProductoDAO pDAO = new ProductoDAO();
                Producto p = pDAO.list(((String) session.getAttribute("idproducto")));
        %>
        <form action="Controlador" id="evaluaproducto">
            <label>Teclado
                <input type="text" id="teclado" value="<%= p.getTeclado()%>"></label>
            <label>acessorios incluidos
                <input type="text" id="acesoriosProducto" value="<%= p.getAccesoriosIncluidos()%>"></label>
            <label>estado
                <select id="estado">
                    <option value="A">Como nuevo</option>
                    <option value="B">Bueno</option>
                    <option value="C">Correcto</option>
                </select>
            </label>
            <label>Defectos esteticos encontrados
                <input type="text" id="defectosEsteticos" value="<%= p.getDefectos()%>">
            </label>
            <label>Tienda
                <select id="tienda">
                    <%  ArrayList<Tienda> listaTiendas = new TiendaDAO().listar();
                        for (Tienda t : listaTiendas) {%>
                    <option value="<%= t.getIdTienda()%>"><%= t.getNombreTienda()%></option>
                    <% }%>
                </select>
            </label>
            <label>Anotaciones
                <p><%= p.getAnotaciones()%></p>
            </label>
            <label>
                Categoria
                <select id="categoria">
                    <%
                        ArrayList<Categoria> listaCategorias = new CategoriaDAO().listar();
                        for (Categoria c : listaCategorias) {
                    %>      
                    <option value="<%= c.getIdCategoria()%>"><%= c.getNombreCategoria()%></option>
                    <%
                        }
                    %>
                </select>
            </label>
            <label>
                ciclos
                <input type="text" id="ciclos" value="<%= p.getCiclos()%>">
            </label>
            <input type="hidden" id="cambios" name="cambios" value="">
        </form>
            <% session.setAttribute("estado", "menu"); %>
            <a href="Controlador">volver al menu</a>
        <%} else {%>
        error  el usuario es valido pero no tiene permisos de tecnico
        <%}
        } else {%>
        error el usuario no es valido
        <%}%>
    </body>
</html>
