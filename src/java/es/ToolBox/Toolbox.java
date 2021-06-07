/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ToolBox;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guanat
 */
public class Toolbox {
    
    public static String CadenaEspecial(String cadena){
        String cadenaEspecial=null;
        byte[] cadenabytes=cadena.getBytes(Charset.forName("ISO-8859-1"));
        try {
            cadenaEspecial=new String(cadenabytes,"ISO-8859-1");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Toolbox.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadenaEspecial;
    }
}
