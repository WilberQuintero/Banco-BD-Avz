/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import Excepciones.PersistenciaException;
import dto.RetiroSinCuentaDTO;
import entidadesdominio.RetiroSinCuenta;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IRetiroSinCuentaDAO {
     public RetiroSinCuenta agregarRetiro(RetiroSinCuentaDTO retiro) throws PersistenciaException;
     public RetiroSinCuenta consultarRetiro (int transaccion_id) throws PersistenciaException;
     public RetiroSinCuenta consultarRetiroMasNuevo () throws PersistenciaException;
     public List<RetiroSinCuenta> consultarTodosRetiros() throws PersistenciaException;
     public int consultarIdRetiro(RetiroSinCuentaDTO retiro) throws PersistenciaException;
}
