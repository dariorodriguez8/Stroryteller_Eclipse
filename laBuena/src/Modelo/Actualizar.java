package Modelo;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import laBuena.princ;



public class Actualizar{
	public String contrasena="";
	private princ vp;
	public Actualizar(String contraseña){
		contrasena=contraseña;
	}
	public void actualizarContraseña(String cA, String cN) {
		String nombre ="Pablo";
		String Pass = cA;
		try {
			if (contrasena.equals(Pass)){
				Statement myStmnt = Conexion.con.createStatement();
				String actualiza = "UPDATE Usuario SET Pass=\""+cN+ "\" WHERE NombreUs=\""+nombre+"\"";
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
