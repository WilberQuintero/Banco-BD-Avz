
package dto;


/**
 *
 * @author Usuario
 */
public class RetiroSinCuentaDTO {
    private String folio;
    private int monto;
    private String contra;
    private String fecha;
    private int cliente_id;
    
    public RetiroSinCuentaDTO(String folio, int monto, String contra, String fecha, int cliente_id) {
        this.fecha = fecha;
        this.monto = monto;
        this.folio = folio;
        this.contra = contra;
        this.cliente_id = cliente_id;
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
}
