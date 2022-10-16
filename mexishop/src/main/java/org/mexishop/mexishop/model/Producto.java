package org.mexishop.mexishop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")

public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id", unique=true, nullable=false)
	private Integer product_id;
	private String prod_nombr;
	@Column(name="prod_link")
	private String prod_Link;
	private String prod_desc;
	private int inventario_cant;
	private int categorias_cate_id;
	private int precio_prod;
	
	public Producto(Integer product_id, String prod_nombr, String prod_Link, String prod_desc, Integer inventario_cant,
			Integer categorias_cate_id, Integer precio_prod) {
		super();
		this.product_id = product_id;
		this.prod_nombr = prod_nombr;
		this.prod_Link = prod_Link;
		this.prod_desc = prod_desc;
		this.inventario_cant = inventario_cant;
		this.categorias_cate_id = categorias_cate_id;
		this.precio_prod = precio_prod;
	}//primerConstructor

	public Producto(){}//2doConstructor
	
   //Getters and Setters

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProd_nombr() {
		return prod_nombr;
	}

	public void setProd_nombr(String prod_nombr) {
		this.prod_nombr = prod_nombr;
	}

	public String getProd_Link() {
		return prod_Link;
	}

	public void setProd_Link(String prod_Link) {
		this.prod_Link = prod_Link;
	}

	public String getProd_desc() {
		return prod_desc;
	}

	public void setProd_desc(String prod_desc) {
		this.prod_desc = prod_desc;
	}

	public int getInventario_cant() {
		return inventario_cant;
	}

	public void setInventario_cant(Integer inventario_cant) {
		this.inventario_cant = inventario_cant;
	}

	public int getCategorias_cate_id() {
		return categorias_cate_id;
	}

	public void setCategorias_cate_id(Integer categorias_cate_id) {
		this.categorias_cate_id = categorias_cate_id;
	}

	public int getPrecio_prod() {
		return precio_prod;
	}

	public void setPrecio_prod(Integer precio_prod) {
		this.precio_prod = precio_prod;
	}

}//Class Product
