package co.edu.iesa.sw.persistencia;

import co.edu.iesa.sw.conexion.DBConexion;
import co.edu.iesa.sw.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Rubén Darío Uribe Quejada
 */
/* DAO: data acces objects*/
public class DaoUsuario {
    public static Usuario getUsuario(String email, String password){
        
        DBConexion con = new DBConexion();
        try {
            PreparedStatement consulta = con.getConnection()
                    .prepareStatement("SELECT * FROM usuarios WHERE email = ? AND password = ?");

            consulta.setString(1, email);
            consulta.setString(2, password);
            ResultSet resultado = consulta.executeQuery();
            
            //El metodo next() devuelve true miestras existas mas registros
            if(!resultado.next()){
                return null;
            }
            Usuario miUsuario = new Usuario(
                    resultado.getString("email"), 
                    resultado.getString("nombre"), 
                    resultado.getString("apellido"), 
                    resultado.getString("password"), 
                    resultado.getInt("rolId"));
            return miUsuario;
            
        } catch (SQLException ex) {
            //Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
 
    }
    public static Respuesta Crear (Usuario usuario){
        DBConexion con = new DBConexion();
 
    try{
    String sql = "INSERT INTO usuarios(email, nombre, apellido, password, rolId) VALUES(?,?,?,?,?)"; 
        PreparedStatement consulta = con.getConnection().prepareStatement(sql);     
         consulta.setString(1,usuario.getEmail());
         consulta.setString(2,usuario.getNombre());
         consulta.setString(3,usuario.getApellido());
         consulta.setString(4,usuario.getPassword());
         consulta.setInt(5,usuario.getRolId());
         consulta.executeUpdate();
         con.closeConnection();
         return new Respuesta (true); 
    } //Fin try
    
      catch(SQLException ex){
          con.closeConnection();
          return new Respuesta (ex.getMessage());
          
    } //Fin catch
    
    }
}
