package es.controlador;

import es.ModeloDAO.ProductoDAO;
import es.ModeloDAO.RolDAO;
import es.ModeloDAO.UsuarioDAO;
import es.modelo.Producto;
import es.modelo.Rol;
import es.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
            if (request.getParameter("todo") != null) {
                estado = request.getParameter("todo");
            }
            String emailUsuario = request.getParameter("email");
            String contrasena = request.getParameter("contrasena");
            String siguientepag = "";
            Usuario usuario;
            if (!(boolean) session.getAttribute("usuarioValido")) {// entra si el usuariovalido es igual a false 
                UsuarioDAO usuariodao = new UsuarioDAO();
                usuario = usuariodao.validaUsuario(emailUsuario, contrasena);// si el email y la contraseña son correctos el usuario tendra los valores de la base de datos 
                if (usuario.getIdUsuario() != -1) {//si se encuentra el  usuario en la base de datos el id que tendra el usuario sera de -1 es decir un id no valido
                    session.setAttribute("usuarioValido", true);//establecemos el atributo usuario valido dentroo de la sesion a true 
                    Rol rolusuario = new RolDAO().rolUsuario(usuario);//obtenemos su rol 
                    session.setAttribute("rol", rolusuario.getNombreRol());//guardamos el nombre del rol en un atributo de la sesion
                    //ahora en funcion de la pagina de la que venga se le redigira a una pagina siguente 
                    switch (estado) {
                        case "salir":// se invalida la sesion y se redirige al inicio
                            session.invalidate();
                            siguientepag = "/index.jsp";
                            break;
                        case "login":
                            siguientepag = "/index.jsp";
                            break;
                        case "menu":
                            siguientepag = "/menu.jsp";
                            break;
                        case "verDatosWoo":
                            siguientepag = "/verdatosproductowoo.jsp";
                            break;
                        case "modificarprodte"://pagina que sirve para que los usuarios con rol tecnico puedan evaluar productos
                            session.setAttribute("idproducto", request.getParameter("idproducto"));
                            boolean formulario=(boolean) session.getAttribute("formulario");
                            if(formulario){
                                Producto prod=new Producto();
                                prod.setIdDisponibilidad(Integer.parseInt(request.getParameter("disponibilidad")));
                                prod.setSku(request.getParameter("sku"));
                                prod.setNumSerie(request.getParameter("numSerie"));
                                prod.setNombreProducto(request.getParameter("nombreproducto"));
                                prod.setColor(request.getParameter("color"));
                                prod.setTeclado(request.getParameter("teclado"));
                                prod.setAccesoriosIncluidos(request.getParameter("accesoriosincluidos"));
                                prod.setEsFinal(request.getParameter("estado"));
                                prod.setDefectos(request.getParameter("defectos"));
                                prod.setIdTienda(Integer.parseInt(request.getParameter("tienda")));
                                prod.setCiclos(request.getParameter("ciclos"));
                                new ProductoDAO().edit(prod);
                                session.setAttribute("formulario", false);
                            }
                            siguientepag = "/modificarproductotecnico.jsp";
                            break;
                        case "":
                        default:
                            siguientepag = "/index.jsp";
                            break;
                    }
                } else {//si el usuario no es valido se redirige al logi
                    session.invalidate();
                    siguientepag = "/index.jsp";
                }
            } else {
                switch (estado) {
                    case "salir":
                        session.invalidate();
                        siguientepag = "/index.jsp";
                        break;
                    case "login":
                        siguientepag = "/index.jsp";
                        break;
                    case "menu":
                        siguientepag = "/menu.jsp";
                        break;
                    case "verDatosWoo":
                        siguientepag = "/verdatosproductowoo.jsp";
                        break;
                    case "modificarprodte":
                       session.setAttribute("idproducto", request.getParameter("idproducto"));
                            boolean formulario=(boolean) session.getAttribute("formulario");
                            if(formulario){
                                Producto prod=new Producto();
                                prod.setIdDisponibilidad(Integer.parseInt(request.getParameter("disponibilidad")));
                                prod.setSku(request.getParameter("sku"));
                                prod.setNumSerie(request.getParameter("numSerie"));
                                prod.setNombreProducto(request.getParameter("nombreproducto"));
                                prod.setColor(request.getParameter("color"));
                                prod.setTeclado(request.getParameter("teclado"));
                                prod.setAccesoriosIncluidos(request.getParameter("accesoriosincluidos"));
                                prod.setEsFinal(request.getParameter("estado"));
                                prod.setDefectos(request.getParameter("defectos"));
                                prod.setIdTienda(Integer.parseInt(request.getParameter("tienda")));
                                prod.setCiclos(request.getParameter("ciclos"));
                                new ProductoDAO().edit(prod);
                                session.setAttribute("formulario", false);
                            }
                            siguientepag = "/modificarproductotecnico.jsp";
                            break;
                    case "":
                    default:
                        siguientepag = "/index.jsp";
                        break;
                }
            }

        RequestDispatcher vista = request.getRequestDispatcher(siguientepag);
        vista.forward(request, response);
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
