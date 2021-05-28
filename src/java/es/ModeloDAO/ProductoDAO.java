/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ModeloDAO;

import es.conexion.Conexion;
import es.modelo.Producto;
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
public class ProductoDAO implements CRUD<Producto> {

    Connection con;

    public ProductoDAO() {
        con = new Conexion().getConnextion();
    }

    @Override
    public ArrayList<Producto> listar() {
        ArrayList<Producto> list = new ArrayList<>();
        String sql = "select * from rol";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idproducto"));
                producto.setEsLlegada(rs.getString("estadollegada"));
                producto.setEsFinal(rs.getString("estadofinal"));
                producto.setSku(rs.getString("sku"));
                producto.setNumSerie(rs.getString("nserie"));
                producto.setIdDisponibilidad(rs.getInt("iddisponibilidad"));
                producto.setIdCategoria(rs.getInt("idcategoria"));
                producto.setDetalles(rs.getString("detalles"));
                producto.setFechaCompra(rs.getDate("fechacompra"));
                producto.setFechaVenta(rs.getDate("fechaventa"));
                producto.setIdImpuesto(rs.getInt("idimpuesto"));
                producto.setVisibilidad(rs.getBoolean("visibilidad"));
                producto.setCosto(rs.getDouble("costo"));
                producto.setCostoTotal(rs.getDouble("costototal"));
                producto.setEnvio(rs.getDouble("envio"));
                producto.setOtros(rs.getDouble("otros"));
                producto.setIva_dif_iva(rs.getDouble("iva_dif_iva"));
                producto.setPorcentaje(rs.getDouble("porcentaje"));
                producto.setValor(rs.getDouble("valor"));
                producto.setPvp(rs.getDouble("pvp"));
                producto.setValor2(rs.getDouble("valor2"));
                producto.setIdTienda(rs.getInt("idtienda"));
                producto.setNotas(rs.getString("notas"));
                producto.setCiclos(rs.getString("ciclos"));
                list.add(producto);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Producto list(int id) {
        Producto producto = new Producto();
        String sql = "select * from producto where idproducto=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                producto.setIdProducto(rs.getInt("idproducto"));
                producto.setEsLlegada(rs.getString("estadollegada"));
                producto.setEsFinal(rs.getString("estadofinal"));
                producto.setSku(rs.getString("sku"));
                producto.setNumSerie(rs.getString("nserie"));
                producto.setIdDisponibilidad(rs.getInt("iddisponibilidad"));
                producto.setIdCategoria(rs.getInt("idcategoria"));
                producto.setDetalles(rs.getString("detalles"));
                producto.setFechaCompra(rs.getDate("fechacompra"));
                producto.setFechaVenta(rs.getDate("fechaventa"));
                producto.setIdImpuesto(rs.getInt("idimpuesto"));
                producto.setVisibilidad(rs.getBoolean("visibilidad"));
                producto.setCosto(rs.getDouble("costo"));
                producto.setCostoTotal(rs.getDouble("costototal"));
                producto.setEnvio(rs.getDouble("envio"));
                producto.setOtros(rs.getDouble("otros"));
                producto.setIva_dif_iva(rs.getDouble("iva_dif_iva"));
                producto.setPorcentaje(rs.getDouble("porcentaje"));
                producto.setValor(rs.getDouble("valor"));
                producto.setPvp(rs.getDouble("pvp"));
                producto.setValor2(rs.getDouble("valor2"));
                producto.setIdTienda(rs.getInt("idtienda"));
                producto.setNotas(rs.getString("notas"));
                producto.setCiclos(rs.getString("ciclos"));
            }
            return (producto.getIdProducto()== -1) ? producto : null;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean add(Producto pr) {
       String sql = "insert into producto values('"+ pr.getIdProducto()
               +","+pr.getEsLlegada()+","+pr.getEsFinal()+","+pr.getSku()
               +","+pr.getNumSerie()+","+pr.getIdDisponibilidad()+","+pr.getIdCategoria()
               +","+pr.getDetalles()+","+pr.getFechaCompra()+","+pr.getFechaVenta()+","+pr.getIdImpuesto()+","+
               pr.isVisibilidad()+","+pr.getCosto()+","+pr.getCostoTotal()+","+pr.getEnvio()+","+pr.getOtros()+","+
               pr.getIva_dif_iva()+","+pr.getPorcentaje()+","+pr.getValor()+","+pr.getPvp()+","+pr.getValor2()+","+
               pr.getIdTienda()+","+pr.getNotas()+","+pr.getCiclos()+"')";
       try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            return true;
        } catch (Exception e) {
        }
        return false; 
    }

    @Override
    public boolean edit(Producto pr) {
        String sql = "update producto set idproducto=" + pr.getIdProducto()
               +", estadollegada='"+pr.getEsLlegada()+"', estadofinal='"+pr.getEsFinal()+"', sku='"+pr.getSku()
               +"', nserie='"+pr.getNumSerie()+"', iddisponibilidad="+pr.getIdDisponibilidad()+", idcategoria="+pr.getIdCategoria()
               +", detales='"+pr.getDetalles()+"', fechacompra='"+pr.getFechaCompra()+"', fechaventa='"+pr.getFechaVenta()+"', idimpuestos="+pr.getIdImpuesto()
                +", visibilidad='"+ Boolean.toString(pr.isVisibilidad()).toUpperCase()+"', costo="+pr.getCosto()+", costototal"+pr.getCostoTotal()+", envio="+pr.getEnvio()+", otros="+pr.getOtros()
                +", iva_dif_iva="+pr.getIva_dif_iva()+", porcentaje="+pr.getPorcentaje()+", valor="+pr.getValor()+", pvp="+pr.getPvp()+", valor2="+pr.getValor2()
                +", idtienda="+pr.getIdTienda()+", notas='"+pr.getNotas()+"', ciclos='"+pr.getCiclos()+ "'" + "where idproducto=" + pr.getIdProducto();
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
        String sql = "delete from producto where idproducto=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }


    

}
