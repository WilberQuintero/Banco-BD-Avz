
package dao;

import entidadesdominio.Cliente;
import ConexionBD.ConexionBD;
import ConexionBD.IConexionBD;
import Excepciones.PersistenciaException;
import dto.ClienteDTO;
import dto.UsuarioDTO;
import entidadesdominio.Cliente;
import java.sql.Connection;
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
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
   
  String codigoSQL ="INSERT INTO CLIENTES(nombre, apellidoPaterno, apellidoMaterno, fechaNaci, direccion_id, usuario_id) VALUES (?,?,?,?,?,?)";
  
         try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {

            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setString(4, cliente.getFechaNac());
            comandoSQL.setInt(5, cliente.getUsuario_id());
            comandoSQL.setInt(6, cliente.getDireccion_id());
     
            
            // 4. Ejecutamos el comando o lo enviamos a la BD
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con éxito {0} clientes ", registrosModificados);
            
            // obtener primer registro
            ResultSet res = comandoSQL.getGeneratedKeys();
            
            //nos posicionamos en el primero lugar o en la primera posicion de los resultados
            res.next();
            
            //Creamos el activista que vamos a registrar
            Cliente clienteGuardado = new Cliente(res.getInt(1), cliente.getNombre(),
                    cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), 
                    cliente.getFechaNac(), cliente.getUsuario_id(), cliente.getDireccion_id()
            );
            
            return clienteGuardado;
            
     } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agregó con éxito el cliente", e);
            throw new PersistenciaException("No se pudo guardar el cliente ", e);
        }
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws PersistenciaException {

            String codigoSQL = "UPDATE CLIENTES SET nombre=?, apellidoPaterno=?, apellidoMaterno=? WHERE cliente_id=?";

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setInt(4, cliente.getCliente_id());
              

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

         String codigoSQL = "SELECT * FROM clientes WHERE cliente_id = ?";
  
    try (Connection conexion = conexionBD.crearConexion();
         PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

        comandoSQL.setInt(1, id);
        // Ejecutamos el comando
        try (ResultSet resultado = comandoSQL.executeQuery()) {
            if (resultado.next()) {
                Cliente clienteConsultado = new Cliente(
                        resultado.getInt(1), 
                        resultado.getString(2), 
                        resultado.getString(3), 
                        resultado.getString(4), 
                        resultado.getString(5), 
                        resultado.getInt(6), 
                        resultado.getInt(7)
                );
                return clienteConsultado;
            } else {
                throw new PersistenciaException("Cliente no encontrado");
            }
        }
    } catch (Exception e) {
        LOG.log(Level.SEVERE, "No se pudo consultar el cliente", e);
        throw new PersistenciaException("Error al consultar el cliente", e);
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
                String fechaNac = resultado.getString("fechaNac");
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
   
//   cliente_id int primary key auto_increment,
//nombre varchar (100) not null,
//apellidoPaterno varchar (100) not null,
//apellidoMaterno varchar (100),
//fechaNaci date not null,
//direccion_id int,
//usuario_id int,
   
   @Override
    public int consultarIdCliente(ClienteDTO cliente) throws PersistenciaException {
        String codigoSQL = "SELECT cliente_id FROM clientes WHERE nombre = (?) and apellidoPaterno = (?) and apellidoMaterno = (?)"
                + " and fechaNaci = (?) and direccion_id = (?) and usuario_id = (?)";

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setString(4, cliente.getFechaNac());
            comandoSQL.setInt(5, cliente.getDireccion_id());
            comandoSQL.setInt(6, cliente.getUsuario_id());
            ResultSet resultado = comandoSQL.executeQuery();
          
            resultado.next();
            
            int idConsultada = resultado.getInt(1);
            
            
            return idConsultada;
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "cliente_id no encontrada", e);
            throw new PersistenciaException("No se ha encontrado ningún cliente_id", e);
        }
    }

    @Override
    public Cliente consultarClienteMasNuevo() throws PersistenciaException {
        String codigoSQL = "SELECT * FROM CLIENTES order by cliente_id desc limit 1;";

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {
            ResultSet resultado = comandoSQL.executeQuery();
          
            resultado.next();

           Cliente clienteConsultado = new Cliente(
        resultado.getString(1),
        resultado.getString(2),
        resultado.getString(3),
        resultado.getString(4),
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
    public int consultarIdCliente(int usuario_id) throws PersistenciaException {
        String codigoSQL = "SELECT cliente_id FROM clientes WHERE usuario_id = (?)";

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            comandoSQL.setInt(1, usuario_id);
            ResultSet resultado = comandoSQL.executeQuery();
          
            resultado.next();
            
            int idConsultada = resultado.getInt(1);
            
            
            return idConsultada;
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "cliente_id no encontrada", e);
            throw new PersistenciaException("No se ha encontrado ningún cliente_id", e);
        }
    }

    @Override
    public int consultarEdadCliente(int cliente_id) throws PersistenciaException {
        String codigoSQL = "select year(now()) - year(fechanaci) - \n"
                + "    case "
                + "        when month(now()) < month(fechanaci) or  "
                + "             (month(now()) = month(fechanaci) and day(now()) < day(fechanaci)) "
                + "        then 1 "
                + "        else 0 "
                + "    end as Edad "
                + "from clientes "
                + "where cliente_id = ?";
        
        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            comandoSQL.setInt(1, cliente_id);
            ResultSet resultado = comandoSQL.executeQuery();
          
            resultado.next();
            
            int idConsultada = resultado.getInt(1);
            
            
            return idConsultada;
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Edad no encontrada", e);
            throw new PersistenciaException("No se ha encontrado ningua edad", e);
        }
        
        
    }
   
   }
   


 

    