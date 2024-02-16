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
    private Date fecha;
    private int monto;
    private int cuentaEnvio;

    public Transferencia() {
    }

    public Transferencia(Date fecha, int monto, int cuentaEnvio) {
        this.fecha = fecha;
        this.monto = monto;
        this.cuentaEnvio = cuentaEnvio;
    }

    public int getTransaccion_id() {
        return transaccion_id;
    }

    public void setTransaccion_id(int transaccion_id) {
        this.transaccion_id = transaccion_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getCuentaEnvio() {
        return cuentaEnvio;
    }

    public void setCuentaEnvio(int cuentaOrigen) {
        this.cuentaEnvio = cuentaOrigen;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "transaccion_id=" + transaccion_id + ", fecha=" + fecha + ", monto=" + monto + ", cuentaEnvio=" + cuentaEnvio + '}';
    }

}