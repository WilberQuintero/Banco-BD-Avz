<<<<<<< HEAD
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

}
=======
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
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.usuario_id;
        hash = 23 * hash + Objects.hashCode(this.contra);
        hash = 23 * hash + Objects.hashCode(this.nombreUsusario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.usuario_id != other.usuario_id) {
            return false;
        }
        if (!Objects.equals(this.contra, other.contra)) {
            return false;
        }
        return Objects.equals(this.nombreUsusario, other.nombreUsusario);
    }

    @Override
    public String toString() {
        return "Usuario{" + "Id del usuario=" + usuario_id + ", Contraseña=" + contra + ", Nombre de ususario=" + nombreUsusario + '}';
    }
    
    
}
>>>>>>> 05abff7aa39841838670997d4ee4f8d5fc681076
