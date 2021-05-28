/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ModeloDAO;

import es.conexion.Conexion;
import es.modelo.Proveedor;
import es.modelo.Proveedor;
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
public class ProveedorDAO implements CRUD<Proveedor> {

    Connection con;

    public ProveedorDAO() {
        con = new Conexion().getConnextion();
    }

    @Override
    public ArrayList<Proveedor> listar() {
        ArrayList<Proveedor> list = new ArrayList<>();
        String sql = "select * from proveedor";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idproveedor"));
                proveedor.setNombreProveedor(rs.getString("nombreproveedorl"));
                list.add(proveedor);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Proveedor list(int id) {
        Proveedor proveedor = new Proveedor();
        String sql = "select * from proveedor where idproveedor=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                proveedor.setIdProveedor(rs.getInt("idproveedor"));
                proveedor.setNombreProveedor(rs.getString("nombreproveedor"));
            }
            return (proveedor.getIdProveedor() == -1) ? proveedor : null;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean add(Proveedor proveedor) {
        String sql = "insert into proveedor(nombreproveedor)values('" + proveedor.getClass() + "')";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Proveedor proveedor) {
        String sql = "update proveedor set nombreProveedor='" + proveedor.getNombreProveedor() + "'" + "where idproveedor=" + proveedor.getIdProveedor();
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
        String sql = "delete from proveedor where idproveedor=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
