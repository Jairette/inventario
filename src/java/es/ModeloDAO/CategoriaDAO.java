/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ModeloDAO;

import es.conexion.Conexion;
import es.modelo.Categoria;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Guanat
 */
public class CategoriaDAO implements CRUD<Categoria> {

    Connection con;

    public CategoriaDAO() {
        con = new Conexion().getConnextion();
    }

    @Override
    public ArrayList<Categoria> listar() {
        ArrayList<Categoria> list = new ArrayList<>();
        String sql = "select * from categoria";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idcategoria"));
                categoria.setNombreCategoria(rs.getString("nombrecategoria"));
                list.add(categoria);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Categoria list(int id) {
        Categoria categoria = new Categoria();
        String sql = "select * from categoria where idcategoria=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                categoria.setIdCategoria(rs.getInt("idcategoria"));
                categoria.setNombreCategoria(rs.getString("nombrecategoria"));
            }
            return (categoria.getIdCategoria() != -1) ? categoria : null;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean add(Categoria categoria) {
        String sql = "insert into categoria(nombrecategoria)values('" + categoria.getClass() + "')";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Categoria categoria) {
        String sql = "update categoria set nombreCategoria='" + categoria.getNombreCategoria() + "'" + "where idcategoria=" + categoria.getIdCategoria();
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
        String sql = "delete from categoria where idcategoria=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
