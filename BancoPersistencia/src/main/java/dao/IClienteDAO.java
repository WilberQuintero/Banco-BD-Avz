
package dao;

import Excepciones.PersistenciaException;
import entidadesdominio.Cliente;
import java.util.List;


/**
 *
 * @author Wilber
 */
public interface IClienteDAO {
    
     public Cliente agregar(Cliente cliente) throws PersistenciaException;
     public Cliente actualizar (Cliente cliente) throws PersistenciaException;
     public Cliente consultarCliente (int id) throws PersistenciaException;
     public List<Cliente> consultarTodosClientes() throws PersistenciaException;
   
        
    }
