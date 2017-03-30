package co.edu.iesa.sw.conexion;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rubén Darío Uribe Quejada
 */
public class DBConexion {
    private final String db = "iesa";//Nombre de la base de datos
    private final String puerto = "3306";//puerto de comunicación con MySQL
    private final String user = "";//Nombre del usuario de la base de datos
    private final String password = "";//Contraseña para ingreasar la base de datos
    private final String url = "jdbc:mysql://localhost"+puerto+db;
    private Connection connection = null;
    
    public DBConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = (Connection) DriverManager.getConnection(url, user,password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public void closeConnection(){
        this.connection = null;
    }
    
    
}
