package presentacion;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;
import java.sql.*;
import persistencia.Agente;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class VentanaLogin {

	private JFrame frame;
	private JTextField txtUsuario;
	private JLabel lblUsuario;
	private JLabel lblPass;
	private JButton btnEntrar;
	VentanaPrincipal mainVentana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	private JPasswordField pfPass;
	private JLabel lblIcon;

	/**
	 * Create the application.
	 */
	public VentanaLogin() {
		initialize();
		connection=Agente.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 419, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(196, 175, 133, 22);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(85, 178, 86, 16);
		frame.getContentPane().add(lblUsuario);
		
		lblPass = new JLabel("Password");
		lblPass.setBounds(85, 224, 86, 16);
		frame.getContentPane().add(lblPass);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new BtnEntrarActionListener());
		btnEntrar.setBounds(150, 261, 97, 25);
		frame.getContentPane().add(btnEntrar);
		
		pfPass = new JPasswordField();
		pfPass.setBounds(196, 221, 133, 22);
		frame.getContentPane().add(pfPass);
		

		lblIcon = new JLabel("");
		lblIcon.setBounds(127, 13, 144, 141);
		BufferedImage img = null; //Creamos una Buffered Image
		try {
		    img = ImageIO.read(getClass().getResource("/recursos/iconorestaurante.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		//Escalamos la Buffered Imagen a las dimensiones de la etiqueta
		Image dimg = img.getScaledInstance(lblIcon.getWidth(), lblIcon.getHeight(),Image.SCALE_SMOOTH);
		//Creamos el ImageIcon que pasarle a la etiqueta
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblIcon.setIcon(imageIcon);
		
		frame.getContentPane().add(lblIcon);
	}

	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			//Se crea una instancia de la segunda ventana (JFrame)
//			otraVentana AplicacionSencilla  = new otraVentana();
//			//se hace visible
//			AplicacionSencilla.setVisible(true);
//			//se destruye la ventana actual (atributo a nivel de clase)
//			frame.dispose();
			boolean login = false;
			try {
				login = Agente.checkUser(connection,txtUsuario.getText(),pfPass.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(login) {
				VentanaPrincipal mainVentana = new VentanaPrincipal();
				//VentanaPrincipal.getFrame().setVisible(true);
				frame.dispose();
			}else {
				txtUsuario.setText("");
				pfPass.setText("");
				JOptionPane.showMessageDialog(null, "Nombre o Password incorrecto");
			}
		}
	}	
}
