
package ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Wilber
 */
public interface IConexionBD {
    public Connection crearConexion() throws SQLException;
}
