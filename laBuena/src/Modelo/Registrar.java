package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Registrar{

	public void CrearUsuario(String nombre,String Contrasena,String email){
	try
	{
	//creacion de statement
	Statement myStmnt = Conexion.con.createStatement();
	//ejecuta un query
	String update = "insert into Users (Usuario, Contraseña, Img_usuario, Email) values ('" + nombre + "' , '" + Contrasena + "', null, '"+ email +"')";
	
	myStmnt.executeUpdate(update);
	
	}
	catch (SQLException ex) 
	{
	}
	catch (Exception e) {
	}
}
	
}
