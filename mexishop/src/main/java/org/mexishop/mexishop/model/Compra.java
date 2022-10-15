package org.mexishop.mexishop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="compra")
public class Compra {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcompra", unique=true, nullable=false)

	private Integer idcompra;
	private Integer total_compra;
	private Integer usuarios_user_id;
	public Compra(Integer idcompra, Integer total_compra, Integer usuarios_user_id) {
		super();
		this.idcompra = idcompra;
		this.total_compra = total_compra;
		this.usuarios_user_id = usuarios_user_id;
	}
	
	//GET
	public Compra() {
	}
	public Integer getTotal_compra() {
		return total_compra;
	}
	public void setTotal_compra(Integer total_compra) {
		this.total_compra = total_compra;
	}
	public Integer getUsuarios_user_id() {
		return usuarios_user_id;
	}
	public void setUsuarios_user_id(Integer usuarios_user_id) {
		this.usuarios_user_id = usuarios_user_id;
	}
	public Integer getIdcompra() {
		return idcompra;
	}
	
	//tOsTRING
	@Override
	public String toString() {
		return "Compra [idcompra=" + idcompra + ", total_compra=" + total_compra + ", usuarios_user_id="
				+ usuarios_user_id + "]";
	}
	
	
	
	

}//class Compra
