/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import ConexionBD.IConexionBD;
import Excepciones.PersistenciaException;
import dto.UsuarioDTO;
import entidadesdominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO implements IUsuarioDAO{
    final IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(UsuarioDAO.class.getName());
    
    public UsuarioDAO(IConexionBD conexion){
        this.conexionBD = conexion;
    }

    @Override
    public Usuario agregarUsuario(UsuarioDTO usuario) throws PersistenciaException {
        String codigoSQL = "insert into usuarios(nombreUsuario, contra) values(?,?);";
        try (Connection conexion = this.conexionBD.crearConexion();
               PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL, 
                       Statement.RETURN_GENERATED_KEYS);)
        {
            comandoSQL.setString(1, usuario.getNombreUsusario());
            comandoSQL.setString(2, usuario.getContra());
            int resultado = comandoSQL.executeUpdate();
            
             LOG.log(Level.INFO, "Se han agregado {0} ", resultado);
            
            // obtener primer registro
            ResultSet res = comandoSQL.getGeneratedKeys();
            
            //nos posicionamos en el primero lugar o en la primera posicion de los resultados
            res.next();
            
            //Creamos el activista que vamos a registrar
            Usuario usuarioGuardado = new Usuario(res.getInt(1), usuario.getNombreUsusario(), usuario.getContra());
            
            return usuarioGuardado;
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar el usuario");
            throw new PersistenciaException("No se pudo agregar el usuario", e);
        }
    }

    @Override
    public Usuario consultarUsuario(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> consultarTodosUsuarios() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
