package Modelo;
import java.sql.*;


public class Conexion {
	
	public 	Connection Conexion(){
		Connection con =null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//conexion con la base de datos
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/laRoca","root","");
		    //la siguiente conexion deberia enlazar con el hosting, pero no funtiona
			//con=DriverManager.getConnection("jdbc:mysql://storytellerapp.com/u950456253_laroc","u950456253_root","storycon");
		}catch (SQLException ex) {
		}catch (Exception e) {
		}
		return con;
		
	}
}

