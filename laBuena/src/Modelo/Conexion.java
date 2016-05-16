package Modelo;

import java.sql.*;

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
	public boolean ConsultaImagen(String nombre){
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

}