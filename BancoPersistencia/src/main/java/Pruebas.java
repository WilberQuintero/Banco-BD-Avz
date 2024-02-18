
import ControladorPersistencia.ControladorPersistencia;
import Excepciones.PersistenciaException;
import dto.UsuarioDTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Pruebas {
    public static void main(String[] args) throws PersistenciaException {
        ControladorPersistencia con = new ControladorPersistencia();
        UsuarioDTO u = new UsuarioDTO("Gaino", "Rn8sRwT0lDzAvR33ws12uw==");
        System.out.println();
    }
}
