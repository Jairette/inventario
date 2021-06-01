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
public class Disponibilidad {

    private int idDisponibilidad = -1;
    private String nombreDisponibilidad;

    public int getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(int idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public String getNombreDisponibilidad() {
        return nombreDisponibilidad;
    }

    public void setNombreDisponibilidad(String nombreDisponibilidad) {
        this.nombreDisponibilidad = nombreDisponibilidad;
    }

    public Disponibilidad(int idDisponibilidad, String nombreDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
        this.nombreDisponibilidad = nombreDisponibilidad;
    }

    public Disponibilidad() {
    }

}
