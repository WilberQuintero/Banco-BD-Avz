
package dto;

import java.util.Date;

/**
 *
 * @author Wilber
 */
public class TransferenciaDTO {
    
     private int cuentaDestino;
     private int monto;
     private Date fecha;
     private int cuenta_id;

    public TransferenciaDTO() {
    }

    public TransferenciaDTO(int cuentaDestino, int monto, Date fecha, int cuenta_id) {
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.fecha = fecha;
        this.cuenta_id = cuenta_id;
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

     
}
