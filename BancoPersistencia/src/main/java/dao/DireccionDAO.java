
package dao;

import ConexionBD.IConexionBD;
import Excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import entidadesdominio.Direccion;
import java.util.List;
import java.util.logging.Logger;


/**
 *
 * @author Wilber
 */
public class DireccionDAO implements IDireccionDAO{
    
    final IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(DireccionDAO.class.getName());

    
    public DireccionDAO(IConexionBD conexion) {
        
    
        this.conexionBD = conexion;
    }
    

    @Override
    public Direccion agregar(Direccion cliente) throws PersistenciaException {

    }

    
    @Override
    public Direccion actualizar(Direccion cliente) throws PersistenciaException {

    }

    
     public Direccion consultarDireccion(int direccionId) throws PersistenciaException {
  
            String consulta = "SELECT * FROM DIRECCIONES WHERE id = (?)";

             try (Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(consulta)) {

            comandoSQL.setInt(1, direccionId);
            ResultSet resultado = comandoSQL.executeQuery();

            resultado.next();

            Direccion direccionConsultada = new Direccion(
                    resultado.getString(1),
                    resultado.getString(2),
                    resultado.getString(3)

            );

            return direccionConsultada;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Dirección no encontrada", e);
            throw new PersistenciaException("No se ha encontrado ninguna dirección", e);
        }    
    
    }
     
     
    @Override
    public List<Direccion> consultarTodasDirecciones() throws PersistenciaException {

    }

    
}
    

