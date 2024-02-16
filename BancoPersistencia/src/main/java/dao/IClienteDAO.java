
package dao;

import Excepciones.PersistenciaException;
import entidadesdominio.Cliente;
import java.util.List;


/**
 *
 * @author Wilber
 */
public interface IClienteDAO {
    
     public Cliente agregarTransferencia(Cliente cliente) throws PersistenciaException;
     public Cliente actualizarCliente (Cliente cliente) throws PersistenciaException;
     public Cliente consultarCliente (int id) throws PersistenciaException;
     public List<Cliente> consultarTodosClientes() throws PersistenciaException;
   
        
    }
