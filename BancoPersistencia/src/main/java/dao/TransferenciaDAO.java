
package dao;

import ConexionBD.IConexionBD;
import Excepciones.PersistenciaException;
import dto.TransferenciaDTO;
import entidadesdominio.Transferencia;
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
public class TransferenciaDAO implements ITransferenciaDAO{

    final IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(DireccionDAO.class.getName());

    
    public TransferenciaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    
    @Override
    public Transferencia agregarTransferencia(Transferencia transferencia) throws PersistenciaException {

        String codigoSQL = "INSERT INTO TRANSFERENCIAS (cuentaDestino, monto, fecha, cuenta_id) VALUES (?,?,?)";
        
          try (    Connection conexion = this.conexionBD.crearConexion(); // establecemos la conexion con la bd
                 PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
              
            comandoSQL.setString(1,transferencia.getCuentaDestino());
            comandoSQL.setInt(2, transferencia.getMonto());
            comandoSQL.setString(4,  transferencia.getFecha());
            comandoSQL.setInt(4,transferencia.getCuenta_id());
        
              int registros = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con éxito {0} registros", registros);
            
                        ResultSet registro = comandoSQL.getGeneratedKeys();
                        registro.next();
                        
                        Transferencia transferenciaNueva = new Transferencia(
               registro.getInt(1),
                transferencia.getCuentaDestino(),
                      transferencia.getMonto(),
                      transferencia.getFecha(),
                   transferencia.getCuenta_id()
            );
            // regresamos la dirección
            return transferenciaNueva;
          
          } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agregó con éxito la dirección", e);
            throw new PersistenciaException("No se pudo guardar la dirección ", e);
        }
    }
    


    @Override
    public Transferencia consultarTransferencia(int id) throws PersistenciaException {
   
        
            String codigoSQL = "SELECT * FROM transferencias WHERE transaccion_id = ?";

        try (Connection conexion = conexionBD.crearConexion(); 
                PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            comandoSQL.setInt(1, id);
            // Ejecutamos el comando
            try (ResultSet res = comandoSQL.executeQuery()) {
                if (res.next()) {
                    Transferencia transferenciaConsultada = new Transferencia(
                            res.getInt(1), 
                            res.getString(2), 
                            res.getInt(3), 
                            res.getString(4), 
                            res.getInt(5)
                    );
                    return transferenciaConsultada;
                } else {
                    throw new PersistenciaException("Transferencia no encontrada");
                }
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo consultar la transferencia", e);
            throw new PersistenciaException("Error al consultar la transferencia", e);
        }    
    
    }

    @Override
    public List<Transferencia> consultarTodasTransferencia() throws PersistenciaException {
            
            String codigoSQL = "SELECT * FROM DIRECCIONES";
             
        List<Transferencia> transferenciasLista = new ArrayList<>();

       try (Connection conexion = conexionBD.crearConexion();
         PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL);

               ResultSet registro = comandoSQL.executeQuery()) {

           while (registro.next()) {
                int transaccion_id = registro.getInt("transferencia_id");
                String cuentaDestino = registro.getString("cuentaDestino");
                int monto = registro.getInt("monto");
                String fecha = registro.getString("fecha");
                int cuenta_id = registro.getInt("cuenta_id");


                Transferencia transferencia = new Transferencia(transaccion_id, cuentaDestino, monto, fecha, cuenta_id);
                transferenciasLista.add(transferencia);
            }

            LOG.log(Level.INFO, "Se consultaron {0} clientes", transferenciasLista.size());
            return transferenciasLista;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudieron obtener los clientes", e);
            throw new PersistenciaException("No se pudieron consultar los clientes", e);
        }
     }
    
//    transaccion_id int primary key auto_increment,
//cuentaDestino varchar (100) not null,
//monto int not null,
//fecha date not null,
//cuenta_id int,
    
    @Override
    public int consultarIdTransferencia(TransferenciaDTO transferencia) throws PersistenciaException {
        String codigoSQL = "SELECT transaccion_id FROM transferencias WHERE cuentaDestino = (?) and monto = (?)"
                + " and fecha = (?) and cuenta_id = (?)";

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            comandoSQL.setString(1, transferencia.getCuentaDestino());
            comandoSQL.setInt(2, transferencia.getMonto());
            comandoSQL.setString(3, transferencia.getFecha());
            comandoSQL.setInt(4, transferencia.getCuenta_id());
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
    public Transferencia consultarTransferenciaMasNueva() throws PersistenciaException {
        String codigoSQL = "SELECT * FROM transferencias order by transaccion_id desc limit 1 ";

             try (Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(codigoSQL)) {

            ResultSet registro = comandoSQL.executeQuery();

            registro.next();

            Transferencia transferenciaConsultada = new Transferencia(
                    registro.getInt(1), 
                    registro.getString(2), 
                    registro.getInt(3), 
                    registro.getString(4), 
                    registro.getInt(6));

            return transferenciaConsultada;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Dirección no encontrada", e);
            throw new PersistenciaException("No se ha encontrado ninguna dirección", e);
        }
    }

    }
    
    
    

