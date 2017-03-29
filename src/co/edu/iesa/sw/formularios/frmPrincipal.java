package co.edu.iesa.sw.formularios;

import javax.swing.*;

/**
 *
 * @author Rubén Darío Uribe Quejada
 */
public class frmPrincipal extends JFrame{
    
    public frmPrincipal(){
        setTitle("Sistema IESA"); //Establece el título al marco
        //setResizable(false); // Establece que este marco no es redimensionable por el usuario.
        setSize(900,600); //Establese el tamaño del marco 
        setLayout(null); //Definir distribucion de los elementos en la ventana
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//Centrar ventana en la pantalla
    }
}
