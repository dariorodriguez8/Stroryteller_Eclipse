package laBuena;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Modelo.ConexionAD2;
import Modelo.Validador;

public class princ extends JFrame {
	public JCheckBox chckbxEnglish_1 = new JCheckBox("English");

	private MenuLogueado M = new MenuLogueado(this);
	private CuentosGuardados C = new CuentosGuardados(this);
	private Modificar_perfil mod = new Modificar_perfil(this);

	String Contrasena;
	String usuarioN;

	protected JPanel contentPane;
	protected JTextField usuario;
	protected JPasswordField passwordField;
	protected princ frame;
	protected JLabel label;
	protected Validador validador;
	protected JButton btnRegistrar;
	protected JButton btnLogin;
	protected princ thisobject = this;
	protected JCheckBox chckbxAdmin;

	protected pantallaRegistro registro = new pantallaRegistro();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					princ frame = new princ();
					frame.setVisible(true);
					frame.setTitle("Storyteller");
					// la ventana no se puede redimensionar
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public princ() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogo = new JLabel("");
		// coloca el fondo
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
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loguea();
			}
		});

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
				// pone la pantalla de registro visible y la relocaliza
				registro.setLocation(thisobject.getX() + 100, thisobject.getY());
				registro.setVisible(true);
			}
		});

		btnRegistrar.setForeground(new Color(255, 0, 0));
		btnRegistrar.setBackground(new Color(50, 205, 50));
		btnRegistrar.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		btnRegistrar.setBounds(71, 339, 160, 17);
		panel.add(btnRegistrar);

		chckbxEnglish_1 = new JCheckBox("");

		chckbxEnglish_1.setBackground(new Color(46, 204, 113));
		chckbxEnglish_1.setBounds(104, 259, 58, 23);
		panel.add(chckbxEnglish_1);

		File imgDir = new File(".\\bin\\ImagenesAplicacion");
		String rutaImg = imgDir.getAbsolutePath() + "\\flag.png";
		chckbxEnglish_1.setIcon(new ImageIcon(rutaImg));

		chckbxAdmin = new JCheckBox("admin");
		chckbxAdmin.setBounds(179, 259, 97, 23);
		chckbxAdmin.setBackground(new Color(46, 204, 113));
		panel.add(chckbxAdmin);
		chckbxEnglish_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxEnglish_1.isSelected()) {
					File imgDir = new File(".\\bin\\ImagenesAplicacion");
					String rutaImg = imgDir.getAbsolutePath() + "\\flag2.png";
					chckbxEnglish_1.setIcon(new ImageIcon(rutaImg));
				} else {
					File imgDir = new File(".\\bin\\ImagenesAplicacion");
					String rutaImg = imgDir.getAbsolutePath() + "\\flag.png";
					chckbxEnglish_1.setIcon(new ImageIcon(rutaImg));
				}
			}
		});

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C.updateUI();
				M = new MenuLogueado(thisobject);
				mod.updateUI();
				Loguea();
			}
		});
	}

	public void Loguea() {
		// metodo que realiza el Login, atacando a la base de datos y comparando
		// el usuario y la contraseña(ya cifrada)
		usuarioN = usuario.getText();
		Contrasena = passwordField.getText();
		if (usuarioN.isEmpty() || Contrasena.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Faltan datos por completar");
			usuario.setText("");
			passwordField.setText("");
		} else {
			// aqui comprueba si has seleccionado si eres administrador o no
			if (chckbxAdmin.isSelected()) {
				ConexionAD2 AD2 = new ConexionAD2();
				AD2.ConexionAD2(usuarioN, Contrasena);
				MenuAdmin frame = new MenuAdmin();
				frame.setVisible(true);
				dispose();
			} else {
				validador = new Validador();
				if (validador.ValidadorQ(usuarioN, Contrasena)) {
					M.setNombreUsuario(usuarioN);
					M.setVisible(true);
					getM().imagenPerfil();
					dispose();

				} else {
					validador = new Validador();
					if (validador.ValidadorQ(usuarioN, Contrasena)) {
						M.setNombreUsuario(usuarioN);
						M.setVisible(true);
						getM().imagenPerfil();
						dispose();

					} else {
						usuario.setText("");
						passwordField.setText("");
						JOptionPane.showMessageDialog(null, "Error en el login");
					}
				}
			}
		}

	}

	public MenuLogueado getM() {
		return M;
	}

	public CuentosGuardados getCuentos() {
		return C;
	}

	public Modificar_perfil getMod() {
		return mod;
	}

	public String getUsuario() {
		return usuarioN;
	}

	public String getContraseña() {
		return Contrasena;
	}

	public void setContraseña(String pw) {
		Contrasena = pw;
	}
}