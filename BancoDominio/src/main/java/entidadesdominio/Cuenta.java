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
public class Cuenta {
    private int cuenta_id;
    private String numeroCuenta;
    private String fechaApertura;
    private float saldo;
    private String estado;
    private int cliente_id;

    public Cuenta() {
    }

    public Cuenta(int cuenta_id, String numeroCuenta, String fechaApertura, float saldo, String estado, int cliente_id) {
        this.cuenta_id = cuenta_id;
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.estado = estado;
        this.cliente_id = cliente_id;
    }
    
    
    public Cuenta(String numeroCuenta, String fechaApertura, float saldo, String estado, int cliente_id) {
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.estado = estado;
        this.cliente_id = cliente_id;
    }

    public int getCuenta_id() {
        return cuenta_id;
    }

    public void setCuenta_id(int cuenta_id) {
        this.cuenta_id = cuenta_id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "cuenta_id=" + cuenta_id + ", numeroCuenta=" + numeroCuenta + ", fechaApertura=" + fechaApertura + ", saldo=" + saldo + ", estado=" + estado + ", cliente_id=" + cliente_id + '}';
    }
    
}