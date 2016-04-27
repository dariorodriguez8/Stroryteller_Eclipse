package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.Validador;
import laBuena.princ;

public class princ_Control extends princ{
	
	public void registro(){
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuarioN = usuario.getText();
				String Contraseña = passwordField.getText();
				if(usuarioN.equals("")||Contraseña.equals("")){
					JOptionPane.showMessageDialog(null, "Faltan datos por completar");
					usuario.setText("");
					passwordField.setText("");
				}
				else{
				validador = new Validador();
				if(validador.ValidadorQ(usuarioN,Contraseña)){
					System.out.println("logueado");
					
				}else{
					usuario.setText("");
					passwordField.setText("");
					try {
						//ubica el jdialog encima de nuestro jFrame antes de darle visivilidad
						dialog.setLocation(thisobject.getX(), thisobject.getY());
						dialog.setVisible(true);
					} catch (Exception z) {
						z.printStackTrace();
					}
					
				}}
			}
		});	
	}

}
