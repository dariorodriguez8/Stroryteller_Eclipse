package laBuena;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Conexion;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MenuLogueado extends JFrame implements ActionListener{

	private princ vp;
	private JPanel contentPane;
	private String nombreUsuario="asdf";
	private JPanel panel_1;
	private JPanel cuerpo;
	JPanel Principal;
	/**
	 * Launch the application.
	 */
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
	public MenuLogueado(princ v){
		vp = v;
		this.addWindowListener(new WindowListener() {		
			@Override
			public void windowOpened(WindowEvent e) {}			
			@Override
			public void windowIconified(WindowEvent e) {}			
			@Override
			public void windowDeiconified(WindowEvent e) {}		
			@Override
			public void windowDeactivated(WindowEvent e) {}		
			@Override
			public void windowClosing(WindowEvent e) {}
			@Override
			public void windowClosed(WindowEvent e) {	
					Conexion.GetInstancia().CierraConexion();					
			}
			@Override
			public void windowActivated(WindowEvent e) {}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel DatosUsuario = new JPanel();
		panel_1.add(DatosUsuario);
		
		JLabel lblNombre = new JLabel(nombreUsuario);
		DatosUsuario.add(lblNombre);
		
		JLabel lblImagen = new JLabel("Im\u00E1gen");
		DatosUsuario.add(lblImagen);
		
		JPanel vacio = new JPanel();
		panel_1.add(vacio);
		
		JPanel ModificarUsuario = new JPanel();
		panel_1.add(ModificarUsuario);
		ModificarUsuario.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnModificar = new JButton("Modificar Usuario");
		ModificarUsuario.add(btnModificar);
		
		cuerpo = new JPanel();
		contentPane.add(cuerpo);
		
		Principal = new JPanel();
		cuerpo.add(Principal);
		
		JButton btnCuentosGuardados = new JButton("Cuentos Guardados");
		btnCuentosGuardados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("cuentos Guardados");
				cuerpo.add(vp.getCuentos());
				Principal.setVisible(false);
				vp.getCuentos().setVisible(true);
			}
		});
		Principal.add(btnCuentosGuardados);
		
		JButton btnTienda = new JButton("Tienda");
		Principal.add(btnTienda);
		
		
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panel_1.setVisible(false);
		switch (e.getActionCommand().toString()) {
		case "Cuentos Guardados":
			cuerpo.add(vp.getCuentos());
			Principal.setVisible(false);
			vp.getCuentos().setVisible(true);
			break;

		default:
			break;
		}
	}
	
	
}
