package Modelo;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Encriptar {

	public Encriptar() {
	}
	
public String Encriptado (String contra) { 
	 
	String passUsuario= ""; // STRING UTILIZAD PARA ENCRIPTAR 
	String passEncriptada=""; // STRING RESERVADO PARA ALMACENAR LA ENCRIPTACION 
	 
	try{ 
	 
	MessageDigest md = MessageDigest.getInstance("MD5"); // INSTANCIA md PARA INSTANCIAR ARQUITECTURA MD5 
	byte[] nuevaPass = md.digest(passUsuario.getBytes("UTF-8")); // ARRAY PARA PASAR A BYTES LA CLAVE CON LA COD. UTF-8 
	byte[] passByte = Arrays.copyOf(nuevaPass, 24); // NUEVO ARRAY AL QUE ASIGNAR LA COD CON UN TAMAÑO (24 EN ESTE CASO) 
	 
	SecretKey pass = new SecretKeySpec(passByte,"DESede"); // ASIGNAR UNA VARIABLE A UNA CLASE SECRETKEY CON EL METODO DE DESede (ENCRIPT/DESENCRIP) 
	Cipher cipher = Cipher.getInstance("DESede"); //INSTANCIAR CLASE CIPHER QUE ES LA QUE ENCRIPTARA LA CONTRASEÑA 
	cipher.init(Cipher.ENCRYPT_MODE, pass); // ASIGNAR LA VARIABLE ANTERIOR A LA CLASE CIPHER (PARA ENCRIPTAR) 
	 
	byte[] textoByte = contra.getBytes("utf-8"); // ARRAY PARA LLAMAR A LA CLASE DE USUARIO Y PASARLA A BYTES CON LA COD UTF-8 
	byte[] buf = cipher.doFinal(textoByte); // ARRAY ENCARGADO DE CODIFICAR LA CONTRASEÑA CON LA CLASE CIPHER 
	byte[] encrip = Base64.getEncoder().encode(buf); // UTILIZADO PARA ENCRIPTAR LA CONTRASEÑA EN BASE64 
	passEncriptada = new String(encrip); // PASAR LA CONTRASEÑA DE BYTES A STRINGS 
	
	 
	}catch (Exception e) { 
	e.getMessage(); 
	} 
	 
	return passEncriptada; 
	}
}