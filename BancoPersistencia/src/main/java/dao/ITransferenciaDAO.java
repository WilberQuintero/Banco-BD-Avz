
package dao;

import Excepciones.PersistenciaException;
import dto.TransferenciaDTO;
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
        public Transferencia consultarTransferenciaMasNueva() throws PersistenciaException;
        public List<Transferencia> consultarTodasTransferencia() throws PersistenciaException;
        public int consultarIdTransferencia(TransferenciaDTO transferencia) throws PersistenciaException; 

   
}
