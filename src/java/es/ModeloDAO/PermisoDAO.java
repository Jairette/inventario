/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ModeloDAO;

import es.conexion.Conexion;
import es.modelo.Permiso;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author macniacos
 */
public class PermisoDAO implements CRUD<Permiso>{
    
    Connection con;

    public PermisoDAO() {
        con = new Conexion().getConnextion();
    }
    
    @Override
    public ArrayList<Permiso> listar() {
        ArrayList<Permiso> list = new ArrayList<>();
        String sql = "select * from Permiso";
        RolDAO rdao = new RolDAO();
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Permiso permiso = new Permiso();
                permiso.setIdPermiso(rs.getInt("idpermiso"));
                permiso.setNombrePermiso(rs.getString("nombrepermiso"));
                list.add(permiso);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Permiso list(int id) {
        Permiso permiso = null;
        String sql = "select * from permiso where idpermiso=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                permiso = new Permiso();
                permiso.setIdPermiso(rs.getInt("idpermiso"));
                permiso.setNombrePermiso(rs.getString("nombrepermiso"));
            }
            return (permiso.getIdPermiso()!= -1) ? permiso : null;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean add(Permiso e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(Permiso e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
