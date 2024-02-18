
package dto;



/**
 *
 * @author Usuario
 */
public class CuentaDTO {
    private String numeroCuenta;
    private String fechaApertura;
    private int saldo;
    private String estado;
    private int cliente_id;

    public CuentaDTO() {
    }

    public CuentaDTO(int cliente_id) {
        this.cliente_id = cliente_id;
    }
    
    

    public CuentaDTO(String numeroCuenta, String fechaApertura, int saldo, String estado, int cliente_id) {
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.estado = estado;
        this.cliente_id = cliente_id;
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

    public int getSaldo() {
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
}
