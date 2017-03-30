package co.edu.iesa.sw.entidades;

/**
 *
 * @author Rubén Darío Uribe Quejada
 */
public class Usuario {
    //Atributos
    protected String email;
    protected String nombre;
    protected String apellido;
    protected String password;
    protected int rolId;
    
    //Constructor
    public Usuario(String email, String nombre, String apellido, String password, int rolId) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.rolId = rolId;
    }
    
    //Getters y Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }
    
}
