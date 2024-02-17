
package dao;

import ConexionBD.IConexionBD;
import Excepciones.PersistenciaException;
import dto.DireccionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import entidadesdominio.Direccion;
import java.sql.Statement;
import java.util.ArrayList;
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
    public Direccion agregarDireccion(DireccionDTO direccion) throws PersistenciaException {
        
        String codigoSQL = "INSERT INTO DIRECCIONES (calle, colonia, numero) VALUES (?,?,?)";

        try (    Connection conexion = this.conexionBD.crearConexion(); // establecemos la conexion con la bd
                 PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {

            // 3. mandar los valores de la dirección al comandoSQL
            comandoSQL.setString(1, direccion.getCalle());
            comandoSQL.setString(2, direccion.getColonia());
            comandoSQL.setString(3, direccion.getNumero());

            // 4. Ejecutamos el comando o lo enviamos a la BD
            int registros = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con éxito {0} registros", registros);

            // obtener el conjunto de resultados que tiene o contiene las llaves generadas durante el registro o inserción
            ResultSet registro = comandoSQL.getGeneratedKeys();

            // nos posicionamos en el primer registro o en el siguiente disponible.
            registro.next();

            Direccion direccionNueva = new Direccion(
               registro.getInt(1),
                    direccion.getCalle(),
                   direccion.getColonia(),
                   direccion.getNumero()
            );
            // regresamos la dirección
            return direccionNueva;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agregó con éxito la dirección", e);
            throw new PersistenciaException("No se pudo guardar la dirección ", e);
        }
    }
    

    
    @Override
    public Direccion actualizarDireccion(Direccion direccion) throws PersistenciaException {

        String codigoSQL = "UPDATE DIRECCIONES SET CALLE=?, COLONIA=?, NUMERO=? WHERE id=?";
        
        try (Connection conexion = this.conexionBD.crearConexion();
            PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {
            
           comandoSQL.setString(1, direccion.getCalle());
           comandoSQL.setString(2, direccion.getColonia());
           comandoSQL.setString(3,direccion.getNumero());
           
           int registros = comandoSQL.executeUpdate();
           LOG.log(Level.INFO, "Se actualizó con exito {0} ", registros);
       return consultarDireccion(direccion.getDireccion_id());
           
        } catch (Exception e){
           LOG.log(Level.SEVERE, "No se pudo actualizar la direccion", e);
           throw new PersistenciaException("No se pudo actualizar la direccion ", e);
        }
        
        
    }

    
    @Override
     public Direccion consultarDireccion(int id) throws PersistenciaException {
  
            String codigoSQL = "SELECT * FROM DIRECCIONES WHERE id=?";

             try (Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            comandoSQL.setInt(1, id);
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
String codigoSQL = "SELECT * FROM DIRECCIONES";
        List<Direccion> direccionesLista = new ArrayList<>();

       try (Connection conexion = conexionBD.crearConexion();
         PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL);

               ResultSet resultado = comandoSQL.executeQuery()) {

           while (resultado.next()) {
                int direccion_id = resultado.getInt("direccion_id");
                String calle = resultado.getString("calle");
                String colonia = resultado.getString("colonia");
                String numero = resultado.getString("numero");


                Direccion direccion = new Direccion(direccion_id, calle, colonia, numero);
                direccionesLista.add(direccion);
            }

            LOG.log(Level.INFO, "Se consultaron {0} clientes", direccionesLista.size());
            return direccionesLista;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudieron obtener los clientes", e);
            throw new PersistenciaException("No se pudieron consultar los clientes", e);
        }
    }
     
}
    

