package Modelo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import com.sun.mail.iap.ByteArray;

public class Conexion {

	static Connection con = null;
	private static Conexion INSTANCIA = null;

	private Conexion() {
		RealizaConexion();		
	}

	
	// METODOS
	public void RealizaConexion(){
	try {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		//conexion con la base de datos
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pi","root","");
	    //la siguiente conexion deberia enlazar con el hosting, pero no funtiona
		//con=DriverManager.getConnection("jdbc:mysql://storytellerapp.com/u950456253_laroc","u950456253_root","storycon");
	}catch (SQLException ex) {
	}catch (Exception e) {
	}		
	}

	private static void CreaInstancia(){
		if (INSTANCIA==null) {
			INSTANCIA=new Conexion();
		}
	}
	public static Conexion GetInstancia(){
		if (INSTANCIA==null) CreaInstancia();
		return INSTANCIA;
	}
	public void CierraConexion() {
		INSTANCIA = null;
		try {
			if (con != null) {
				con.close();
				System.out.println("Conexion finalizada");
			}
		} catch (SQLException e) {
			System.out.println("Error en el cierre");
			e.printStackTrace();
		}
	}

	// metodos de consultas
	public boolean ConsultaExisteImagen(String nombre){
		boolean imgbool=false;
		try {
			ResultSet rs = null;
			PreparedStatement cmd = con.prepareStatement("SELECT foto FROM usuario WHERE NombreUs LIKE \""+nombre+"\";");
			rs = cmd.executeQuery();
			rs.next();
			//Comprueba si el tamaño de la select es null
			if (rs.getBytes(1) != null) {
				imgbool=true;
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Error SQL");
		}
		return imgbool;
	}
	public BufferedImage ConsultaImagen(String nombre){
		Blob blob = null;
		BufferedImage img = null;

			try {
				ResultSet rs=null;
				PreparedStatement cmd = con.prepareStatement("SELECT foto FROM usuario WHERE NombreUs LIKE \""+nombre+"\";");
				rs = cmd.executeQuery();
				rs.next();
				blob=rs.getBlob("foto");
				byte[] data = blob.getBytes(1, (int)blob.length());
				img = ImageIO.read(new ByteArrayInputStream(data));
				
			} catch (Exception e) {
				System.out.println("Algo ha ido mal");
			}
		return img;
	} 

	public int ConsultaNumCuentos() {
		int num = 0;
		try {
			ResultSet rs = null;
			PreparedStatement cmd = con.prepareStatement("SELECT count(*) FROM cuento");
			rs = cmd.executeQuery();
			rs.next();
			num = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	public String ConsultaNombreCuentos(int i) {
		String nom = "";
		try {
			ResultSet rs = null;
			PreparedStatement cmd = con.prepareStatement("SELECT NombreCu FROM cuento");
			rs = cmd.executeQuery();
			rs.absolute(i + 1); // este metodo te lleva a la fila exacta a donde
								// quieres ir (int)
			nom = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nom;
	}

	public boolean Consulta(String id, String pass) {
		boolean rdo = false;
		try {
			ResultSet rs = null;
			PreparedStatement cmd = con.prepareStatement("SELECT count(*) FROM usuario where nombreus=? and pass=?");
			cmd.setString(1, id);
			cmd.setString(2, pass);
			rs = cmd.executeQuery();
			rs.next();
			if (rs.getInt(1) == 1) {
				// usuari correcte
				rs.close();
				rdo = true;
			} else {
				// usuari incorrecte
				System.out.println("mal login");
				rdo = false;
			}

		} catch (Exception e) {
		}
		return rdo;
	}
	
	public void guardaImagen(String ruta,String nombre) throws SQLException, FileNotFoundException
	{
	String sql = "update usuario set foto = (?) where NombreUs like \""+nombre+"\";";
	//Creamos una cadena para después prepararla
	PreparedStatement stmt = con.prepareStatement(sql);
	File imagen = new File(ruta);
	//ruta puede ser: "/home/cmop/Desktop/1.jpg"
	FileInputStream   fis = new FileInputStream(imagen);
	//Lo convertimos en un Stream
	stmt.setBinaryStream(1, fis, (int) imagen.length());
	//Asignamos el Stream al Statement
	stmt.execute();
	
	}
}