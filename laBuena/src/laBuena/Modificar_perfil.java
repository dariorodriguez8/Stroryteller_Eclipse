package laBuena;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Modelo.Actualizar;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;

import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JSplitPane;

public class Modificar_perfil extends JPanel {
	private princ vp;
	private JTextField txtAntiguaContrasea;
	private JTextField txtNuevaContrasea;
	JPanel Modificar;
	/**
	 * Create the panel.
	 */
	public Modificar_perfil(princ vp) {
		setLayout(new GridLayout(0, 5, 0, 0));
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel label_1 = new JLabel("");
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
				JOptionPane.showMessageDialog(null, "Se ha modificado la imagen");
			}
		});
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		txtAntiguaContrasea = new JTextField();
		panel.add(txtAntiguaContrasea);
		txtAntiguaContrasea.setBounds(10, 100, 170, 50);
		txtAntiguaContrasea.setText("Antigua contrase\u00F1a");
		txtAntiguaContrasea.setColumns(16);
		
		txtNuevaContrasea = new JTextField();
		panel.add(txtNuevaContrasea);
		txtNuevaContrasea.setText("Nueva contrase\u00F1a");
		txtNuevaContrasea.setColumns(16);
		
		
		JButton btnCambiarContrase�a = new JButton("Cambiar Contrase\u00F1a");
		panel.add(btnCambiarContrase�a);
		
		JLabel label = new JLabel("");
		add(label);
		
		btnCambiarContrase�a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtAntiguaContrasea.getText().isEmpty() || txtNuevaContrasea.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Faltan campos por rellenar");
				}else{
					if (vp.getContrase�a().equals(txtAntiguaContrasea.getText())){
						JOptionPane.showMessageDialog(null, "Se ha modificado la contrase�a");
						Actualizar act = new Actualizar(vp.getContrase�a());
						act.actualizarContrase�a(txtAntiguaContrasea.getText(), txtNuevaContrasea.getText());
					}else{
						JOptionPane.showMessageDialog(null, "Las contrase�as no coinciden");
					}
					
				}
			}
		});
		
	}
}