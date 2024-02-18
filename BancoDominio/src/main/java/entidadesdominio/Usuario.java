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
public class Usuario {
    private int usuario_id;
    private String contra;
    private String nombreUsusario;

    public Usuario() {
    }

    public Usuario(int usuario_id, String nombreUsusario, String contra) {
        this.usuario_id = usuario_id;
        this.contra = contra;
        this.nombreUsusario = nombreUsusario;
    }
    
    public Usuario(String contra, String nombreUsusario) {
        this.contra = contra;
        this.nombreUsusario = nombreUsusario;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombreUsusario() {
        return nombreUsusario;
    }

    public void setNombreUsusario(String nombreUsusario) {
        this.nombreUsusario = nombreUsusario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario_id=" + usuario_id + ", contra=" + contra + ", nombreUsusario=" + nombreUsusario + '}';
    }
    
}
