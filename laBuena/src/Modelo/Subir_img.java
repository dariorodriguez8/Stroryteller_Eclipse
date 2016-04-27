package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.omg.CORBA.portable.InputStream;

import com.mysql.jdbc.PreparedStatement;

public class Subir_img extends Conexion{
	public static void main(String[] args) {
		File f = new File("/Users/noel98_socorro/Desktop/login.jpg");
		Subir_img img = new Subir_img(f, "dario");
	}
	public Subir_img (File img, String nombre){
		try
		{
		Connection con = Conexion();
		//creacion de statement
		//Statement myStmnt = con.createStatement();
		PreparedStatement psmnt = null;
		

		
		/* inspirado en http://www.roseindia.net/jdbc/save_image.shtml */
		
		
		File image = img;
		/* prepareStatement() is used for create statement object that is 
		used for sending sql statements to the specified database. */
		
		FileInputStream fis = new FileInputStream(image);
		//InputStream is = fis;
		
		psmnt = (PreparedStatement) con.prepareStatement
				("insert into Users() "+ "values(Img_Usuario) WHERE `Usuario` = '"+ nombre+"'");
		//psmnt.setBinaryStream(1, is, (int)(image.length()));
		
		
		int s = psmnt.executeUpdate();
		
		
		if(s>0) {
			System.out.println("Se ha subido la imagen !");
			}
			else {
			System.out.println("No ne ha conseguido subir la imagen");
			}
		}
		catch (SQLException ex) 
		{
		}
		catch (Exception e) {
		}
	
		
		
		
	}
}
