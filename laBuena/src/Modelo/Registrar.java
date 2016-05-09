package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Registrar{
   
	public Registrar(String nombre,String Contrasena,String email){
	try
	{
	Connection cone = Conexion.GetInstancia().con;	
	//creacion de statement
	
	Statement myStmnt =cone.createStatement();
	//ejecuta un query
	String update = "insert into usuario(NombreUs, Pass, foto, Email) values('" + nombre + "' , '" + Contrasena + "', null, '"+ email +"')";
	
	myStmnt.executeUpdate(update);
	
	}
	catch (SQLException ex) 
	{
	}
	catch (Exception e) {
	}
}
	
}
