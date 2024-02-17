
package dao;

import Excepciones.PersistenciaException;
import entidadesdominio.Direccion;
import entidadesdominio.Transferencia;
import java.util.List;

/**
 *
 * @author Wilber
 */
public interface ITransferenciaDAO {
    
        public Transferencia agregarTransferencia(Transferencia transferencia) throws PersistenciaException;
        public Transferencia consultarTransferencia(int id) throws PersistenciaException;
        public List<Transferencia> consultarTodasTransferencia() throws PersistenciaException;

   
}
