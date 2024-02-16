
package dto;

/**
 *
 * @author Usuario
 */
public class UsuarioDTO {
    private int usuario_id;
    private String contra;
    private String nombreUsusario;

    public UsuarioDTO() {
    }
    
    public UsuarioDTO(String contra, String nombreUsusario) {
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
