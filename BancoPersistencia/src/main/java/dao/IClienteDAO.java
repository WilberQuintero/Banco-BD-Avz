
package dao;

import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Wilber
 */
public interface IClienteDAO {
    
     public ClienteDAO agregar(ClienteDAO cliente) throws PersistenciaException;
    public ClienteDAO actualizar(ClienteDAO cliente) throws PersistenciaException;
    public void eliminar (int id) throws PersistenciaException;
    public ClienteDAO consultar(int id) throws PersistenciaException;
    public List<ClienteDAO> consultarTodos() throws PersistenciaException;
}
