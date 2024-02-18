/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import Excepciones.PersistenciaException;
import dto.CuentaDTO;
import entidadesdominio.Cuenta;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ICuentaDAO {
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException;
    public Cuenta consutarCuenta(int cuenta_id) throws PersistenciaException;
    public Cuenta consutarCuentaMasNueva() throws PersistenciaException;
    public List<Cuenta> consutarTodosCuenta() throws PersistenciaException;
    public int consultarIdCuenta(CuentaDTO cuenta) throws PersistenciaException;
}
