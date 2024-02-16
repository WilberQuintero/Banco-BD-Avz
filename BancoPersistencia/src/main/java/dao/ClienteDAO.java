
package dao;

import entidadesdominio.Cliente;
import ConexionBD.ConexionBD;
import ConexionBD.IConexionBD;
import Excepciones.PersistenciaException;
import dto.ClienteDTO;
import entidadesdominio.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wilber
 */
public class ClienteDAO implements IClienteDAO{

      private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
      private final IConexionBD conexionBD;

    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
         
         

    @Override
    public Cliente agregarTransferencia(Cliente cliente) throws PersistenciaException {
   
  String codigoSQL ="INSERT INTO CLIENTES(nombre, apellidoPaterno, apellidoMaterno, fechaNaci, direccion_id, usuario_id) VALUES (?,?,?,?,?,?,)";
  
         try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {

            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setDate(4, (Date) cliente.getFechaNac());
            comandoSQL.setInt(5, cliente.getUsuario_Id());
            comandoSQL.setInt(6, cliente.getDireccion_Id());

            comandoSQL.executeUpdate();
     
            
            // 4. Ejecutamos el comando o lo enviamos a la BD
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con éxito {0} ", registrosModificados);
            
     } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agregó con éxito el cliente", e);
            throw new PersistenciaException("No se pudo guardar el cliente ", e);
        }
          return null;
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws PersistenciaException {

            String codigoSQL = "UPDATE CLIENTES SET nombre=?, apellidoPaterno=?, apellidoMaterno=? WHERE id=?";

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setInt(4, cliente.getDireccion_Id());
              comandoSQL.setInt(7, cliente.getCliente_id());
              comandoSQL.executeUpdate();

            int registros = comandoSQL.executeUpdate();
           LOG.log(Level.INFO, "Se actualizó el cliente con éxito {0} ", registros);
           
            
            return consultarCliente(cliente.getCliente_id());

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo actualizar el cliente", e);
            throw new PersistenciaException("No se pudo actualizar el cliente ", e);
        }
    }
       

    @Override
    public Cliente consultarCliente (int id) throws PersistenciaException {

         String codigoSQL = "SELECT * FROM CLIENTES WHERE id = (?)";

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            comandoSQL.setInt(1, id);
            ResultSet resultado = comandoSQL.executeQuery();
          
            resultado.next();

           Cliente clienteConsultado = new Cliente(
        resultado.getString(1),
        resultado.getString(2),
        resultado.getString(3),
        resultado.getDate(4),
        resultado.getInt(5),
        resultado.getInt(6)
    );
           
     return clienteConsultado;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Cliente no encontrado", e);
            throw new PersistenciaException("No se ha encontrado ningún cliente", e);
        }
      }
    
    
      @Override
   public List<Cliente> consultarTodosClientes() throws PersistenciaException {
        
       String codigoSQL = "SELECT * FROM CLIENTES";
        List<Cliente> clientesLista = new ArrayList<>();

       try (Connection conexion = conexionBD.crearConexion();
         PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL);
         
               ResultSet resultado = comandoSQL.executeQuery()) {

           while (resultado.next()) {
                int id = resultado.getInt("cliente_id");
                String nombre = resultado.getString("nombre");
                String apellidoPat = resultado.getString("apellidoMaterno");
                String apellidoMat = resultado.getString("apellidoPaterno");
                Date fechaNac = resultado.getDate("fechaNac");
                int usuarioId = resultado.getInt("usuario_id");
                int direccionId = resultado.getInt("direccion_id");

                Cliente cliente = new Cliente(id, nombre, apellidoPat, apellidoMat, fechaNac, usuarioId, direccionId);
                clientesLista.add(cliente);
            }

            LOG.log(Level.INFO, "Se consultaron {0} clientes", clientesLista.size());
            return clientesLista;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudieron obtener los clientes", e);
            throw new PersistenciaException("No se pudieron consultar los clientes", e);
        }
        
    }
   
   }
   


 

    