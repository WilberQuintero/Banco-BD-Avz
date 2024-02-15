
package dao;

import ConexionBD.IConexionBD;
import Excepciones.PersistenciaException;
import dto.ClienteDTO;
import entidadesdominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    final IConexionBD conexionBD;
    
    public ClienteDAO(IConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }

    public IConexionBD getConexionBD() {
        return conexionBD;
    }
    
    @Override
    public Cliente insertar(Cliente cliente) throws PersistenciaException {
      
        String sentenciaSQL ="INSERT INTO CLIENTES(nombre, apellido_paterno, apellido_materno, fecha_nacimiento, usuario, contrasenia, id_domicilio) VALUES (?,?,?,?,?,?,?)";
        
        try
            (Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);
               
                ){
            
            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2,cliente.getApellidoPaterno());
            comandoSQL.setString(3,cliente.getApellidoMaterno());
            comandoSQL.setDate(4, cliente.getFechaNac());
            comandoSQL.setUsuario(5, cliente.getUsuario());
            comandoSQL.setInt(6, cliente.getDireccion());
            comandoSQL.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
              LOG.log(Level.INFO, "Se agregaron con éxito {0} ", registrosModificados);
           int registrosModificados = comandoSQL.executeUpdate();
                return cliente;
            }
            throw new PersistenciaException("Cliente registrado pero ID no generado");
        }catch(SQLException e){
            System.err.println(e.getMessage());
            throw new PersistenciaException("No fue posible registrar al cliente");
        }          
    }

    @Override
    public Cliente consultarCuenta(Cliente cliente) {
        Cliente clienteLog = null;
        String codigoSQL = "SELECT id,nombre,apellido_paterno,apellido_materno,fecha_nacimiento,usuario,contrasenia,id_domicilio FROM CLIENTES WHERE usuario=? AND contrasenia= ?";
    
        try(
            Connection conexion = this.conexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);  
            )   
            
        {
            comando.setString(1, cliente.getUsuario());
            comando.setString(2, cliente.getContrasenia());

            ResultSet resultado = comando.executeQuery();

            
        if(resultado.next()){
            Integer id = resultado.getInt("id");
            String nombre = resultado.getString("nombre");
            String apellidoPaterno = resultado.getString("apellido_paterno");
            String apellidoMaterno = resultado.getString("apellido_materno");
            Date fecha_nac = resultado.getDate("fecha_nacimiento");
            String usuarioLog = resultado.getString("usuario");
            String contrasenia = resultado.getString("contrasenia");
            Integer idDireccion = resultado.getInt("id_domicilio");
            clienteLog = new Cliente(id,nombre,apellidoPaterno,apellidoMaterno,fecha_nac,usuarioLog,contrasenia,idDireccion);
        }
        
        return clienteLog;
        }catch(SQLException ex){

            return null;
        }
    }

    @Override
    public Cliente actualizar(Cliente cliente) throws PersistenciaException {
        String codigoSQL = "UPDATE CLIENTES SET nombres=?, apellido_paterno=?,apellido_materno=?,fecha_nacimiento=?,usuario=?,contrasenia=?,id_domicilio=? WHERE id=?;";
        
        try(
            Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            )
        
        {
            comando.setString(1,cliente.getNombre());
            comando.setString(2, cliente.getApellido_paterno());
            comando.setString(3,cliente.getApellido_materno());
            comando.setDate(4, cliente.getFecha_nacimiento());
            comando.setString(5, cliente.getUsuario());
            comando.setString(6, cliente.getContrasenia());
            comando.setInt(7, cliente.getIdDireccion());
            comando.setInt(8, cliente.getId());
            
            ResultSet resultado = comando.executeQuery();
            comando.executeUpdate();
        
        if(resultado.next()){
            String nombre = resultado.getString("nombre");
            String apellido_paterno = resultado.getString("apellido_paterno");
            String apellido_materno = resultado.getString("apellido_materno");
            Date fecha_nac = resultado.getDate("fecha_nacimiento");
            String user = resultado.getString("usuario");
            String contra = resultado.getString("contrasenia");
            Integer id_direccion = resultado.getInt("id_direccion");
            cliente = new Cliente(nombre,apellido_paterno,apellido_materno,fecha_nac,user,contra,id_direccion);

        }
        return cliente;
       
        }catch(SQLException ex){
            
            return null;
        }
    }

    @Override
    public ClienteDAO agregar(ClienteDAO cliente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClienteDAO consultar(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ClienteDAO> consultarTodos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClienteDAO actualizar(ClienteDAO cliente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
