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
public class Impuesto {

    private int idImpuesto = -1;
    private String nombreImpuesto;

    public int getIdImpuesto() {
        return idImpuesto;
    }

    public void setIdImpuesto(int idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

    public String getNombreImpuesto() {
        return nombreImpuesto;
    }

    public void setNombreImpuesto(String nombreImpuesto) {
        this.nombreImpuesto = nombreImpuesto;
    }

    public Impuesto(int idImpuesto, String nombreImpuesto) {
        this.idImpuesto = idImpuesto;
        this.nombreImpuesto = nombreImpuesto;
    }

    public Impuesto() {
    }

}
