/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ModeloDAO;

import es.conexion.Conexion;
import es.modelo.Tienda;
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
public class TiendaDAO implements CRUD<Tienda> {

    Connection con;

    public TiendaDAO() {
        con = new Conexion().getConnextion();
    }

    @Override
    public List listar() {
        ArrayList<Tienda> list = new ArrayList<>();
        String sql = "select * from tienda";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tienda tienda = new Tienda();
                tienda.setIdTienda(rs.getInt("idtienda"));
                tienda.setNombreTienda(rs.getString("nombretienda"));
                list.add(tienda);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Tienda list(int id) {
        Tienda tienda = new Tienda();
        String sql = "select * from tienda where idtienda=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                tienda.setIdTienda(rs.getInt("idtienda"));
                tienda.setNombreTienda(rs.getString("nombretienda"));
            }
            return (tienda.getIdTienda() == -1) ? tienda : null;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean add(Tienda tienda) {
        String sql = "insert into tienda(nombretienda)values('" + tienda.getClass() + "')";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Tienda tienda) {
        String sql = "update tienda set nombreTienda='" + tienda.getNombreTienda() + "'" + "where idtienda=" + tienda.getIdTienda();
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
        String sql = "delete from tienda where idtienda=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
