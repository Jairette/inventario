/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.modelo;

/**
 *
 * @author macniacos
 */
public class Permiso {
    private int idPermiso = -1;
    private String nombrePermiso;

    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombre) {
        this.nombrePermiso = nombre;
    }

    public Permiso(int idPermiso, String nombrePermiso) {
        this.idPermiso= idPermiso;
        this.nombrePermiso = nombrePermiso;
    }

    public Permiso() {
    }
    
}
