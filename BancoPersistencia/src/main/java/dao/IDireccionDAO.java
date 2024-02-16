
package dao;

import Excepciones.PersistenciaException;
import entidadesdominio.Direccion;
import java.util.List;

/**
 *
 * @author Wilber
 */
public interface IDireccionDAO {
    
    public Direccion agregar(Direccion cliente) throws PersistenciaException;
    public Direccion actualizar(Direccion cliente) throws PersistenciaException;
    public Direccion consultarDireccion(int id) throws PersistenciaException;
    public List<Direccion> consultarTodasDirecciones() throws PersistenciaException;

       
}
