package co.edu.iesa.sw.formularios;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 *
 * @author Rubén Darío Uribe Quejada
 */
public class frmPrincipal extends JFrame implements ActionListener{
    private final JButton btnRegistrar;
    private final JButton btnSalir;
    private final JButton btnInformacion;
    private final JButton btnLoing;
    
    public frmPrincipal(){
        setTitle("Sistema IESA"); //Establece el título al marco
        setResizable(false); // Establece que este marco no es redimensionable por el usuario.
        setSize(900,600); //Establese el tamaño del marco 
        setLayout(null); //Definir distribucion de los elementos en la ventana
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//Centrar ventana en la pantalla
        
        //Color de la ventana
        //getContentPane().setBackground(new Color(255, 255, 255));
        getContentPane().setBackground(Color.WHITE);
        
        //Creación de iconos
        Icon iconRegistrar = new ImageIcon(getClass().getResource("../imagenes/Registro.png"));
        Icon iconSalir = new ImageIcon(getClass().getResource("../imagenes/logout.png"));
        Icon iconInformacio = new ImageIcon(getClass().getResource("../imagenes/Info.png"));
        Icon iconLogin = new ImageIcon(getClass().getResource("../imagenes/Lock.png"));
        
        //Intaciación o creación de los objetos del marco
        btnInformacion = new JButton("Información", iconInformacio);
        btnLoing = new JButton("Login", iconLogin);
        btnRegistrar = new JButton("Registrar", iconRegistrar);
        btnSalir = new JButton("Salir", iconSalir);
        
        //Color del boton
        btnInformacion.setBackground(Color.WHITE); 
        btnLoing.setBackground(Color.WHITE);
        btnRegistrar.setBackground(Color.WHITE);
        btnSalir.setBackground(Color.WHITE);
        
        //Quitar borde a boton
        btnInformacion.setBorder(null);
        btnLoing.setBorder(null);
        btnRegistrar.setBorder(null);
        btnSalir.setBorder(null);
        
        //Quitar foco de los botones
        btnInformacion.setFocusPainted(false);
        btnLoing.setFocusPainted(false);
        btnRegistrar.setFocusPainted(false);
        btnSalir.setFocusPainted(false);
        
        //Alineación del texto del boton
        btnInformacion.setHorizontalTextPosition(SwingConstants.CENTER);
        btnInformacion.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnLoing.setHorizontalTextPosition(SwingConstants.CENTER);
        btnLoing.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnRegistrar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnRegistrar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
        
         //Adicionar objetos al marco
        add(btnInformacion);
        add(btnLoing);
        add(btnRegistrar);
        add(btnSalir);
        
        //Ubicación y tamaño de los objetos en el marco
        btnRegistrar.setBounds(200, 130, 70, 70);
        btnLoing.setBounds(340, 130, 70, 70);
        btnInformacion.setBounds(480, 130, 70, 70);
        btnSalir.setBounds(620, 130, 70, 70);
        
        btnRegistrar.addActionListener(this);
        btnLoing.addActionListener(this);
        btnSalir.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
         if (e.getSource()==btnLoing) {
             dispose();
             FrmLogin miLogin = new FrmLogin();
             miLogin.setVisible(true);
         }
         if (e.getSource()==btnSalir) {
             //finaliza la aplicación
             System.exit(0);
         }
         
         if (e.getSource()==btnRegistrar) {
             dispose();
             FrmRegistro miRegistro = new FrmRegistro();
             miRegistro.setVisible(true);
         }
    }
}
