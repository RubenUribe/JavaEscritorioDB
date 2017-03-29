package co.edu.iesa.sw.formularios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rubén Darío Uribe Quejada
 */
public class FrmLogin extends JFrame implements ActionListener{
    //Declaración de Objetos del formulario
    private final JLabel lblLogo;
    private final JLabel lblUsuario;
    private final JLabel lblContrasena;
    private final JTextField txtUsuario;
    private final JPasswordField passContrasena;
    private final JButton btnIngresar;
    private final JButton btnCancelar;
    
    //Constructor
    public FrmLogin(){
        setTitle("Inicio de Seción"); //Establece el título al marco
        setResizable(false); // Establece que este marco no es redimensionable por el usuario.
        setSize(265,390); //Establese el tamaño del marco 
        setLayout(null); //Definir distribucion de los elementos en la ventana
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//Centrar ventana en la pantalla
        
        //Color de la ventana
        //getContentPane().setBackground(new Color(255, 255, 255));
        getContentPane().setBackground(Color.WHITE);
        
        //Icono de la ventana
        setIconImage(new ImageIcon(getClass().getResource("../imagenes/IconoLogin.png")).getImage());
        
        //Creación de iconos
        Icon iconLogo = new ImageIcon(getClass().getResource("../imagenes/IconoLogin.png"));
        Icon iconCancelar = new ImageIcon(getClass().getResource("../imagenes/Cancelar.png"));
        Icon iconIniciar = new ImageIcon(getClass().getResource("../imagenes/Ingresar.png"));

        //Intaciación o creación de los objetos del marco
        lblLogo = new JLabel(iconLogo);
        //lblLogo.setIcon(new ImageIcon(getClass().getResource("../imagenes/IconoLogin.png")));
        lblUsuario = new JLabel("Usuario");
        txtUsuario = new JTextField();
        lblContrasena = new JLabel("Contraseña");
        passContrasena = new JPasswordField();
        btnCancelar = new JButton("",iconCancelar);
        btnIngresar = new JButton("", iconIniciar);
        
        
        
        //Propiedades de los objetos
        
        //Color del boton
        btnCancelar.setBackground(Color.WHITE); 
        btnIngresar.setBackground(Color.WHITE); 
        
        //Tipo de fuente y color de fuentes
        //lblUsuario.setFont(new Font("ARIAL", Font.PLAIN, 15));
        //lblUsuario.setForeground(Color.RED);
        //lblContrasena.setFont(new Font("ARIAL", Font.PLAIN, 15));
        //lblContrasena.setForeground(Color.BLACK);
        

        //texto de ayuda
        txtUsuario.setToolTipText("Ingrese su usuario");
        passContrasena.setToolTipText("Ingrese su contraseña");
        btnCancelar.setToolTipText("Cancelar el ingreso al sistema");
        btnIngresar.setToolTipText("Ingresar al sistema");
        
        //Quitar borde
        //txtUsuario.setBorder(null);
        //passContrasena.setBorder(null);
        
        //Alineación del texto del boton
        //btnCancelar.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
        //btnCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
        
        //btnIngresar.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
        //btnIngresar.setVerticalTextPosition(SwingConstants.BOTTOM);
        
        //Adicionar objetos al marco
        add(lblLogo);
        add(lblUsuario);
        add(txtUsuario);
        add(lblContrasena);
        add(passContrasena);
        add(btnCancelar);
        add(btnIngresar);
        
        //Ubicación y tamaño de los objetos en el marco
        lblLogo.setBounds(65, 40, 128, 128);
        lblUsuario.setBounds(40, 190, 50, 25);
        txtUsuario.setBounds(40, 210, 180, 25);
        lblContrasena.setBounds(40, 240, 80, 25);
        passContrasena.setBounds(40, 260, 180, 25);
        btnCancelar.setBounds(40, 300, 85, 30);
        btnIngresar.setBounds(135, 300, 85, 30);
        
        btnCancelar.addActionListener(this);
        btnIngresar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
       
         if (e.getSource()==btnCancelar) {
             //finaliza la aplicación
             System.exit(0);
         }
         
         if (e.getSource()==btnIngresar) {
             
             if(txtUsuario.getText().equals("uriberuben89@gmail.com") && passContrasena.getText().equals("123")){
                 JOptionPane.showMessageDialog(null,"Bienvenido "+txtUsuario.getText(),"Mensaje",JOptionPane.INFORMATION_MESSAGE);
                 dispose();
                 frmPrincipal miPrincipal = new frmPrincipal();
                 miPrincipal.setVisible(true);
             }
             else{
                if(txtUsuario.getText().equals("") || passContrasena.getPassword().equals("")){
                JOptionPane.showMessageDialog(null,"Ingrese usuario y/o contraseña","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                //Limpiar campo de texto usuario
                txtUsuario.setText("");
                //Limpiar campo de texto contraseña
                passContrasena.setText("");
                txtUsuario.requestFocusInWindow();
                }
                else{
                    JOptionPane.showMessageDialog(null,"usuario y/o contraseña incorrecta","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                     //Limpiar campo de texto usuario
                    txtUsuario.setText("");
                    //Limpiar campo de texto contraseña
                    passContrasena.setText("");
                    txtUsuario.requestFocusInWindow();
                }   
             } 
         }     
    }
}
