/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import Controlador.ControladorNegocio;
import Excepciones.PersistenciaException;
import dto.UsuarioDTO;

/**
 *
 * @author Usuario
 */
public class prueba {
    public static void main(String[] args) throws PersistenciaException {
        ControladorNegocio con = new ControladorNegocio();
        
        System.out.println(con.encriptar("23929Ast"));
        System.out.println(con.desEncriptar("Rn8sRwT0lDzAvR33ws12uw=="));
        
        int id = con.consultarIdUsuario(new UsuarioDTO("Gaino", "Rn8sRwT0lDzAvR33ws12uw=="));
        System.out.println(id);
        
        //System.out.println(con.consultarIdUsuario(new UsuarioDTO("Gaino", con.desEncriptar("Rn8sRwT0lDzAvR33ws12uw==")));
        //System.out.println(con.consultarUsuario(1).getNombreUsusario());
        
        
        
    }
}
