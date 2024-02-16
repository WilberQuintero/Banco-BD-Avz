/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import Excepciones.PersistenciaException;
import dto.UsuarioDTO;
import entidadesdominio.Usuario;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IUsuarioDAO {
    public Usuario agregarUsuario(UsuarioDTO usuario) throws PersistenciaException;
     public Usuario consultarUsuario (int id) throws PersistenciaException;
     public List<Usuario> consultarTodosUsuarios() throws PersistenciaException;
    
}
