package es.controlador;

import es.ModeloDAO.RolDAO;
import es.ModeloDAO.UsuarioDAO;
import es.conexion.Conexion;
import es.modelo.Rol;
import es.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession(true);

            String estado = (String) session.getAttribute("estado");

            String emailUsuario = request.getParameter("email");

            String contrasena = request.getParameter("contrasena");

            UsuarioDAO usuariodao = new UsuarioDAO();

            //out.println(usuario+password);
            Usuario usuario = usuariodao.validaUsuario(emailUsuario, contrasena);

            Rol rolusuario = new RolDAO().rolUsuario(usuario);

            session.setAttribute("rol", rolusuario.getNombreRol());
            if (usuario != null) {
                String siguientepag = "";
                session.setAttribute("usuarioValido", true);
                switch (estado) {
                    case "login":
                        siguientepag = "/index.jsp";
                        break;
                    case "menu":
                        siguientepag = "/menu.jsp";
                        break;
                    case "modificarprodte":
                        siguientepag = "/modificarproductotecnico.jsp";
                        break;
                    case "":
                    default:
                        siguientepag = "/index.jsp";
                        break;
                }
                RequestDispatcher vista = request.getRequestDispatcher(siguientepag);
                vista.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String dni = request.getParameter("txtDni");
            String nom = request.getParameter("txtNom");
//            p.setDni(dni);
//            p.setNom(nom);
//            dao.add(p);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idper", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtid"));
            String dni = request.getParameter("txtDni");
            String nom = request.getParameter("txtNom");
//            p.setId(id);
//            p.setDni(dni);
//            p.setNom(nom);
//            dao.edit(p);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
//            p.setId(id);
//            dao.eliminar(id);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);*/
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
