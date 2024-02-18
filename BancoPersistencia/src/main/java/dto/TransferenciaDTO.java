
package dto;

/**
 *
 * @author Wilber
 */
public class TransferenciaDTO {
    
     private String cuentaDestino;
     private int monto;
     private String fecha;
     private int cuenta_id;

    public TransferenciaDTO() {
    }

    public TransferenciaDTO(String cuentaDestino, int monto, String fecha, int cuenta_id) {
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.fecha = fecha;
        this.cuenta_id = cuenta_id;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCuenta_id() {
        return cuenta_id;
    }

    public void setCuenta_id(int cuenta_id) {
        this.cuenta_id = cuenta_id;
    }

     
}
