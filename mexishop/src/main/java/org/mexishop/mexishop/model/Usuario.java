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
	private Integer id;
	@Column(name="nombre", nullable=false)
	private String nombre;
	@Column(name="tel", nullable=false)
	private String tel;
	@Column(name="email", nullable=false)
	private String email;
	@Column(name="contrasena", nullable=false)
	private String contrasena;
	public Usuario(String nombre, String tel, String email, String contrasena) {
		super();
		this.nombre = nombre;
		this.tel = tel;
		this.email = email;
		this.contrasena = contrasena;
	} //constructor 1°
	
	public Usuario() {	} //constructor vacio

	public String getNombre() {
		return nombre;
	} //getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	} //setNombre

	public String getTel() {
		return tel;
	} //getTelefono

	public void setTel(String tel) {
		this.tel = tel;
	} //setTelefono

	public String getEmail() {
		return email;
	} //getEmail

	public void setEmail(String email) {
		this.email = email;
	} //setEmail

	public String getContrasena() {
		return contrasena;
	} //getContraseña

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	} //setContraseña

	public Integer getId() {
		return id;
	} //getId

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", tel=" + tel + ", email=" + email + ", contrasena="
				+ contrasena + "]";
	} //toString
	
}//class Usuario
