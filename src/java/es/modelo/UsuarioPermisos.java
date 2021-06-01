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
public class UsuarioPermisos {
    
    private int idUsuario,idPermiso;
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public UsuarioPermisos(int idUsuario, int idPermiso) {
        this.idUsuario = idUsuario;
        this.idPermiso = idPermiso;
    }

    public UsuarioPermisos() {
    }
    
}
