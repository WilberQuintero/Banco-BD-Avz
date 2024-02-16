/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesdominio;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Transferencia {
    private int transaccion_id;
    private int cuentaDestino;
     private int monto;
    private Date fecha;
    private int cuenta_id;

    public Transferencia() {
    }

    public Transferencia(int cuentaDestino, int monto, Date fecha, int cuenta_id) {
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.fecha = fecha;
        this.cuenta_id = cuenta_id;
    }



    public Transferencia(int transaccion_id, int cuentaDestino, int monto, Date fecha, int cuenta_id) {
        this.transaccion_id = transaccion_id;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.fecha = fecha;
        this.cuenta_id = cuenta_id;
    }

    public int getTransaccion_id() {
        return transaccion_id;
    }

    public void setTransaccion_id(int transaccion_id) {
        this.transaccion_id = transaccion_id;
    }

    public int getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(int cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCuenta_id() {
        return cuenta_id;
    }

    public void setCuenta_id(int cuenta_id) {
        this.cuenta_id = cuenta_id;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "transaccion_id=" + transaccion_id + ", cuentaDestino=" + cuentaDestino + ", monto=" + monto + ", fecha=" + fecha + ", cuenta_id=" + cuenta_id + '}';
    }
}