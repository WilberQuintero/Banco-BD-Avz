
package dao;

import Excepciones.PersistenciaException;
import dto.ClienteDTO;
import dto.UsuarioDTO;
import entidadesdominio.Cliente;
import java.util.List;


/**
 *
 * @author Wilber
 */
public interface IClienteDAO {
    
     public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException;
     public Cliente actualizarCliente (Cliente cliente) throws PersistenciaException;
     public Cliente consultarCliente (int id) throws PersistenciaException;
     public Cliente consultarClienteMasNuevo () throws PersistenciaException;
     public List<Cliente> consultarTodosClientes() throws PersistenciaException;
     public int consultarIdCliente(ClienteDTO cliente) throws PersistenciaException;
     public int consultarIdCliente(int usuario_id) throws PersistenciaException;
     public int consultarEdadCliente(int cliente_id) throws PersistenciaException;
   
        
    }
