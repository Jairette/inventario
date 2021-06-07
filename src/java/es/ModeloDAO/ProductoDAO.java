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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        String sql = "select idproducto,iddisponibilidad,idcategoria,idimpuesto,IFNULL(numpedido,'No asignado') as numpedido,idtienda,cantidad,sku,IFNULL(numserie,'No asignado') as numserie, IFNULL(detalles,'No asignado') AS detalles ,IFNULL(esLlegada,'No asignado') as esLlegada , IFNULL(esFinal,'No asignado') as esFinal,IFNULL(notas,'No asignado') AS notas,IFNULL(ciclos,'No asignado') as ciclos,nombreproducto,color,IFNULL(teclado,'No asignado') as teclado, IFNULL(accesoriosincluidos,'No asignado') as  accesoriosincluidos , IFNULL(defectos,'No asignado')  as defectos , IFNULL(anotaciones,'No asignado') as anotaciones , visibilidad , IFNULL(costo,'No asignado') as costo, IFNULL(costototal,'No asignado') as costototal, IFNULL(envio,'No asignado') as envio , IFNULL(otros,'No asignado') as otros,IFNULL(iva_dif_iva,'No  asignado') as iva_dif_iva , IFNUll(porcentaje,'No asignado') as porcentaje, IFNULL(valor,'No asignado') as valor ,IFNULL(pvp,'No asignado') as pvp ,IFNULL(valor2,'No asignado') as valor2 from producto";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i=0;
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setDefectos(rs.getString("defectos"));
                producto.setAccesoriosIncluidos(rs.getString("accesoriosincluidos"));
                producto.setTeclado(rs.getString("teclado"));
                producto.setColor(rs.getString("color"));
                producto.setNombreProducto(rs.getString("nombreproducto"));
                producto.setIdProducto(rs.getInt("idproducto"));
                producto.setEsLlegada(rs.getString("esLlegada"));
                producto.setEsFinal(rs.getString("esFinal"));
                producto.setSku(rs.getString("sku"));
                producto.setNumSerie(rs.getString("numserie"));
                producto.setIdDisponibilidad(rs.getInt("iddisponibilidad"));
                producto.setIdCategoria(rs.getInt("idcategoria"));
                producto.setDetalles(rs.getString("detalles"));
                /*producto.setFechaCompra(rs.getDate("fechacompra"));
                producto.setFechaVenta(rs.getDate("fechaventa"));*/
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
            System.err.println("error" + e);
        }
        return list;
    }

    @Override
    public Producto list(int id) {
        Producto producto = new Producto();
        String sql = "select idproducto,iddisponibilidad,idcategoria,idimpuesto,"
                + "IFNULL(numpedido,'No asignado') as numpedido,idtienda,cantidad,"
                + "sku,IFNULL(numserie,'No asignado') as numserie,"
                + " IFNULL(detalles,'No asignado') AS detalles ,IFNULL(esLlegada,'No asignado') as esLlegada ,"
                + " IFNULL(esFinal,'No asignado') as esFinal"
                + ",IFNULL(notas,'No asignado') AS notas,"
                + "IFNULL(ciclos,'No asignado') as ciclos,"
                + "nombreproducto,color,IFNULL(teclado,'No asignado') as teclado,"
                + " IFNULL(accesoriosincluidos,'No asignado') as  accesoriosincluidos "
                + ", IFNULL(defectos,'No asignado') as defectos ,"
                + " IFNULL(anotaciones,'No asignado') as anotaciones "
                + ", visibilidad , IFNULL(costo,'No asignado') as costo,"
                + " IFNULL(costototal,'No asignado') as costototal,"
                + " IFNULL(envio,'No asignado') as envio ,"
                + " IFNULL(otros,'No asignado') as otros,"
                + "IFNULL(iva_dif_iva,'No  asignado') as iva_dif_iva ,"
                + " IFNUll(porcentaje,'No asignado') as porcentaje,"
                + " IFNULL(valor,'No asignado') as valor "
                + ",IFNULL(pvp,'No asignado') as pvp "
                + ",IFNULL(valor2,'No asignado') as valor2 from producto where idproducto="+id;
        System.out.println("consulta "+sql);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                producto.setTeclado(rs.getString("teclado"));
                producto.setDefectos(rs.getString("defectos"));
                producto.setColor(rs.getString("color"));
                producto.setAccesoriosIncluidos(rs.getString("accesoriosincluidos"));
                producto.setNombreProducto(rs.getString("nombreproducto"));
                producto.setIdProducto(rs.getInt("idproducto"));
                producto.setEsLlegada(rs.getString("esLlegada"));
                producto.setEsFinal(rs.getString("esFinal"));
                producto.setSku(rs.getString("sku"));
                producto.setNumSerie(rs.getString("numserie"));
                producto.setIdDisponibilidad(rs.getInt("iddisponibilidad"));
                producto.setIdCategoria(rs.getInt("idcategoria"));
                producto.setDetalles(rs.getString("detalles"));
                /*producto.setFechaCompra(rs.getDate("fechacompra"));
                producto.setFechaVenta(rs.getDate("fechaventa"));*/
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
            return (producto.getIdProducto()!= -1) ? producto : null;
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
        try {
            int visibilidad;
            if(pr.isVisibilidad()){
                visibilidad=1;
            }else{
                visibilidad=0;
            }
            System.out.println("estoy en el edit");
            String sql = "update producto set "+"defectos='"+pr.getDefectos()+"',accesoriosincluidos='"+pr.getAccesoriosIncluidos()+"',teclado='"+pr.getTeclado()+"',nombreproducto='"+pr.getNombreProducto()+"', color='"+pr.getColor()
                    +"', esllegada='"+pr.getEsLlegada()+"', esfinal='"+pr.getEsFinal()+"', sku='"+pr.getSku()
                    +"', numserie='"+pr.getNumSerie()+"', iddisponibilidad="+pr.getIdDisponibilidad()+", idcategoria="+pr.getIdCategoria()
                    +", detalles='"+pr.getDetalles()+/*"', fechacompra='"+pr.getFechaCompra()+"', fechaventa='"+pr.getFechaVenta()+*/"', idimpuesto="+pr.getIdImpuesto()
                    +", visibilidad="+visibilidad+", costo="+pr.getCosto()+", costototal="+pr.getCostoTotal()+", envio="+pr.getEnvio()+", otros="+pr.getOtros()
                    +", iva_dif_iva="+pr.getIva_dif_iva()+", porcentaje="+pr.getPorcentaje()+", valor="+pr.getValor()+", pvp="+pr.getPvp()+", valor2="+pr.getValor2()
                    +", idtienda="+pr.getIdTienda()+", notas='"+pr.getNotas()+"', ciclos='"+pr.getCiclos()+ "'" + " where idproducto=" + pr.getIdProducto();
            System.out.println(sql);
            
            PreparedStatement ps = con.prepareStatement(sql);
            //ps.executeUpdate();
            if(ps.executeUpdate()==1){
                System.out.println("se actualizo ");
            }else{
                System.out.print("hubo un error y no se actulizo ninguna fila");
            }
            return true;
            /*catch (Exception e) {
            
            
            }*/
            
        } catch (SQLException ex) {
            System.err.println("casco el edit");
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }return false;
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
