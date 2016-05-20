package Modelo;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import laBuena.princ;



public class Actualizar{
	public String contrasena="";
	public String usuario="";
	public Actualizar(String contraseña, String usu){
		contrasena=contraseña;
		usuario=usu;
	}
	public void actualizarContraseña(String cA, String cN) {
		String Pass = cA;
		try {
			Encriptar enc = new Encriptar();
			if (contrasena.equals(Pass)){
				Statement myStmnt = Conexion.con.createStatement();
				String actualiza = "UPDATE Usuario SET Pass=\""+enc.Encriptado(cN)+ "\" WHERE NombreUs=\""+usuario+"\"";
				myStmnt.executeUpdate(actualiza);				
			}else{
				System.out.println("Error");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		

}
