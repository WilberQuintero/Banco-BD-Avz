/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import ConexionBD.IConexionBD;
import Excepciones.PersistenciaException;
import dto.CuentaDTO;
import entidadesdominio.Cuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
        String codigoSQL = "insert into cuentas () values();";
        try (Connection conexion = this.conexionBD.crearConexion();
               PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL, 
                       Statement.RETURN_GENERATED_KEYS);)
        {
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
        String codigoSQL = "SELECT * FROM cuentas WHERE id = (?)";
        String codigoSQL2 = String.format("select * from cuentas where cuenta_id = %d", cuenta_id);

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            comandoSQL.setInt(1, cuenta_id);
            ResultSet resultado = comandoSQL.executeQuery();
          
            resultado.next();

           Cuenta cuentaConsultada = new Cuenta(resultado.getInt(1), 
                   resultado.getString(2), resultado.getDate(3), 
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
    public List<Cuenta> consutarTodosCuenta() throws PersistenciaException {
        String codigoSQL = "SELECT * FROM CUENTAS";
        List<Cuenta> cuentasLista = new ArrayList<>();

       try (Connection conexion = conexionBD.crearConexion();
         PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL);
         
               ResultSet resultado = comandoSQL.executeQuery()) {

           while (resultado.next()) {
                int cuenta_id = resultado.getInt("cuenta_id");
                String numeroCuenta = resultado.getString("numeroCuenta");
                Date fechaApertura = resultado.getDate("fechaApertura");
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
    
}
