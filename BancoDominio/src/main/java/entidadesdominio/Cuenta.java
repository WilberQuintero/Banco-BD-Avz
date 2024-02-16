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
public class Cuenta {
    private int cuenta_id;
    private Date fechaApertura;
    private int saldo;

    public Cuenta() {
    }

    public Cuenta(Date fechaApertura, int saldo) {
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
    }

    public int getCuenta_id() {
        return cuenta_id;
    }

    public void setCuenta_id(int cuenta_id) {
        this.cuenta_id = cuenta_id;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "cuenta_id=" + cuenta_id + ", fechaApertura=" + fechaApertura + ", saldo=" + saldo + '}';
    }
    
}