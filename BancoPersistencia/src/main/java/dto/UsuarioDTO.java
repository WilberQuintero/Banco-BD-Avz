
package dto;

/**
 *
 * @author Usuario
 */
public class UsuarioDTO {
    private String contra;
    private String nombreUsusario;

    public UsuarioDTO() {
    }
    
    public UsuarioDTO(String nombreUsusario, String contra) {
        this.contra = contra;
        this.nombreUsusario = nombreUsusario;
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
