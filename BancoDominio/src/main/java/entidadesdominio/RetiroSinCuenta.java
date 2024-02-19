/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesdominio;

import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class RetiroSinCuenta {
    private int transaccion_id;
    private String fecha;
    private int monto;
    private String folio;
    private String contra;
    private String estado;
    private int cliente_id;

    public RetiroSinCuenta() {
    }

    public RetiroSinCuenta(int transaccion_id, String folio, int monto, String contra, String fecha, String estado,int cliente_id) {
        this.transaccion_id = transaccion_id;
        this.fecha = fecha;
        this.monto = monto;
        this.folio = folio;
        this.contra = contra;
        this.estado = estado;
        this.cliente_id = cliente_id;
    }

    
    public RetiroSinCuenta(String folio, int monto, String contra, String fecha, int cliente_id) {
        this.fecha = fecha;
        this.monto = monto;
        this.folio = folio;
        this.contra = contra;
        this.cliente_id = cliente_id;
    }

    public int getTransaccion_id() {
        return transaccion_id;
    }

    public void setTransaccion_id(int transaccion_id) {
        this.transaccion_id = transaccion_id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

    @Override
    public String toString() {
        return "RetiroSinCuenta{" + "transaccion_id=" + transaccion_id + ", fecha=" + fecha + ", monto=" + monto + ", folio=" + folio + ", contra=" + contra + ", cliente_id=" + cliente_id + '}';
    }

    

}