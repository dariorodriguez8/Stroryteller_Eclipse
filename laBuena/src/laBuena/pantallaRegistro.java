package laBuena;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import Modelo.Validador;
import Modelo.EnvioMail;
import Modelo.Registrar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.registro_Control;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class pantallaRegistro extends JFrame {
	
	protected Validador validador;
	protected Registrar registrador;
	protected pantallaRegistro frame; 
	pantallaRegistro thisobject = this;
	
	protected JPanel contentPane,panelExito;
	protected JTextField usuario,email;
	protected JButton btnRegistrar;
	protected JPasswordField password;
	protected JLabel lblUsuario,lblEmail,lblNewLabel;
	protected JLabel Exito;
	protected JButton btnAceptar;
	

	//registro_Control control = new registro_Control();		
			public void run() {
				try {
				    frame = new pantallaRegistro();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	public pantallaRegistro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelExito = new JPanel();
		panelExito.setBounds(33, 118, 295, 202);
		contentPane.add(panelExito);
		panelExito.setLayout(null);
		panelExito.setVisible(false);
		
		Exito = new JLabel("Exito en el registro");
		Exito.setHorizontalAlignment(SwingConstants.CENTER);
		Exito.setBounds(53, 67, 167, 42);
		panelExito.add(Exito);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelExito.setVisible(false);
				thisobject.setVisible(false);
				
			}
		});
		btnAceptar.setBounds(85, 144, 117, 29);
		panelExito.add(btnAceptar);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(7, 205, 61, 16);
		contentPane.add(lblUsuario);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(7, 283, 61, 16);
		contentPane.add(lblEmail);
		
		lblNewLabel = new JLabel("PASS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(7, 359, 61, 16);
		contentPane.add(lblNewLabel);
		
		usuario = new JTextField();
		usuario.setToolTipText("Usuario");
		usuario.setBounds(80, 190, 178, 46);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		email = new JTextField();
		email.setToolTipText("E-mail");
		email.setBounds(80, 268, 178, 46);
		contentPane.add(email);
		email.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				validador= new Validador();
				if(password.getText().equals("")||usuario.getText().equals("")||email.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Faltan datos por completar");
				}
				else{
					//si es true quiere decir que existed un usuario con el mismo nombre
					if(validador.ValidadorUsuario(usuario.getText())){
						//debe mostrar un mensaje de error
						JOptionPane.showMessageDialog(null, "Existe un usuario con el mismo nombre");
						
					}
					else{
						//procede al registro
						registrador=new Registrar();
						registrador.CrearUsuario(usuario.getText(), password.getText(), email.getText());
						EnvioMail m = new EnvioMail();
						m.enviamail(email.getText());
						password.setText("");
						usuario.setText("");
						email.setText("");
						
						
						//no me deja poner invisible el jframe desde aqui
						//frame.setVisible(false);
					    JOptionPane.showMessageDialog(null, "Se ha realizado el registro con exito");
						
						
					}
					
				}
				
			
				}
		});
		
		password = new JPasswordField();
		password.setBounds(80, 344, 178, 46);
		contentPane.add(password);
		btnRegistrar.setBounds(80, 413, 178, 46);
		contentPane.add(btnRegistrar);
		
		JLabel label = new JLabel("");
		//label.setIcon(new ImageIcon("/Users/noel98_socorro/Desktop/Untitled-8.jpg"));
		label.setBounds(0, -22, 350, 500);
		contentPane.add(label);
	}
}
