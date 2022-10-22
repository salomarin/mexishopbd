package org.mexishop.mexishop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity /// Es una entidad
@Table(name="categorias") // Estableciendo el nombre de la tabla en la base de datos
public class Categoria {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente
		@Column(name="cate_id", unique=true, nullable=false) //unico y no es nulo
		private Integer cate_id; //Read-only
		private String nombre_cat;
		
		public Categoria(String nombre_cat) {
			super();
			this.nombre_cat = nombre_cat;
		} //constructor

		public Categoria() {} //constructor

		public String getNombre_cat() {
			return nombre_cat;
		} // getNombre_Cat

		public void setNombre_cat(String nombre_cat) {
			this.nombre_cat = nombre_cat;
		} //setNombre

		public Integer getCate_id() {
			return cate_id;
		} //get Id

		@Override
		public String toString() {
			return "Categorias [cate_id=" + cate_id + ", nombre_cat=" + nombre_cat + "]";
		} //to String
		
		
} // class Categorias