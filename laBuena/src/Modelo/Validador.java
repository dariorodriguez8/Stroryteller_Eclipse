package Modelo;

import java.sql.*;


public class Validador{

	Connection con = Conexion.GetInstancia().con;
	
	public Boolean ValidadorQ(String n, String c){
	Boolean who=false;
	try
	{
	 //creacion de statement
	Statement myStmnt = con.createStatement();
	//ejecuta un query
	ResultSet myRs = myStmnt.executeQuery("select * from Usuario");
	
	while(myRs.next()) 
	{
		if((myRs.getString("NombreUs").equals(n)) && (myRs.getString("Pass").equals(c))){
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
		{//creacion de statement
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

