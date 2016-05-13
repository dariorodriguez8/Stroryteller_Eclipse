package Modelo;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import laBuena.princ;



public class Actualizar{
	public String contrasena="";
	public String usuario="";
	private princ vp;
	public Actualizar(String contraseña, String usu){
		contrasena=contraseña;
		usuario=usu;
	}
	public void actualizarContraseña(String cA, String cN) {
		String Pass = cA;
		try {
			if (contrasena.equals(Pass)){
				Statement myStmnt = Conexion.con.createStatement();
				System.out.println(usuario);
				String actualiza = "UPDATE Usuario SET Pass=\""+cN+ "\" WHERE NombreUs=\""+usuario+"\"";
				myStmnt.executeUpdate(actualiza);
			}else{
				System.out.println("Error");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizarImagen(){
		
	}

}
