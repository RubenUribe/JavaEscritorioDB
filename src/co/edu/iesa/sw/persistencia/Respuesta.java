
package co.edu.iesa.sw.persistencia;

/**
 *
 * @author USUARIO
 */
public class Respuesta {
    protected boolean exito;
    protected String mensaje;
    
//CONSTRUCTOR
    
    //Metodo Exito
    public Respuesta(boolean exito) {
        this.exito = exito;
    }//Fin medoto exito
    
    
    //Metodo Mensaje
    public Respuesta(String mensaje) {
        this.mensaje = mensaje;
        this.exito = false;
        
        
    } //Fin metodo mensaje
    
//FIN CONSTRUCTOR
    
    // Inicio Get
    public boolean isExito() {
        return exito;
    }

    public String getMensaje() {
        return mensaje;
    }
    //Fin Get
     
    
    
}
