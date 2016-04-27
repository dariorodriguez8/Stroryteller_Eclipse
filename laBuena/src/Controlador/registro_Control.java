package Controlador;

import javax.swing.JOptionPane;

import Modelo.EnvioMail;
import Modelo.Registrar;
import Modelo.Validador;
import laBuena.pantallaRegistro;

public class registro_Control extends pantallaRegistro{

	public void validator(){
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
				
				panelExito.setVisible(true);
				//no me deja poner invisible el jframe desde aqui
				//frame.setVisible(false);
			    //JOptionPane.showMessageDialog(null, "Se ha realizado el registro con exito");
				
				
			}
			
		}
	
	}
	
}
	

