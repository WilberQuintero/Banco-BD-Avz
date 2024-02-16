
package dto;

/**
 *
 * @author Wilber
 */
public class DireccionDTO {
  
    private String calle;
    private String colonia;
    private String numero;

    
    public DireccionDTO() {
    }

    public DireccionDTO(String calle, String colonia, String numero) {
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
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
    
}
