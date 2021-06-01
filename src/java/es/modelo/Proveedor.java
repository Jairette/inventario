/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.modelo;

/**
 *
 * @author Guanat
 */
public class Proveedor {

    private int idProveedor = -1;
    private String NombreProveedor;

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return NombreProveedor;
    }

    public void setNombreProveedor(String NombreProveedor) {
        this.NombreProveedor = NombreProveedor;
    }

    public Proveedor(int idProveedor, String NombreProveedor) {
        this.idProveedor = idProveedor;
        this.NombreProveedor = NombreProveedor;
    }

    public Proveedor() {
    }

}
