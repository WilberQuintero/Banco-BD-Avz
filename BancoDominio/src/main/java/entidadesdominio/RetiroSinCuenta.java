<<<<<<< HEAD
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
public class RetiroSinCuenta {
    private int transaccion_id;
    private Date fecha;
    private int monto;
    private String folio;
    private String contra;

    public RetiroSinCuenta() {
    }

    public RetiroSinCuenta(Date fecha, int monto, String folio, String contra) {
        this.fecha = fecha;
        this.monto = monto;
        this.folio = folio;
        this.contra = contra;
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


}
=======
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
public class RetiroSinCuenta {
    private int transaccion_id;
    private Date fecha;
    private int monto;
    private String folio;
    private String contra;

    public RetiroSinCuenta() {
    }

    public RetiroSinCuenta(Date fecha, int monto, String folio, String contra) {
        this.fecha = fecha;
        this.monto = monto;
        this.folio = folio;
        this.contra = contra;
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

    @Override
    public String toString() {
        return "RetiroSinCuenta{" + "transaccion_id=" + transaccion_id + ", fecha=" + fecha + ", monto=" + monto + ", folio=" + folio + ", contra=" + contra + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.transaccion_id;
        hash = 97 * hash + Objects.hashCode(this.fecha);
        hash = 97 * hash + this.monto;
        hash = 97 * hash + Objects.hashCode(this.folio);
        hash = 97 * hash + Objects.hashCode(this.contra);
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
        final RetiroSinCuenta other = (RetiroSinCuenta) obj;
        if (this.transaccion_id != other.transaccion_id) {
            return false;
        }
        if (this.monto != other.monto) {
            return false;
        }
        if (!Objects.equals(this.folio, other.folio)) {
            return false;
        }
        if (!Objects.equals(this.contra, other.contra)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }
    
    
}
>>>>>>> 05abff7aa39841838670997d4ee4f8d5fc681076
