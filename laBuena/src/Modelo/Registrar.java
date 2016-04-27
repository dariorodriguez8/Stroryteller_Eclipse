package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Registrar extends Conexion {
	public void CrearUsuario(String nombre,String Contraseña,String email){
	try
	{
	Connection con = Conexion();
	 //creacion de statement
	Statement myStmnt = con.createStatement();
	//ejecuta un query
	String update = "insert into Users (Usuario, Contraseña, Img_usuario, Email) values ('" + nombre + "' , '" + Contraseña + "', null, '"+ email +"')";
	
	myStmnt.executeUpdate(update);
	
	}
	catch (SQLException ex) 
	{
	}
	catch (Exception e) {
	}
}
	
}
