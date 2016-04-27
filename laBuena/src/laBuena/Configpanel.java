package laBuena;

import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import Modelo.Subir_img;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;


// basado en http://1bestcsharp.blogspot.com.es/2015/04/java-how-to-insert-image-in-mysql-Database-Using-Java.html
public class Configpanel extends JPanel {
	
	JButton button ;
	JButton button2;
	JLabel label;
	String s;
	
	public Configpanel() {
		setLayout(null);
		
		button = new JButton("ADD");
		button.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				//Subir_img subeIMG = new Subir_img(img, nombre);
			}
		});
		button.setBounds(80,227,100,40);
		add(button);
		
		button2 = new JButton("Browse");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif");
				fileChooser.addChoosableFileFilter(filter);
				int result = fileChooser.showSaveDialog(null);
				
				if(result == JFileChooser.APPROVE_OPTION){
					File selectedFile = fileChooser.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					label.setIcon(ResizeImage(path));
					s = path;
					}
				else if(result == JFileChooser.CANCEL_OPTION){
					System.out.println("No Data"); 
					}
			}
		});
		
		button2.setBounds(80, 175, 100, 40);
		add(button2);
		
		label = new JLabel(); 
		label.setIcon(new ImageIcon(Configpanel.class.getResource("/ImagenesAplicacion/login.jpg")));
		label.setBounds(80,63,100,100);
		add(label);
		
	}

	public ImageIcon ResizeImage(String imgPath){
		ImageIcon MyImage = new ImageIcon(imgPath);
		Image img = MyImage.getImage();
		Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImage);
		return image; }
	



}
	
