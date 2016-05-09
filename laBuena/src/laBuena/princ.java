package laBuena;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import Modelo.Conexion;
import Modelo.Validador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.princ_Control;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class princ extends JFrame {

	private MenuLogueado M = new MenuLogueado(this);
	private CuentosGuardados C = new CuentosGuardados(this);
	private Modificar_perfil mod = new Modificar_perfil(this);
	
	String Contrasena;
	
	
	protected JPanel contentPane;
	protected JTextField usuario;
	protected JPasswordField passwordField;
	protected princ frame;
	protected JLabel label;
	protected Validador validador;
	protected JButton btnRegistrar;
	protected JButton btnLogin;
	
	protected pantallaRegistro registro = new pantallaRegistro();
	protected princ thisobject = this;
	//princ_Control control = new princ_Control();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					princ frame = new princ();
					frame.setVisible(true);
					frame.setTitle("Storyteller");
					//la ventana no se puede redimensionar
					frame.setResizable(false);
					//falta hacer que la ventana aparezca en el centrode la pantalla
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public princ() {
		//Jdialog de error en en registro 
		//dialog = new ErrorRegistro(thisobject);
		//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		//coloca el fondo de 
		lblLogo.setIcon(new ImageIcon(princ.class.getResource("/ImagenesAplicacion/Untitled-3.jpg")));
		lblLogo.setBounds(0, -22, 300, 400);
		contentPane.add(lblLogo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 204, 113));
		panel.setBounds(300, 0, 300, 378);
		contentPane.add(panel);
		panel.setLayout(null);
		
		usuario = new JTextField();
		usuario.setFont(new Font("Arial Black", Font.BOLD, 15));
		usuario.setHorizontalAlignment(SwingConstants.CENTER);
		usuario.setBounds(66, 121, 170, 50);
		panel.add(usuario);
		usuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(66, 202, 170, 50);
		panel.add(passwordField);
		
		btnLogin = new JButton("LOGIN");
		
		btnLogin.setBounds(66, 284, 170, 43);
		panel.add(btnLogin);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(princ.class.getResource("/ImagenesAplicacion/lolll.jpg")));
		label.setBounds(0, 0, 300, 100);
		panel.add(label);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pone la pantalla de registro visible y la relocaliza
				registro.setLocation(thisobject.getX()+100, thisobject.getY());
				registro.setVisible(true);
			}
		});
		
		
		btnRegistrar.setForeground(new Color(255, 0, 0));
		btnRegistrar.setBackground(new Color(50, 205, 50));
		btnRegistrar.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		btnRegistrar.setBounds(71, 339, 160, 17);
		panel.add(btnRegistrar);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuarioN = usuario.getText();
				Contrasena = passwordField.getText();
				if(usuarioN.equals("")||Contrasena.equals("")){
					JOptionPane.showMessageDialog(null, "Faltan datos por completar");
					usuario.setText("");
					passwordField.setText("");
				}
				else{
				validador = new Validador();
				if(validador.ValidadorQ(usuarioN,Contrasena)){
					setVisible(false);
					M.setVisible(true);					
				}else{
					usuario.setText("");
					passwordField.setText("");		
					JOptionPane.showMessageDialog(null, "Error en el login");
				}}
			}
		});
	}


	public MenuLogueado getM() {
		return M;
	}
	public CuentosGuardados getCuentos() {
		return C;
	}
	public String getContraseña(){
		return Contrasena;
	}
	public Modificar_perfil getMod(){
		return mod;
	}
	
	
	
}
