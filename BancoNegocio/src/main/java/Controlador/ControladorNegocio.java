
package Controlador;

import ControladorPersistencia.ControladorPersistencia;
import Encriptacion.Encriptador;
import Excepciones.PersistenciaException;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ControladorNegocio {
    ControladorPersistencia controlador = new ControladorPersistencia();
    
    // -- CUENTA
      public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException {
          Cuenta cuentaAgregada = controlador.agregarCuenta(cuenta);
          return cuentaAgregada;
      }
      
    public Cuenta consutarCuenta(int cuenta_id) throws PersistenciaException {
        Cuenta cuentaConsultada = controlador.consutarCuenta(cuenta_id);
        return cuentaConsultada;
    }
    
    public List<Cuenta> consutarTodosCuenta() throws PersistenciaException {
        return controlador.consutarTodosCuenta();
    }
    
    public int consultarIdCuenta(CuentaDTO cuenta) throws PersistenciaException{
        return controlador.consultarIdCuenta(cuenta);
    }
            
    
    // -- CLIENTE
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
        Cliente clienteAgregado = controlador.agregarCliente(cliente);
        return clienteAgregado;
    }
    
     public Cliente actualizarCliente (Cliente cliente) throws PersistenciaException {
         Cliente clienteActualizado = controlador.actualizarCliente(cliente);
         return clienteActualizado;
     }
     
     public Cliente consultarCliente (int id) throws PersistenciaException {
         Cliente clienteConsultado = controlador.consultarCliente(id);
         return clienteConsultado;
     }
     
     public List<Cliente> consultarTodosClientes() throws PersistenciaException {
         return controlador.consultarTodosClientes();
     }
     
     public int consultarIdCliente(ClienteDTO cliente) throws PersistenciaException {
        return controlador.consultarIdCliente(cliente);
    }
     
     public int consultarIdCliente(int usuario_id) throws PersistenciaException {
         return controlador.consultarIdCliente(usuario_id);
     }
     
     public int consultarEdadCliente(int cliente_id) throws PersistenciaException{
         return controlador.consultarEdadCliente(cliente_id);
     }
           
     
     // -- DIRECCION
       public Direccion agregarDireccion(DireccionDTO direccion) throws PersistenciaException {
           Direccion direccionAgregada = controlador.agregarDireccion(direccion);
           return direccionAgregada;
       }
       
    public Direccion actualizarDireccion(Direccion direccion) throws PersistenciaException {
        Direccion direccionActualizada = controlador.actualizarDireccion(direccion);
        return direccionActualizada;
    }
    
    public Direccion consultarDireccion(int id) throws PersistenciaException {
        Direccion direccionConsultada = controlador.consultarDireccion(id);
        return direccionConsultada;
    }
    
    public List<Direccion> consultarTodasDirecciones() throws PersistenciaException {
         return controlador.consultarTodasDirecciones();
    }
    
    public int consultarIdDireccion(DireccionDTO direccion) throws PersistenciaException {
        return controlador.consultarIdDireccion(direccion);
    }
    
    
    // Retiro sin cuenta 
     public RetiroSinCuenta agregarRetiro(RetiroSinCuentaDTO retiro) throws PersistenciaException {
         RetiroSinCuenta retiroAgregado = controlador.agregarRetiro(retiro);
         return retiroAgregado;
     }
     
     public RetiroSinCuenta consultarRetiro (int transaccion_id) throws PersistenciaException {
         RetiroSinCuenta retiroConsultado = controlador.consultarRetiro(transaccion_id);
         return retiroConsultado;
     }
     
     public List<RetiroSinCuenta> consultarTodosRetiros() throws PersistenciaException {
         return controlador.consultarTodosRetiros();
     }
     
     public int consultarIdRetiro(RetiroSinCuentaDTO retiro) throws PersistenciaException {
        return controlador.consultarIdRetiroSC(retiro);
    }
    
     
    // -- TRANSFERENCIA
     public Transferencia agregarTransferencia(Transferencia transferencia) throws PersistenciaException {
         Transferencia transferenciaAgregada = controlador.agregarTransferencia(transferencia);
         return transferenciaAgregada;
     }
     
        public Transferencia consultarTransferencia(int id) throws PersistenciaException {
            Transferencia transferenciaConsultada = controlador.consultarTransferencia(id);
            return transferenciaConsultada;
        }
        
        public List<Transferencia> consultarTodasTransferencia() throws PersistenciaException {
            return controlador.consultarTodasTransferencia();
        }
        
        public int consultarIdTransferencia(TransferenciaDTO transferencia) throws PersistenciaException {
        return controlador.consultarIdTransferencia(transferencia);
        }
        
        
   // -- USUARIO   
       public void agregarUsuario(UsuarioDTO usuario) throws PersistenciaException {
         controlador.agregarUsuario(usuario);
        }
       
     public Usuario consultarUsuario (int id) throws PersistenciaException {
         return controlador.consultarUsuario(id);
     }
     
     public List<Usuario> consultarTodosUsuarios() throws PersistenciaException {
         return controlador.consultarTodosUsuarios();
     }
     
     public int consultarIdUsuario(UsuarioDTO usuario) throws PersistenciaException {
        return controlador.consultarIdUsuario(usuario);
        }
     
     /*public void agregarClientePrimeraVez(DireccionDTO direccion, 
             UsuarioDTO usuario, ClienteDTO cliente, CuentaDTO cuenta) throws PersistenciaException{
         //Agrega direccion
         this.agregarDireccion(direccion);
         
         //Agregar Usuario
         this.agregarUsuario(usuario);
            
            //Agregamos al Cliente
            this.agregarCliente(cliente);
            
            //agregamos la cuenta
            this.agregarCuenta(cuenta);
     }*/
     
     public void agregarDirecYUsuaPrimeraVez(DireccionDTO direccion, UsuarioDTO usuario) throws PersistenciaException{
         this.agregarDireccion(direccion);
         this.agregarUsuario(usuario);
         
     }
     
     public Cliente consultarClienteMasNuevo () throws PersistenciaException{
         return controlador.consultarClienteMasNuevo();
     }
     
     public Direccion consultarDireccionMasNueva () throws PersistenciaException{
         return controlador.consultarDireccionMasNueva();
     }
     
     public Usuario consultarUsuarioMasNuevo () throws PersistenciaException{
         return controlador.consultarUsuarioMasNuevo();
     }
     
     public Transferencia consultarTransferenciaMasNueva () throws PersistenciaException{
         return controlador.consultarTransferenciaMasNueva();
     }
     
     public RetiroSinCuenta consultarRetiroMasNuevo () throws PersistenciaException{
         return controlador.consultarRetiroMasNuevo();
     }
     
     public Cuenta consultarCuentaMasNueva () throws PersistenciaException{
         return controlador.consultarCuentaMasNueva();
     }
     
     public String encriptar(String contra){
         Encriptador en = new Encriptador();
         return en.getAES(contra);
     }
     
     public String desEncriptar(String contraEncriptada){
         Encriptador en = new Encriptador();
         return en.etAESDecrypt(contraEncriptada);
     }
     
    
}
