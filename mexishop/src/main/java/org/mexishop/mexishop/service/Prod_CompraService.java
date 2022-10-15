package org.mexishop.mexishop.service;

import java.util.List;

import org.mexishop.mexishop.model.Prod_Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class Prod_CompraService {
		
	

	
		private final Prod_CompraRepository prod_CompraRepository;
	@Autowired

		public Prod_CompraService(Prod_CompraRepository prod_CompraRepository) {
		super();
		this.prod_CompraRepository = prod_CompraRepository;
	}
	
	public List<Prod_Compra> GetProd_Compras () {
		return prod_CompraRepository.findAll();
	}
	

		public Prod_Compra GetProd_Compra (Integer idprod_compra) {
			return prod_CompraRepository.findById(idprod_compra).orElseThrow(
					() -> new IllegalArgumentException("No se encuentra el id " + idprod_compra)
					);
		}
		public Prod_Compra DeleteProd_Compra (Integer idprod_compra) {
			Prod_Compra tmpProd_Compra = null;
			if (prod_CompraRepository.existsById(idprod_compra)) {
				tmpProd_Compra = prod_CompraRepository.findById(idprod_compra).get();
				prod_CompraRepository.deleteById(idprod_compra);
			}
			return tmpProd_Compra;
		}
		
		public Prod_Compra addProd_Compra(Prod_Compra prod_compra) {
			return prod_CompraRepository.save(prod_compra);
		}
		public Prod_Compra updateProd_Compra (Integer idprod_compra, Integer compra_idcompra, Integer compra_usuarios_user_id, 
				Integer producto_product_id, Integer producto_categorias_cate_id) {
			Prod_Compra tmpProd_Compra = null;
			if (prod_CompraRepository.existsById(idprod_compra)) {
				tmpProd_Compra = prod_CompraRepository.findById(idprod_compra).get();
				if (compra_idcompra!=null) tmpProd_Compra.setCompra_idcompra(compra_idcompra);
				if (compra_usuarios_user_id!=null) tmpProd_Compra.setCompra_usuarios_user_id(compra_usuarios_user_id);
				if (producto_product_id!=null) tmpProd_Compra.setProducto_product_id(producto_product_id);
				if (producto_categorias_cate_id!=null) tmpProd_Compra.setProducto_categorias_cate_id(producto_categorias_cate_id);

				prod_CompraRepository.save(tmpProd_Compra);
			} else {
				System.out.println("update - el registro con el id " + idprod_compra );
			}
			
			return tmpProd_Compra;
			
		}
	}
	