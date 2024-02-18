
package ControladorPersistencia;

import ConexionBD.ConexionBD;
import ConexionBD.IConexionBD;
import Excepciones.PersistenciaException;
import dao.ClienteDAO;
import dao.CuentaDAO;
import dao.DireccionDAO;
import dao.IClienteDAO;
import dao.ICuentaDAO;
import dao.IDireccionDAO;
import dao.IRetiroSinCuentaDAO;
import dao.ITransferenciaDAO;
import dao.IUsuarioDAO;
import dao.RetiroSinCuentaDAO;
import dao.TransferenciaDAO;
import dao.UsuarioDAO;
import dto.ClienteDTO;
import dto.CuentaDTO;
import dto.DireccionDTO;
import dto.RetiroSinCuentaDTO;
import dto.TransferenciaDTO;
import dto.UsuarioDTO;
import entidadesdominio.Cliente;
import entidadesdominio.Cuenta;
import entidadesdominio.Direccion;
import entidadesdominio.RetiroSinCuenta;
import entidadesdominio.Transferencia;
import entidadesdominio.Usuario;
import java.util.List;

/**
 *
 * @author Wilber
 */
public class ControladorPersistencia implements IControladorPersistencia{
   
    String cadenaConexion = "jdbc:mysql://localhost:3306/Avance1BD";
    String usuario = "root";
    String contra = "23929Ast";
    
    IConexionBD conexionBD = new ConexionBD(cadenaConexion, usuario, contra);
    IUsuarioDAO usuarioDAO = new UsuarioDAO(conexionBD);
    IDireccionDAO direccionDAO = new DireccionDAO(conexionBD);
    IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
    ITransferenciaDAO transferenciaDAO = new TransferenciaDAO(conexionBD);
    IRetiroSinCuentaDAO retiroDAO = new RetiroSinCuentaDAO(conexionBD);
    ICuentaDAO cuentaDAO = new CuentaDAO (conexionBD);
    
    // -- CUENTA
      public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException {
          Cuenta cuentaAgregada = this.cuentaDAO.agregarCuenta(cuenta);
          return cuentaAgregada;
      }
      
    public Cuenta consutarCuenta(int cuenta_id) throws PersistenciaException {
        Cuenta cuentaConsultada = this.cuentaDAO.consutarCuenta(cuenta_id);
        return cuentaConsultada;
    }
    
    public List<Cuenta> consutarTodosCuenta() throws PersistenciaException {
        return this.cuentaDAO.consutarTodosCuenta();
    }
            
    
    // -- CLIENTE
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
        Cliente clienteAgregado = this.clienteDAO.agregarCliente(cliente);
        return clienteAgregado;
    }
    
     public Cliente actualizarCliente (Cliente cliente) throws PersistenciaException {
         Cliente clienteActualizado = this.clienteDAO.actualizarCliente(cliente);
         return clienteActualizado;
     }
     
     public Cliente consultarCliente (int id) throws PersistenciaException {
         Cliente clienteConsultado = this.clienteDAO.consultarCliente(id);
         return clienteConsultado;
     }
     
     public List<Cliente> consultarTodosClientes() throws PersistenciaException {
         return this.clienteDAO.consultarTodosClientes();
     }
           
     
     // -- DIRECCION
       public Direccion agregarDireccion(DireccionDTO direccion) throws PersistenciaException {
           Direccion direccionAgregada = this.direccionDAO.agregarDireccion(direccion);
           return direccionAgregada;
       }
       
    public Direccion actualizarDireccion(Direccion direccion) throws PersistenciaException {
        Direccion direccionActualizada = this.direccionDAO.actualizarDireccion(direccion);
        return direccionActualizada;
    }
    
    public Direccion consultarDireccion(int id) throws PersistenciaException {
        Direccion direccionConsultada = this.direccionDAO.consultarDireccion(id);
        return direccionConsultada;
    }
    
    public List<Direccion> consultarTodasDirecciones() throws PersistenciaException {
         return this.direccionDAO.consultarTodasDirecciones();
    }
     
     public RetiroSinCuenta agregarRetiro(RetiroSinCuentaDTO retiro) throws PersistenciaException {
         RetiroSinCuenta retiroAgregado = this.retiroDAO.agregarRetiro(retiro);
         return retiroAgregado;
     }
     
     public RetiroSinCuenta consultarRetiro (int transaccion_id) throws PersistenciaException {
         RetiroSinCuenta retiroConsultado = this.retiroDAO.consultarRetiro(transaccion_id);
         return retiroConsultado;
     }
     
     public List<RetiroSinCuenta> consultarTodosRetiros() throws PersistenciaException {
         return this.retiroDAO.consultarTodosRetiros();
     }
    
     
    // -- TRANSFERENCIA
     public Transferencia agregarTransferencia(Transferencia transferencia) throws PersistenciaException {
         Transferencia transferenciaAgregada = this.transferenciaDAO.agregarTransferencia(transferencia);
         return transferenciaAgregada;
     }
     
        public Transferencia consultarTransferencia(int id) throws PersistenciaException {
            Transferencia transferenciaConsultada = this.transferenciaDAO.consultarTransferencia(id);
            return transferenciaConsultada;
        }
        
        public List<Transferencia> consultarTodasTransferencia() throws PersistenciaException {
            return this.transferenciaDAO.consultarTodasTransferencia();
        }
        
        
   // -- USUARIO   
       public Usuario agregarUsuario(UsuarioDTO usuario) throws PersistenciaException {
         Usuario usuarioAgregado = this.usuarioDAO.agregarUsuario(usuario);
         return usuarioAgregado;
        }
       
     public Usuario consultarUsuario (int id) throws PersistenciaException {
         Usuario usuarioConsultado = this.usuarioDAO.consultarUsuario(id);
         return usuarioConsultado;
     }
     
     public List<Usuario> consultarTodosUsuarios() throws PersistenciaException {
         return this.usuarioDAO.consultarTodosUsuarios();
     }
     
     public int consultarIdCliente(ClienteDTO cliente)throws PersistenciaException{
         return this.clienteDAO.consultarIdCliente(cliente);
     }
     
     public int consultarIdUsuario(UsuarioDTO usuario)throws PersistenciaException{
         return this.usuarioDAO.consultarIdUsuario(usuario);
     }
     
     public int consultarIdCuenta(CuentaDTO cuenta)throws PersistenciaException{
         return this.cuentaDAO.consultarIdCuenta(cuenta);
     }
     
     public int consultarIdDireccion(DireccionDTO direccion)throws PersistenciaException{
         return this.direccionDAO.consultarIdDireccion(direccion);
     }
     
     public int consultarIdRetiroSC(RetiroSinCuentaDTO retiro)throws PersistenciaException{
         return this.retiroDAO.consultarIdRetiro(retiro);
     }
     
     public int consultarIdTransferencia(TransferenciaDTO transferencia)throws PersistenciaException{
         return this.transferenciaDAO.consultarIdTransferencia(transferencia);
     }
     
    
}
