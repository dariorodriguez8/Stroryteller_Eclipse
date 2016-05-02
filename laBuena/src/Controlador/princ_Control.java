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
				String Contrasena = passwordField.getText();
				if(usuarioN.equals("")||Contrasena.equals("")){
					JOptionPane.showMessageDialog(null, "Faltan datos por completar");
					usuario.setText("");
					passwordField.setText("");
				}
				else{
				validador = new Validador();
				if(validador.ValidadorQ(usuarioN,Contrasena)){
					System.out.println("logueado");
					
				}else{
					usuario.setText("");
					passwordField.setText("");
					JOptionPane.showMessageDialog(null, "Datos de login incorrectos");
				}}
			}
		});	
	}

}
