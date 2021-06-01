/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.modelo;

import java.util.ArrayList;

/**
 *
 * @author Guanat
 */
public class Usuario {

    private int idUsuario;
    private String nombreUsuario;
    private int idrol;
    private String password;
    private String email;
    private ArrayList<Permiso> listapermiso;
    
    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario(int idUsuario, String nombreUsuario, int  idRol, String password, String email) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idrol= idRol;
        this.password = password;
        this.email = email;
    }

    public Usuario() {
    }

}
