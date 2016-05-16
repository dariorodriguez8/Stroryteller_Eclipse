package laBuena;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Modelo.Actualizar;
import Modelo.CargarFoto;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;


import java.awt.Component;
import javax.swing.JSplitPane;

public class Modificar_perfil extends JPanel {
	private princ vp;
	private JTextField txtAntiguaContrasea;
	private JTextField txtNuevaContrasea;
	File fichero=null;
	ImageIcon icon = null;
	Icon icono = null;
	

	/**
	 * Create the panel.
	 */
	//Metodo para abrir el buscador de ficheros, por defecto busca jpg
	
public void cargaImagen(JLabel lbl){
		
		JLabel lblFoto = lbl;
		int resultado;
		
		
		CargarFoto ventana = new CargarFoto();

	    FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png");

	    ventana.jfchCargarfoto.setFileFilter(filtro);

	    resultado= ventana.jfchCargarfoto.showOpenDialog(null);
	    
	    if (JFileChooser.APPROVE_OPTION == resultado){

	        fichero = ventana.jfchCargarfoto.getSelectedFile();

	        try{

	                icon = new ImageIcon(fichero.toString());

	                icono = new ImageIcon(icon.getImage().
	                getScaledInstance(100, 100, Image.SCALE_DEFAULT));

	                lblFoto.setText(null);

	                lblFoto.setIcon( icono );

	        }catch(Exception ex){

	                JOptionPane.showMessageDialog(null, 
	                "Error abriendo la imagen "+ ex);

	        }
	    }
}
	public Modificar_perfil(princ vp) {
		setBackground(new Color(46, 204, 113));
		setLayout(new GridLayout(0, 5, 0, 0));
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(46, 204, 113));
		add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(46, 204, 113));
		add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel label_1 = new JLabel("");
		label_1.setBackground(new Color(46, 204, 113));
		panel_3.add(label_1);

		JButton btnInicio = new JButton("Inicio");
		panel_3.add(btnInicio);
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				vp.getM().Principal.setVisible(true);
			}
		});

		JButton btnCambiarImagen = new JButton("Cambiar Imagen");
		add(btnCambiarImagen);

		btnCambiarImagen.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
					cargaImagen(vp.getM().getLblImagen());
				//JOptionPane.showMessageDialog(null, "Se ha modificado la imagen");
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 204, 113));
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		txtAntiguaContrasea = new JTextField();
		panel.add(txtAntiguaContrasea);
		txtAntiguaContrasea.setBounds(10, 100, 170, 50);
		txtAntiguaContrasea.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				// si no tiene texto, lo rellena con el default
				if (txtAntiguaContrasea.getText().isEmpty()) {
					txtAntiguaContrasea.setText("Antigua contrase\u00F1a");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// vacia el campo cuando lo clicas
				if (txtAntiguaContrasea.getText().equals("Antigua contrase\u00F1a")) {
					txtAntiguaContrasea.setText("");
				}
			}
		});
		txtAntiguaContrasea.setColumns(16);

		txtNuevaContrasea = new JTextField();
		panel.add(txtNuevaContrasea);

		txtNuevaContrasea.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				// si no tiene texto, lo rellena con el default
				if (txtNuevaContrasea.getText().isEmpty()) {
					txtNuevaContrasea.setText("Nueva contrase\u00F1a");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// vacia el campo cuando lo clicas y no tiene default escrito
				if (txtNuevaContrasea.getText().equals("Nueva contrase\u00F1a")) {
					txtNuevaContrasea.setText("");
				}
			}
		});
		txtNuevaContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtAntiguaContrasea.getText().isEmpty() || txtNuevaContrasea.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Faltan campos por rellenar");
				} else {
					if (vp.getContrase�a().equals(txtAntiguaContrasea.getText())) {
						JOptionPane.showMessageDialog(null, "Se ha modificado la contrase�a");
						Actualizar act = new Actualizar(vp.getContrase�a(), vp.getUsuario());
						act.actualizarContrase�a(txtAntiguaContrasea.getText(), txtNuevaContrasea.getText());
					} else {
						JOptionPane.showMessageDialog(null, "La contrase�a no es correcta");
					}

				}
			}
		});
		txtNuevaContrasea.setText("Nueva contrase\u00F1a");
		txtNuevaContrasea.setColumns(16);

		JButton btnCambiarContrase�a = new JButton("Cambiar Contrase\u00F1a");
		panel.add(btnCambiarContrase�a);

		btnCambiarContrase�a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtAntiguaContrasea.getText().isEmpty() || txtNuevaContrasea.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Faltan campos por rellenar");
				} else {
					if (vp.getContrase�a().equals(txtAntiguaContrasea.getText())) {
						JOptionPane.showMessageDialog(null, "Se ha modificado la contrase�a");
						Actualizar act = new Actualizar(vp.getContrase�a(), vp.getUsuario());
						act.actualizarContrase�a(txtAntiguaContrasea.getText(), txtNuevaContrasea.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Las contrase�as no coinciden");
					}

				}
			}
		});

	}

	public void resetTexto() {
		txtAntiguaContrasea.setText("Antigua contrase�a");
		txtNuevaContrasea.setText("Nueva contrase�a");
	}
}
