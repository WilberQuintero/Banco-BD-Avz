/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import ConexionBD.IConexionBD;
import Excepciones.PersistenciaException;
import dto.RetiroSinCuentaDTO;
import entidadesdominio.RetiroSinCuenta;
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
public class RetiroSinCuentaDAO implements IRetiroSinCuentaDAO{
    final IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());

    public RetiroSinCuentaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public RetiroSinCuenta agregarRetiro(RetiroSinCuentaDTO retiro) throws PersistenciaException {
        String codigoSQL = "insert into retirossincuenta (folio, monto, contra, fecha, cliente_id) values(?,?,?,?,?);";
        try (Connection conexion = this.conexionBD.crearConexion();
               PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL, 
                       Statement.RETURN_GENERATED_KEYS);)
        {
            int resultado = comandoSQL.executeUpdate();
            
             LOG.log(Level.INFO, "Se han realizado {0} ", resultado);
            
            // obtener primer registro
            ResultSet res = comandoSQL.getGeneratedKeys();
            
            //nos posicionamos en el primero lugar o en la primera posicion de los resultados
            res.next();
            
            //Creamos el activista que vamos a registrar
            RetiroSinCuenta retiroGuardado = new RetiroSinCuenta(res.getInt(1), retiro.getFolio(), 
                    retiro.getMonto(), retiro.getContra(),
                    retiro.getFecha(), retiro.getCliente_id());
            
            return retiroGuardado;
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo hacer el retiro");
            throw new PersistenciaException("No se pudo hacer el retiro", e);
        }
    }

    @Override
    public RetiroSinCuenta consultarRetiro(int transaccion_id) throws PersistenciaException {
        String codigoSQL = "SELECT * FROM retirossincuenta WHERE id = (?)";
        String codigoSQL2 = String.format("select * from retirossincuenta where cuenta_id = %d", transaccion_id);

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            comandoSQL.setInt(1, transaccion_id);
            ResultSet resultado = comandoSQL.executeQuery();
          
            resultado.next();

           RetiroSinCuenta retiroConsultado = new RetiroSinCuenta(resultado.getInt(1), 
                   resultado.getString(2), resultado.getInt(3), 
                   resultado.getString(4), resultado.getString(5), 
                   resultado.getInt(6)
           );
           
     return retiroConsultado;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Retiro no encontrada", e);
            throw new PersistenciaException("No se ha encontrado ningún retiro", e);
        }
    }

    @Override
    public List<RetiroSinCuenta> consultarTodosRetiros() throws PersistenciaException {
        String codigoSQL = "SELECT * FROM CUENTAS";
        List<RetiroSinCuenta> retirosLista = new ArrayList<>();

       try (Connection conexion = conexionBD.crearConexion();
         PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL);
         
               ResultSet resultado = comandoSQL.executeQuery()) {

           while (resultado.next()) {
                int transaccion_id = resultado.getInt("transaccion_id");
                String folio = resultado.getString("folio");
                int monto = resultado.getInt("monto");
                String contra = resultado.getString("contra");
                String fecha = resultado.getString("fecha");
                int cliente_id = resultado.getInt("cliente_id");
                

                RetiroSinCuenta retiro = new RetiroSinCuenta(transaccion_id, folio, monto, contra, fecha, cliente_id);
                retirosLista.add(retiro);
            }

            LOG.log(Level.INFO, "Se consultaron {0} clientes", retirosLista.size());
            return retirosLista;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudieron obtener los retiros", e);
            throw new PersistenciaException("No se pudieron consultar los retiros", e);
        }
    }
    
//    transaccion_id int primary key auto_increment,
//folio varchar (100) not null,
//monto int not null,
//contra varchar (100) not null,
//fecha date not null,
//cliente_id int,
    
    @Override
    public int consultarIdRetiro(RetiroSinCuentaDTO retiro) throws PersistenciaException {
        String codigoSQL = "SELECT transaccion_id FROM retirossincuneta WHERE folio = (?) and monto = (?) and contra = (?)"
                + " and fecha = (?) and cliente_id = (?)";
        

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            comandoSQL.setString(1, retiro.getFolio());
            comandoSQL.setInt(2, retiro.getMonto());
            comandoSQL.setString(3, retiro.getContra());
            comandoSQL.setString(4, retiro.getFecha());
            comandoSQL.setInt(5, retiro.getCliente_id());
            ResultSet resultado = comandoSQL.executeQuery();
          
            resultado.next();

           int idConsultada = resultado.getInt(1);
            
            
            return idConsultada;
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "transaccion_id no encontrada", e);
            throw new PersistenciaException("No se ha encontrado ningún transaccion_id", e);
        }
    }
    
}
