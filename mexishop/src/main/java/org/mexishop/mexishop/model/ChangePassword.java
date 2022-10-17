package org.mexishop.mexishop.model;

public class ChangePassword {
	private String contrasena;
	private String newContrasena;
	
	
	public ChangePassword(String contrasena, String newContrasena) {
		super();
		this.contrasena = contrasena;
		this.newContrasena = newContrasena;
	}//1erconstructor
	
	public ChangePassword() {}//2doconstructor

	public String getContrasena() {
		return contrasena;
	} //getContraseña

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	} //setContraseña

	public String getNewContrasena() {
		return newContrasena;
	} //getNewContraseña

	public void setNewContrasena(String newContrasena) {
		this.newContrasena = newContrasena;
	} //setNewContraseña

	@Override
	public String toString() {
		return "ChangePassword [contrasena=" + contrasena + ", newContrasena=" + newContrasena + "]";
	} //to String
	
	
}//classChangecontrasena

