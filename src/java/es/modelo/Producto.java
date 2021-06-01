/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.modelo;

import java.sql.Date;

/**
 *
 * @author Guanat
 */
public class Producto {

    private int idProducto = -1, idDisponibilidad, idCategoria, idImpuesto, numPedido, idTienda, cantidad;
    private String sku, numSerie, detalles, esLlegada, esFinal, notas, ciclos,nombreProducto,color,teclado,AccesoriosIncluidos,defectos,anotaciones;
    private Date fechaCompra, fechaVenta;
    private boolean visibilidad;
    private double costo, costoTotal, envio, otros, iva_dif_iva, porcentaje, valor, pvp, valor2;

    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }
    
    public String getDefectos() {
        return defectos;
    }

    public void setDefectos(String defectos) {
        this.defectos = defectos;
    }
    
    
    
    public String getAccesoriosIncluidos() {
        return AccesoriosIncluidos;
    }

    public void setAccesoriosIncluidos(String AccesoriosIncluidos) {
        this.AccesoriosIncluidos = AccesoriosIncluidos;
    }

    
    
    public String getTeclado() {
        if(teclado == null || teclado.equals("")){
            return "el producto no tiene teclado";
        }
        return teclado;
    }

    public void setTeclado(String teclado) {
        this.teclado = teclado;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getEsFinal() {
        return esFinal;
    }

    public void setEsFinal(String esFinal) {
        this.esFinal = esFinal;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(int idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdImpuesto() {
        return idImpuesto;
    }

    public void setIdImpuesto(int idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getEsLlegada() {
        return esLlegada;
    }

    public void setEsLlegada(String esLlegada) {
        this.esLlegada = esLlegada;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getCiclos() {
        return ciclos;
    }

    public void setCiclos(String ciclos) {
        this.ciclos = ciclos;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public boolean isVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(boolean visibilidad) {
        this.visibilidad = visibilidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public double getEnvio() {
        return envio;
    }

    public void setEnvio(double envio) {
        this.envio = envio;
    }

    public double getOtros() {
        return otros;
    }

    public void setOtros(double otros) {
        this.otros = otros;
    }

    public double getIva_dif_iva() {
        return iva_dif_iva;
    }

    public void setIva_dif_iva(double iva_dif_iva) {
        this.iva_dif_iva = iva_dif_iva;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public double getValor2() {
        return valor2;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }

    public Producto(int idProducto, int idDisponibilidad, int idCategoria, int idImpuesto, int numPedido, int idTienda, int cantidad, String sku, String numSerie, String detalles, String esLlegada, String notas, String ciclos, Date fechaCompra, boolean visibilidad, double costo, double costoTotal, double envio, double otros, double iva_dif_iva, double porcentaje, double valor, double pvp, double valor2,String nombreProducto,String color) {
        this.nombreProducto=nombreProducto;
        this.idProducto = idProducto;
        this.idDisponibilidad = idDisponibilidad;
        this.idCategoria = idCategoria;
        this.idImpuesto = idImpuesto;
        this.numPedido = numPedido;
        this.idTienda = idTienda;
        this.cantidad = cantidad;
        this.sku = sku;
        this.numSerie = numSerie;
        this.detalles = detalles;
        this.esLlegada = esLlegada;
        this.notas = notas;
        this.ciclos = ciclos;
        this.fechaCompra = fechaCompra;
        this.visibilidad = visibilidad;
        this.costo = costo;
        this.costoTotal = iva_dif_iva + costo + envio + otros;
        this.envio = envio;
        this.otros = otros;
        this.iva_dif_iva = ((pvp - costo) / 1.21) * 0.21;
        this.porcentaje = ((valor / costoTotal - 1) * 100);
        this.valor = (cantidad == 1) ? 1 : 0;
        this.pvp = pvp;
        this.valor2 = valor - costoTotal;
    }

    public Producto() {
    }

}
