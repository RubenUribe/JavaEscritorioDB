package co.edu.iesa.sw.formularios;

import co.edu.iesa.sw.entidades.Usuario;
import co.edu.iesa.sw.persistencia.DaoUsuario;
import co.edu.iesa.sw.persistencia.Respuesta;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rubén Darío Uribe Quejada
 */
public class FrmRegistro extends JFrame implements ActionListener{
    //Declaración de Objetos del formulario
    private final JLabel lblLogo;
    private final JLabel lblEmail;
    private final JLabel lblContrasena;
    private final JLabel lblNombre;
    private final JLabel lblApellido;
    private final JLabel lblRolId;
    private final JTextField txtEmail;
    private final JTextField txtNombre;
    private final JTextField txtApellido;
    private final String[] roles = { "Vendedor", "Cajero", "Supervisor", "Administrador", "Gerente" };
    private final JComboBox cmbRolId;
    private final JPasswordField passContrasena;
    private final JButton btnGuardar;
    private final JButton btnCancelar;
    
    //Constructor
    public FrmRegistro(){
        setTitle("Registro"); //Establece el título al marco
        setResizable(false); // Establece que este marco no es redimensionable por el usuario.
        setSize(265,550); //Establese el tamaño del marco 
        setLayout(null); //Definir distribucion de los elementos en la ventana
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//Centrar ventana en la pantalla
        
        //Color de la ventana
        //getContentPane().setBackground(new Color(255, 255, 255));
        getContentPane().setBackground(Color.WHITE);
        
        //Icono de la ventana
        setIconImage(new ImageIcon(getClass().getResource("../imagenes/IconoUsuario.png")).getImage());
        
        //Creación de iconos
        Icon iconLogo = new ImageIcon(getClass().getResource("../imagenes/IconoUsuario.png"));
        Icon iconCancelar = new ImageIcon(getClass().getResource("../imagenes/Cancelar.png"));
        Icon iconIniciar = new ImageIcon(getClass().getResource("../imagenes/Guardar.png"));

        //Intaciación o creación de los objetos del marco
        lblLogo = new JLabel(iconLogo);
        //lblLogo.setIcon(new ImageIcon(getClass().getResource("../imagenes/IconoLogin.png")));
        lblEmail = new JLabel("Correo electrónico");
        txtEmail = new JTextField();
        lblNombre = new JLabel("Nombre");
        txtNombre = new JTextField();
        lblApellido = new JLabel("Apellido");
        txtApellido = new JTextField();
        lblContrasena = new JLabel("Contraseña");
        passContrasena = new JPasswordField();
        lblRolId = new JLabel("RolId");
        cmbRolId = new JComboBox(roles);
        cmbRolId.setSelectedIndex(4);
        cmbRolId.addActionListener(this);
        btnCancelar = new JButton("",iconCancelar);
        btnGuardar = new JButton("", iconIniciar);
        
        
        
        //Propiedades de los objetos
        
        //Color del boton
        btnCancelar.setBackground(Color.WHITE); 
        btnGuardar.setBackground(Color.WHITE); 
        
        //Tipo de fuente y color de fuentes
        //lblUsuario.setFont(new Font("ARIAL", Font.PLAIN, 15));
        //lblUsuario.setForeground(Color.RED);
        //lblContrasena.setFont(new Font("ARIAL", Font.PLAIN, 15));
        //lblContrasena.setForeground(Color.BLACK);
        

        //texto de ayuda
        txtEmail.setToolTipText("Ingrese su usuario");
        passContrasena.setToolTipText("Ingrese su contraseña");
        btnCancelar.setToolTipText("Cancelar el ingreso al sistema");
        btnGuardar.setToolTipText("Ingresar al sistema");
        
             
        //Adicionar objetos al marco
        add(lblLogo);
        add(lblEmail);
        add(txtEmail);
        add(lblNombre);
        add(txtNombre);
        add(lblApellido);
        add(txtApellido);
        add(lblContrasena);
        add(passContrasena);
        add(lblRolId);
        add(cmbRolId);
        add(btnCancelar);
        add(btnGuardar);
        
        //Ubicación y tamaño de los objetos en el marco
        lblLogo.setBounds(65, 40, 128, 128);
        lblEmail.setBounds(40, 190, 110, 25);
        txtEmail.setBounds(40, 210, 180, 25);
        
        lblNombre.setBounds(40, 240, 80, 25);
        txtNombre.setBounds(40, 260, 180, 25);
        
        lblApellido.setBounds(40, 290, 80, 25);
        txtApellido.setBounds(40, 310, 180, 25);
        
        lblContrasena.setBounds(40, 340, 80, 25);
        passContrasena.setBounds(40, 360, 180, 25);
        
        lblRolId.setBounds(40, 390, 80, 25);
        cmbRolId.setBounds(40, 410, 180, 25);
        
        btnCancelar.setBounds(40, 450, 85, 30);
        btnGuardar.setBounds(135, 450, 85, 30);
        
        btnCancelar.addActionListener(this);
        btnGuardar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
       
         if (e.getSource()==btnCancelar) {
             dispose();
             frmPrincipal miPrincipal = new frmPrincipal();
             miPrincipal.setVisible(true);
         }
         
         if (e.getSource()==btnGuardar) {
             
             String email = txtEmail.getText();
             //Si campo correo vacio
             if(email.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Debe ingresar un correo electrónico","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                 txtEmail.requestFocusInWindow();
                 return;
             }
             
            
             //Si campo nombre vacio
             if(txtNombre.getText().isEmpty()){
                 JOptionPane.showMessageDialog(null,"Debe ingresar un nombre","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                 txtNombre.requestFocusInWindow();
                 return;
             }
             
             //Si campo apellido vacio
             if(txtApellido.getText().isEmpty()){
                 JOptionPane.showMessageDialog(null,"Debe ingresar un apellido","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                 txtApellido.requestFocusInWindow();
                 return;
             }
             
             
             String password = new String(passContrasena.getPassword());
             //Si campo contraseña vacio
             if(password.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Debe ingresar una contraseña","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                 passContrasena.requestFocusInWindow();
                 return;
             }
             
             //Si campo rolId vacio
             /*
             if(cmbRolId.getText().isEmpty()){
                 JOptionPane.showMessageDialog(null,"Debe ingresar un rol","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                 cmbRolId.requestFocusInWindow();
                 return;
             }*/
  
             Usuario miUsuario = new Usuario(
                     txtEmail.getText(),
                     txtNombre.getText(),
                     txtApellido.getText(),
                     password,
                     cmbRolId.getSelectedIndex());
             
             //Integer.parseInt(cmbRolId.getText())
             
             Respuesta respuesta = DaoUsuario.Crear(miUsuario);
             
             if(respuesta.isExito()){
                 JOptionPane.showMessageDialog(null,"Usuario creado exitosamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
             }else{
                 JOptionPane.showMessageDialog(null,"ERROR: "+respuesta.getMensaje(),"Mensaje",JOptionPane.INFORMATION_MESSAGE);
             }
         }     
    }
}
