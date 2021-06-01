/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ModeloDAO;

import es.conexion.Conexion;
import es.modelo.Permiso;
import es.modelo.Usuario;
import es.modelo.UsuarioPermisos;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author macniacos
 */
public class UsuarioPermisosDAO {

    Connection con;

    public UsuarioPermisosDAO() {
        con = new Conexion().getConnextion();
    }

    public ArrayList<UsuarioPermisos> listar() {
        ArrayList<UsuarioPermisos> list = new ArrayList<>();
        String sql = "select * from listapermisos";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioPermisos usuariopermisos = new UsuarioPermisos();
                usuariopermisos.setIdUsuario(rs.getInt("idusuario"));
                usuariopermisos.setIdPermiso(rs.getInt("idpermiso"));
                list.add(usuariopermisos);
            }
        } catch (Exception e) {
        }
        return list;
    }

    /**
     * metodo que dado un id de usuario devuelve los permisos que tiene
     *
     * @param idusuario el id del usuario
     * @return una lista de permisos del usuario con el id que se pasa como
     * parametro
     */
    public ArrayList<Permiso> listaPermisosPorUsuario(int idusuario) {
        ArrayList<Permiso> listapermisos = new ArrayList<Permiso>();
        String sql = "Select permiso.* from permiso inner join usuariopermisos on (permiso.idpermiso=usuariopermisos.idpermiso) where listapermisos.idusuario=" + idusuario + "";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Permiso permiso = new Permiso();
                permiso.setIdPermiso(rs.getInt("idpermiso"));
                permiso.setIdPermiso(rs.getInt("nombrepermiso"));
                listapermisos.add(permiso);
            }
        } catch (Exception e) {
        }
        return listapermisos;
    }

    /**
     * metodo que dado un id de un permiso devuelve los usuarios que tienen ese
     * permiso
     *
     * @param idpermiso el id del permiso
     * @return una lista de usuarios con el idpermiso que se le pasa como
     * parametro
     */
    public ArrayList<Usuario> listaPermisosPorPermiso(int idpermiso) {
        ArrayList<Usuario> listausuarios = new ArrayList<Usuario>();
        String sql = "Select usuario.* from usuario inner join usuariopermisos on (usuario.idusuario=usuariopermisos.idusuario) where usuariopermisos.idpermiso=" + idpermiso + "";
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
                listausuarios.add(usuario);
            }
        } catch (Exception e) {
        }
        return listausuarios;
    }

    public boolean add(UsuarioPermisos usuariopermisos) {
        String sql = "insert into usariopermisos(idsuario,idpermiso)values('" + usuariopermisos.getIdUsuario() + "," + usuariopermisos.getIdPermiso() + "')";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean edit(UsuarioPermisos usuariopermiso) {
        String sql = "update usuariopermiso set idpermiso= "+usuariopermiso.getIdPermiso();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean eliminar(UsuarioPermisos usuariopermiso) {
        String sql="delete from usuariopermiso where idusuario="+usuariopermiso.getIdUsuario();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
