/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ModeloDAO;

import es.conexion.Conexion;
import es.modelo.Impuesto;
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
public class ImpuestoDAO implements CRUD<Impuesto> {

    Connection con;

    public ImpuestoDAO() {
        con = new Conexion().getConnextion();
    }

    @Override
    public List listar() {
        ArrayList<Impuesto> list = new ArrayList<>();
        String sql = "select * from impuesto";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Impuesto impuesto = new Impuesto();
                impuesto.setIdImpuesto(rs.getInt("idimpuesto"));
                impuesto.setNombreImpuesto(rs.getString("nombreimpuesto"));
                list.add(impuesto);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Impuesto list(int id) {
        Impuesto impuesto = new Impuesto();
        String sql = "select * from impuesto where idimpuesto=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                impuesto.setIdImpuesto(rs.getInt("idimpuesto"));
                impuesto.setNombreImpuesto(rs.getString("nombreimpuesto"));
            }
            return (impuesto.getIdImpuesto() == -1) ? impuesto : null;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean add(Impuesto impuesto) {
        String sql = "insert into impuesto(nombreimpuesto)values('" + impuesto.getClass() + "')";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Impuesto impuesto) {
        String sql = "update impuesto set nombreImpuesto='" + impuesto.getNombreImpuesto() + "'" + "where idimpuesto=" + impuesto.getIdImpuesto();
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
        String sql = "delete from impuesto where idimpuesto=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
