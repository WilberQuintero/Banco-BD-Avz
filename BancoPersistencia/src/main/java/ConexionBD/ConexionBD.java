
package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wilber
 */
public class ConexionBD implements IConexionBD{
    
     private final String cadenaConexion;
    private final String usuario;
    private final String contra;
    private static final Logger LOG = Logger.getLogger(ConexionBD.class.getName());

    public ConexionBD(String cadenaConexion, String usuario, String contrasenia) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.contra = contrasenia;
    }

    
    @Override
    public Connection crearConexion() throws SQLException {
        Connection c = DriverManager.getConnection(cadenaConexion, usuario, contra);
        LOG.log(Level.INFO, "Conexion establecida", cadenaConexion);
        return c;
        
        
    }
    
}
