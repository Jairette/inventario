/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Guanat
 */
public class Conexion {

    Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventario", "admin", "admin");
            System.out.println("conexion establecida");
        } catch (Exception e) {
            System.err.println("Error al establecer la conexion" + e);
        }
    }

    public Connection getConnextion() {
        return con;
    }

}
