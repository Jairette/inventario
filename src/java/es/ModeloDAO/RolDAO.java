/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ModeloDAO;

import es.conexion.Conexion;
import es.modelo.Rol;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guanat
 */
public class RolDAO implements CRUD<Rol> {

    Connection con;

    public RolDAO() {
        con = new Conexion().getConnextion();
    }

    @Override
    public List listar() {
        ArrayList<Rol> list = new ArrayList<>();
        String sql = "select * from rol";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rol rol = new Rol();
                rol.setIdRol(rs.getInt("idrol"));
                rol.setNombreRol(rs.getString("nombrerol"));
                list.add(rol);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Rol list(int id) {
        Rol rol = new Rol();
        String sql = "select * from rol where idrol=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                rol.setIdRol(rs.getInt("idrol"));
                rol.setNombreRol(rs.getString("nombrerol"));
            }
            return (rol.getIdRol() == -1) ? rol : null;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean add(Rol rol) {
        String sql = "insert into rol(nombrerol)values('" + rol.getClass() + "')";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Rol rol) {
        String sql = "update rol set nombreRol='" + rol.getNombreRol() + "'" + "where idrol=" + rol.getIdRol();
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
        String sql = "delete from rol where idrol=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
