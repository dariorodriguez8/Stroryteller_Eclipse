package Modelo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConexionAD{
	
	public ConexionAD() {

		Connection conexion;		
	
		String url = "jdbc:mysql://ip_servidor:3306/Mundo";
		String user = "usuario";
		String pw = "password";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}

		// obtenemos la conexi�n con el DriverManager
		try {
			conexion = DriverManager.getConnection(url, user, pw);
			System.out.println("Conexi�n realizada correctamente usando DriverManager");
			Statement instruccion = (Statement) conexion.createStatement();
						
			ResultSet conjuntoResultados = instruccion.executeQuery("SELECT * FROM Personas");
			while (conjuntoResultados.next())
				System.out.println("nombre: "+ conjuntoResultados.getObject("Nombre") + " Edad "
						+ conjuntoResultados.getObject("edad"));
			conexion.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}

		// obtenemos el driver del controlador desde el DriverManager
		try {
			Driver driver = DriverManager.getDriver(url);
			Properties properties = new Properties();
			properties.setProperty("user", user);
			properties.setProperty("password", pw);
			conexion = driver.connect(url, properties);
			System.out.println("Conexi�n realizada correctamente usando Driver");
			conexion.close();

		} catch (SQLException ex) {
			System.err.println("Error " + ex.getMessage());
		}

	}
}
