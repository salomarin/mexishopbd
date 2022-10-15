package org.mexishop.mexishop.controller;

import java.util.List;

import org.mexishop.mexishop.model.Prod_Compra;
import org.mexishop.mexishop.service.Prod_CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/prod_compra/")

public class Prod_CompraController {

	
		private final Prod_CompraService prod_compraservice;

		@Autowired
		public Prod_CompraController(Prod_CompraService prod_compraservice) {
			super();
			this.prod_compraservice = prod_compraservice;
		}
		
		@GetMapping
		public List<Prod_Compra> getAllProd_Compras(){
			return prod_compraservice.GetProd_Compras();
		}
		
		@GetMapping(path = "{idProdCompra}")
		public Prod_Compra getProd_Compra(@PathVariable("idProdCompra")Integer idprod_compra) {
			return prod_compraservice.GetProd_Compra(idprod_compra);
		}
		
		@DeleteMapping(path = "{idProdCompra}")
		public Prod_Compra deleteProd_Compra(@PathVariable("idProdCompra")Integer idprod_compra) {
			return prod_compraservice.DeleteProd_Compra(idprod_compra);
		}
		
		@PostMapping
		public Prod_Compra addProd_Compra(@RequestBody Prod_Compra prod_Compra){
			return prod_compraservice.addProd_Compra(prod_Compra);
		}
		
		@PutMapping (path = "{idProdCompra}")
		public Prod_Compra updateProd_Compra(@PathVariable ("idProdCompra") Integer idprod_compra,
				@RequestParam (required = false) Integer compra_idcompra, 
				@RequestParam (required = false) Integer compra_usuarios_user_id,
				@RequestParam (required = false) Integer producto_product_id,
				@RequestParam (required = false) Integer producto_categorias_cate_id) 
		
		{
			return prod_compraservice.updateProd_Compra(idprod_compra, compra_idcompra, compra_usuarios_user_id, producto_product_id, producto_categorias_cate_id);
			
		}
	}
	


