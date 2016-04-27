package Modelo;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class EnvioMail {
	

	
	
public void enviamail(String email){
	Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", "true");
	
	Session session = Session.getDefaultInstance(
			props, 
			new javax.mail.Authenticator() {
				protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
					
					return new javax.mail.PasswordAuthentication("app.storyteller@gmail.com","storycon");
								
				}}
			);
	
	try {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("app.storyteller@gmail.com"));
		message.setRecipients (Message.RecipientType.TO, InternetAddress.parse(email));
		message.setSubject("Bienvenido a Storyteller");
		message.setText("Hola, gracias por usar nuestra aplicacion, estamos trabajando en mejorarla");;
		Transport.send(message);
		JOptionPane.showMessageDialog(null, "Mensaje enviado");
	} catch (Exception e) {	
	}
	}	
}
