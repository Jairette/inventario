/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ModeloDAO;

import es.conexion.Conexion;
import es.modelo.Disponibilidad;
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
public class DisponibilidadDAO implements CRUD<Disponibilidad>{
    
     Connection con;

    public DisponibilidadDAO() {
        con = new Conexion().getConnextion();
    }

    @Override
    public ArrayList<Disponibilidad> listar() {
        ArrayList<Disponibilidad> list = new ArrayList<>();
        String sql = "select * from disponibilidad";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Disponibilidad disponibilidad = new Disponibilidad();
                disponibilidad.setIdDisponibilidad(rs.getInt("iddisponibilidad"));
                disponibilidad.setNombreDisponibilidad(rs.getString("nombredisponibilidad"));
                list.add(disponibilidad);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Disponibilidad list(int id) {
        Disponibilidad disponibilidad = new Disponibilidad();
        String sql = "select * from disponibilidad where iddisponibilidad=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                disponibilidad.setIdDisponibilidad(rs.getInt("iddisponibilidad"));
                disponibilidad.setNombreDisponibilidad(rs.getString("nombredisponibilidad"));
            }
            return (disponibilidad.getIdDisponibilidad() == -1) ? disponibilidad : null;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean add(Disponibilidad disponibilidad) {
        String sql = "insert into disponibilidad(nombredisponibilidad)values('" + disponibilidad.getClass() + "')";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Disponibilidad disponibilidad) {
        String sql = "update disponibilidad set nombreDisponibilidad='" + disponibilidad.getNombreDisponibilidad() + "'" + "where iddisponibilidad=" + disponibilidad.getIdDisponibilidad();
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
        String sql = "delete from disponibilidad where iddisponibilidad=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
