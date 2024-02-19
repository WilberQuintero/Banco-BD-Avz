/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import ConexionBD.IConexionBD;
import Excepciones.PersistenciaException;
import dto.CuentaDTO;
import entidadesdominio.Cliente;
import entidadesdominio.Cuenta;
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
 * @author Usuario
 */
public class CuentaDAO implements ICuentaDAO{
    final IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());
    
    public CuentaDAO(IConexionBD conexion){
        this.conexionBD = conexion;
    }
    
    @Override
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException {
        String codigoSQL = "insert into cuentas (cliente_id) values((?));";
        try (Connection conexion = this.conexionBD.crearConexion();
               PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL, 
                       Statement.RETURN_GENERATED_KEYS);)
        {
            comandoSQL.setInt(1, cuenta.getCliente_id());
            int resultado = comandoSQL.executeUpdate();
            
             LOG.log(Level.INFO, "Se han agregado {0} ", resultado);
            
            // obtener primer registro
            ResultSet res = comandoSQL.getGeneratedKeys();
            
            //nos posicionamos en el primero lugar o en la primera posicion de los resultados
            res.next();
            
            //Creamos el activista que vamos a registrar
            Cuenta cuentaGuardada = new Cuenta(res.getInt(1), cuenta.getNumeroCuenta(), cuenta.getFechaApertura(), cuenta.getSaldo(), cuenta.getEstado(), cuenta.getCliente_id());
            
            return cuentaGuardada;
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar la cuenta");
            throw new PersistenciaException("No se pudo agregar la cuenta", e);
        }
    }

    @Override
    public Cuenta consutarCuenta(int cuenta_id) throws PersistenciaException {
        String codigoSQL = "SELECT * FROM cuentas WHERE cuenta_id = ?";

        try (Connection conexion = conexionBD.crearConexion(); 
                PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            comandoSQL.setInt(1, cuenta_id);
            // Ejecutamos el comando
            try (ResultSet res = comandoSQL.executeQuery()) {
                if (res.next()) {
                    Cuenta cuentaConsultada = new Cuenta(
                            res.getInt(1), 
                            res.getString(2), 
                            res.getString(3), 
                            res.getInt(4), 
                            res.getString(5), 
                            res.getInt(6)
                    );
                    return cuentaConsultada;
                } else {
                    throw new PersistenciaException("Cuenta no encontrada");
                }
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo consultar la cuenta", e);
            throw new PersistenciaException("Error al consultar la cuenta", e);
        }
    }

    @Override
    public List<Cuenta> consutarTodosCuenta() throws PersistenciaException {
        String codigoSQL = "SELECT * FROM CUENTAS";
        List<Cuenta> cuentasLista = new ArrayList<>();

       try (Connection conexion = conexionBD.crearConexion();
         PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL);
         
               ResultSet resultado = comandoSQL.executeQuery()) {

           while (resultado.next()) {
                int cuenta_id = resultado.getInt("cuenta_id");
                String numeroCuenta = resultado.getString("numeroCuenta");
                String fechaApertura = resultado.getString("fechaApertura");
                float saldo = resultado.getFloat("saldo");
                String estado = resultado.getString("estado");
                int cliente_id = resultado.getInt("cliente_id");
                

                Cuenta cuenta = new Cuenta(cuenta_id, numeroCuenta, fechaApertura, saldo, estado, cliente_id);
                cuentasLista.add(cuenta);
            }

            LOG.log(Level.INFO, "Se consultaron {0} clientes", cuentasLista.size());
            return cuentasLista;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudieron obtener los clientes", e);
            throw new PersistenciaException("No se pudieron consultar los clientes", e);
        }
    }

//    cuenta_id int primary key auto_increment,
//numeroCuenta varchar (16) not null unique,
//fechaApertura date not null,
//saldo decimal (18, 2) not null default 0,
//estado enum ("Activa","Cancelada") not null default "Activa",
//cliente_id int ,
    
@Override
    public int consultarIdCuenta(CuentaDTO cuenta) throws PersistenciaException {
        String codigoSQL = "SELECT cuenta_id FROM cuentas WHERE numeroCuenta = (?) and fechaApertura = (?) and saldo = (?)"
                + " and estado = (?) and cliente_id = (?)";

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            comandoSQL.setString(1, cuenta.getNumeroCuenta());
            comandoSQL.setString(2, cuenta.getFechaApertura());
            comandoSQL.setInt(3, cuenta.getSaldo());
            comandoSQL.setString(4, cuenta.getEstado());
            comandoSQL.setInt(5, cuenta.getCliente_id());
            ResultSet resultado = comandoSQL.executeQuery();
          
            resultado.next();

           int idConsultada = resultado.getInt(1);
            
            
            return idConsultada;
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "cuenta_id no encontrada", e);
            throw new PersistenciaException("No se ha encontrado ningún cuenta_id", e);
        }
    }    

    @Override
    public Cuenta consutarCuentaMasNueva() throws PersistenciaException {
        String codigoSQL = "SELECT * FROM cuentas order by cuenta_id desc limit 1 ";

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {
            
            ResultSet resultado = comandoSQL.executeQuery();
          
            resultado.next();

           Cuenta cuentaConsultada = new Cuenta(resultado.getInt(1), 
                   resultado.getString(2), resultado.getString(3), 
                   resultado.getInt(4), resultado.getString(5), 
                   resultado.getInt(6)
           );
           
     return cuentaConsultada;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Cuenta no encontrada", e);
            throw new PersistenciaException("No se ha encontrado ninguna cuenta", e);
        }
    }

    @Override
    public Cuenta consutarCuentaMasNuevaDeUnCliente(int cliente_id) throws PersistenciaException {
        String codigoSQL = "SELECT * FROM cuentas where cliente_id = ? order by cuenta_id desc limit 1 ";

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {
            comandoSQL.setInt(1, cliente_id);
            ResultSet resultado = comandoSQL.executeQuery();
          
            resultado.next();

           Cuenta cuentaConsultada = new Cuenta(resultado.getInt(1), 
                   resultado.getString(2), resultado.getString(3), 
                   resultado.getInt(4), resultado.getString(5), 
                   resultado.getInt(6)
           );
           
     return cuentaConsultada;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Cuenta no encontrada", e);
            throw new PersistenciaException("No se ha encontrado ninguna cuenta", e);
        }
    }

    @Override
    public Cuenta actualizarEstadoCuenta(int cuenta_id) throws PersistenciaException {
        String codigoSQL = "UPDATE cuentas SET estado = ? WHERE cuenta_id=? and estado = 'Activa'";

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            comandoSQL.setString(1, "Cancelada");
            comandoSQL.setInt(2, cuenta_id);
              

            int registros = comandoSQL.executeUpdate();
           LOG.log(Level.INFO, "Se actualizó el retiro con éxito {0} ", registros);
           
            
            return consutarCuenta(cuenta_id);

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo actualizar el cliente", e);
            throw new PersistenciaException("No se pudo actualizar el cliente ", e);
        }
    }
    
}
