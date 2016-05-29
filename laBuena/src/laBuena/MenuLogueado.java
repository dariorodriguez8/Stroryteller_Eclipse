package laBuena;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Conexion;

public class MenuLogueado extends JFrame {

	private princ vp;
	private JPanel contentPane;
	private String nombreUsuario = "";
	private JPanel panel_1;
	private JPanel cuerpo;
	private JLabel lblNombre;
	private JLabel lblImagen;
	JPanel Principal;

	/**
	 * Launch the application.
	 */
	// Método para poner visible la imagen de perfil.
	public void imagenPerfil() {
		if (Conexion.GetInstancia().ConsultaExisteImagen(nombreUsuario) == true) {
			lblImagen.setText(null);

			BufferedImage img = Conexion.GetInstancia().ConsultaImagen(nombreUsuario);
			lblImagen.setIcon(new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			lblImagen.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblImagen.setIcon(new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
					lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblImagen.setIcon(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
					lblNombre.setFont(new Font("Tahoma", Font.BOLD, 24));
				}

				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});

		} else {
			File imgDir = new File(".\\bin\\ImagenesAplicacion");

			String rutaImg = imgDir.getAbsolutePath() + "\\login.jpg";
			lblImagen.setText("");
			lblImagen.setIcon(new ImageIcon(rutaImg));
		}
	}

	public static void creaVentana(princ v) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuLogueado frame = new MenuLogueado(v);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuLogueado(princ v) {
		vp = v;
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
			}

			@Override
			public void windowClosed(WindowEvent e) {
				Conexion.GetInstancia().CierraConexion();
				vp.getMod().resetTexto();
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(56, 142, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(56, 142, 60));
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel DatosUsuario = new JPanel();
		DatosUsuario.setBackground(new Color(56, 142, 60));
		panel_1.add(DatosUsuario);

		lblNombre = new JLabel(nombreUsuario);
		lblNombre.setBackground(new Color(56, 142, 60));

		lblImagen = new JLabel("Im\u00E1gen");
		lblImagen.setBounds(0, 0, 75, 75);
		if (vp.chckbxEnglish_1.isSelected()) {
			lblImagen.setText("Image");
		}
		lblImagen.setBackground(new Color(56, 142, 60));
		DatosUsuario.add(lblImagen);
		DatosUsuario.add(lblNombre);

		JPanel vacio = new JPanel();
		vacio.setBackground(new Color(56, 142, 60));
		panel_1.add(vacio);

		JPanel ModificarUsuario = new JPanel();
		ModificarUsuario.setBackground(new Color(56, 142, 60));
		panel_1.add(ModificarUsuario);
		panel_1.setBackground(new Color(56, 142, 60));
		ModificarUsuario.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnModificar = new JButton();
		btnModificar.setBorderPainted(false);
		btnModificar.setBorder(null);
		btnModificar.setContentAreaFilled(false);
		btnModificar.setIcon(new ImageIcon(".\\bin\\ImagenesAplicacion\\sett.jpg"));
		btnModificar.setRolloverIcon(new ImageIcon(".\\bin\\ImagenesAplicacion\\sett2.jpg"));

		ModificarUsuario.add(btnModificar);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cuerpo.add(vp.getMod());
				Principal.setVisible(false);
				vp.getCuentos().setVisible(false);
				vp.getMod().setVisible(true);
			}
		});
		JButton btnLogout = new JButton();

		btnLogout.setBorderPainted(false);
		btnLogout.setBorder(null);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setIcon(new ImageIcon(".\\bin\\ImagenesAplicacion\\logout.jpg"));
		btnLogout.setRolloverIcon(new ImageIcon(".\\bin\\ImagenesAplicacion\\logout2.jpg"));

		ModificarUsuario.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vp.setVisible(true);
				dispose();
			}
		});

		cuerpo = new JPanel();
		cuerpo.setBackground(new Color(46, 204, 113));
		contentPane.add(cuerpo);

		Principal = new JPanel();
		Principal.setBackground(new Color(46, 204, 113));
		cuerpo.add(Principal);

		JButton btnCuentosGuardados;
		btnCuentosGuardados = new JButton("Cuentos Guardados");
		if (vp.chckbxEnglish_1.isSelected()) {
			btnCuentosGuardados.setText(("Saved Tales"));
		}
		btnCuentosGuardados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cuerpo.add(vp.getCuentos());
				Principal.setVisible(false);
				vp.getCuentos().setVisible(true);
			}
		});
		Principal.add(btnCuentosGuardados);

		JButton btnTienda;
		btnTienda = new JButton("Tienda");
		btnTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane futuro = new JOptionPane();
				futuro.showMessageDialog(btnTienda, "Futura implementación");
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop().browse(new URI("http://www.google.com"));
					} catch (IOException e) {
						e.printStackTrace();
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
				}
			}
		});
		if (vp.chckbxEnglish_1.isSelected()) {
			btnTienda.setText("Shop");
		}
		Principal.add(btnTienda);

	}

	public void setNombreUsuario(String nombreUsuario) {
		String letras = "";
		for (int i = 0; i < (nombreUsuario.length()); i++) {
			if (nombreUsuario.charAt(i) == ' ') {
				letras = letras.substring(0, i + 1) + nombreUsuario.substring(i + 1, i + 2).toUpperCase()
						+ nombreUsuario.substring(i + 2);
			} else if (i == 0) {
				letras = nombreUsuario.substring(0, 1).toUpperCase() + nombreUsuario.substring(1);
			}
		}
		this.nombreUsuario = letras;
		lblNombre.setText("   " + this.nombreUsuario);

	}

	public JLabel getLblImagen() {
		return lblImagen;
	}

}
