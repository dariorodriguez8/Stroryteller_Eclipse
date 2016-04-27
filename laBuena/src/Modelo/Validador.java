package Modelo;

import java.sql.*;


public class Validador extends Conexion{
	public Boolean ValidadorQ(String n, String c){
	Boolean who=false;
	try
	{
	Connection con = Conexion();
	 //creacion de statement
	Statement myStmnt = con.createStatement();
	//ejecuta un query
	ResultSet myRs = myStmnt.executeQuery("select * from Users");
	
	while(myRs.next()) 
	{
		if((myRs.getString("Usuario").equals(n)) && (myRs.getString("Contraseña").equals(c))){
			who=true;
		    
		}
	
	}
	}
	catch (SQLException ex) 
	{
	}
	catch (Exception e) {
	}
	return who;
	}
	
	
	public Boolean ValidadorUsuario(String n){
		Boolean who=false;
		try
		{
		Connection con = Conexion();
		 //creacion de statement
		Statement myStmnt = con.createStatement();
		//ejecuta un query
		ResultSet myRs = myStmnt.executeQuery("select * from Users");
		
		while(myRs.next()) 
		{
			if((myRs.getString("Usuario").equals(n))){
				who=true;
			}
		}
		}
		catch (SQLException ex) 
		{
		}
		catch (Exception e) {
		}
		return who;
		}
	
	}

