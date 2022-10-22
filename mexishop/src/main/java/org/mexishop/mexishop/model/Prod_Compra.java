package org.mexishop.mexishop.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prod_compra")

public class Prod_Compra {

		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="idprod_compra", unique=true, nullable=false)

		private Integer idprod_compra;
		private Integer compra_idcompra;
		private Integer compra_usuarios_user_id;
		private Integer producto_product_id;
		private Integer producto_categorias_cate_id;
		
		
		public Prod_Compra(Integer compra_idcompra, Integer compra_usuarios_user_id, Integer producto_product_id,
				Integer producto_categorias_cate_id) {
			super();
			this.compra_idcompra = compra_idcompra;
			this.compra_usuarios_user_id = compra_usuarios_user_id;
			this.producto_product_id = producto_product_id;
			this.producto_categorias_cate_id = producto_categorias_cate_id;
		}
		
		
		//GET
		public Prod_Compra() {
		}


		public Integer getCompra_idcompra() {
			return compra_idcompra;
		}


		public void setCompra_idcompra(Integer compra_idcompra) {
			this.compra_idcompra = compra_idcompra;
		}


		public Integer getCompra_usuarios_user_id() {
			return compra_usuarios_user_id;
		}


		public void setCompra_usuarios_user_id(Integer compra_usuarios_user_id) {
			this.compra_usuarios_user_id = compra_usuarios_user_id;
		}


		public Integer getProducto_product_id() {
			return producto_product_id;
		}


		public void setProducto_product_id(Integer producto_product_id) {
			this.producto_product_id = producto_product_id;
		}


		public Integer getProducto_categorias_cate_id() {
			return producto_categorias_cate_id;
		}


		public void setProducto_categorias_cate_id(Integer producto_categorias_cate_id) {
			this.producto_categorias_cate_id = producto_categorias_cate_id;
		}


		public Integer getIdprod_compra() {
			return idprod_compra;
		}


		@Override
		public String toString() {
			return "Prod_Compra [idprod_compra=" + idprod_compra + ", compra_idcompra=" + compra_idcompra
					+ ", compra_usuarios_user_id=" + compra_usuarios_user_id + ", producto_product_id="
					+ producto_product_id + ", producto_categorias_cate_id=" + producto_categorias_cate_id + "]";
		}
		
		

	}//class Prod_Compra
	


