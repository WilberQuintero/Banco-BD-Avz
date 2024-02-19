
package dao;

import Excepciones.PersistenciaException;
import dto.DireccionDTO;
import entidadesdominio.Direccion;
import java.util.List;

/**
 *
 * @author Wilber
 */
public interface IDireccionDAO {
    
    public Direccion agregarDireccion(DireccionDTO direccion) throws PersistenciaException;
    public Direccion actualizarDireccion(Direccion direccion) throws PersistenciaException;
    public Direccion consultarDireccion(int id) throws PersistenciaException;
    public Direccion consultarDireccionMasNueva() throws PersistenciaException;
    public List<Direccion> consultarTodasDirecciones() throws PersistenciaException;
    public int consultarIdDireccion(DireccionDTO direccion) throws PersistenciaException;
       
}
