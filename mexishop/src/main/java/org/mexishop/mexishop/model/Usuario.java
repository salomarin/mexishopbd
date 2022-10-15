package org.mexishop.mexishop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id //Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column (name="user_id", unique=true, nullable=false)
	private Integer user_id;
	private String nombre;
	private String tel;
	private String email;
	private String contrasena;
	public Usuario(String nombre, String tel, String email, String contrasena) {
		super();
		this.nombre = nombre;
		this.tel = tel;
		this.email = email;
		this.contrasena = contrasena;
	}//constructor
	
	public Usuario() {
		
	}//constructor

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getTel() {
		return tel;
	}//getTel

	public void setTel(String tel) {
		this.tel = tel;
	}//setTel

	public String getEmail() {
		return email;
	}//getEmail

	public void setEmail(String email) {
		this.email = email;
	}//setEmail

	public String getContrasena() {
		return contrasena;
	}//getContrasena

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}//setContrasena

	public Integer getId() {
		return user_id;
	}//getId

	@Override
	public String toString() {
		return "Usuario [id=" + user_id + ", nombre=" + nombre + ", tel=" + tel + ", email=" + email + ", contrasena="
				+ contrasena + "]";
	}//toString
	
}//class Usuario
