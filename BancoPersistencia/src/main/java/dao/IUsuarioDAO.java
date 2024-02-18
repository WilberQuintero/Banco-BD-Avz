
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
     public Usuario consultarUsuarioMasNuevo () throws PersistenciaException;
     public List<Usuario> consultarTodosUsuarios() throws PersistenciaException;
     public int consultarIdUsuario(UsuarioDTO usuario) throws PersistenciaException;
    
}
