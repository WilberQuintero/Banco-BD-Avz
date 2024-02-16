
package entidadesdominio;

import java.util.Date;


/**
 *
 * @author Usuario
 */
public class Cliente {
    private int cliente_id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNac; 
    private int usuario_id;
    private int direccion_id;

    public Cliente() {
    }

    public Cliente(int cliente_id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNac, int usuario_id, int direccion_id) {
        this.cliente_id = cliente_id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNac = fechaNac;
        this.usuario_id = usuario_id;
        this.direccion_id = direccion_id;
    }
    
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNac, int usuario_id, int direccion_id) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNac = fechaNac;
        this.usuario_id = usuario_id;
        this.direccion_id = direccion_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getUsuario_Id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getDireccion_Id() {
        return direccion_id;
    }

    public void setDireccion_Id(int direccion_id) {
        this.direccion_id = direccion_id;
            
    }


}    
