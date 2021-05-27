/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ModeloDAO;

import es.conexion.Conexion;
import es.modelo.Usuario;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guanat
 */
public class UsuarioDAO implements CRUD<Usuario> {

    Connection con;

    public UsuarioDAO() {
        con = new Conexion().getConnextion();
    }

    @Override
    public List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "select * from usuario";
        RolDAO rdao = new RolDAO();
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setNombreUsuario(rs.getString("nombreusuario"));
                usuario.setPassword("password");
                usuario.setEmail("email");
                usuario.setIdrol(rs.getInt("idrol"));
                list.add(usuario);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Usuario list(int id) {
        Usuario usuario = null;
        String sql = "select * from usuario where idusuario=" + id;
        RolDAO rdao = new RolDAO();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setNombreUsuario(rs.getString("nombreusuario"));
                usuario.setPassword("password");
                usuario.setEmail("email");
                usuario.setIdrol(rs.getInt("idrol"));
            }
            return (usuario.getIdUsuario() == -1) ? usuario : null;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean add(Usuario usuario) {
        String sql = "insert into usuario(idsuario,nombre,idrol,password,email)values('"
                + usuario.getIdUsuario() + "," + usuario.getNombreUsuario() + "," + usuario.getIdrol()
                + "," + usuario.getPassword() + "," + usuario.getEmail() + "')";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Usuario usuario) {
        String sql = "update usuario set nombreUsuario='" + usuario.getNombreUsuario() + "'" + "idrol=" + usuario.getIdrol()
                + "',password='" + usuario.getPassword() + "',email='" + usuario.getEmail() + "'" + " where idusuario=" + usuario.getIdUsuario();
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from usuario where idusuario=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public Usuario validaUsuario(String nombreusuario, String contrasena) {
        Usuario usuario = null;
        try {
            usuario = new Usuario();
            String sql = "select idusuario from usuario where usuario.nombreusuario='"
                    + nombreusuario + "' and usuario.password='" + contrasena + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setNombreUsuario(rs.getString("nombreusuario"));
                usuario.setIdrol(rs.getInt("idrol"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEmail(rs.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  usuario;
    }
}
