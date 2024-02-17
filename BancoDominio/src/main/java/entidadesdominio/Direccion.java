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
public class Direccion {
    private int direccion_id;
    private String calle;
    private String colonia;
    private String numero;

    public Direccion() {
    }

    public Direccion(int direccion_id, String calle, String colonia, String numero) {
        this.direccion_id = direccion_id;
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
    }

    
    public Direccion(String calle, String colonia, String numero) {
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
    }

    public int getDireccion_id() {
        return direccion_id;
    }

    public void setDireccion_id(int direccion_id) {
        this.direccion_id = direccion_id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Direccion{" + "direccion_id=" + direccion_id + ", calle=" + calle + ", colonia=" + colonia + ", numero=" + numero + '}';
    }
    
    
}
