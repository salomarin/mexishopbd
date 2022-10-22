package org.mexishop.mexishop.controller;

import java.util.List;

import org.mexishop.mexishop.model.Compra;
import org.mexishop.mexishop.service.CompraService;
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
@RequestMapping(path = "/api/compra/")
public class CompraController {
	private final CompraService compraService;

	@Autowired
	public CompraController(CompraService compraService) {
		super();
		this.compraService = compraService;
	}
	
	@GetMapping
	public List<Compra> getAllCompras(){
		return compraService.GetCompras();
	}
	
	@GetMapping(path = "{ideCompra}")
	public Compra getCompra(@PathVariable("ideCompra")Integer idCompra) {
		return compraService.GetCompra(idCompra);
	}
	
	@DeleteMapping(path = "{ideCompra}")
	public Compra deleteCompra(@PathVariable("ideCompra")Integer idcompra) {
		return compraService.DeleteCompra(idcompra);
	}
	
	@PostMapping
	public Compra addCompra(@RequestBody Compra compra){
		return compraService.addCompra(compra);
	}
	
	@PutMapping (path = "{ideCompra}")
	public Compra updateCompra(@PathVariable ("ideCompra") Integer idcompra,
			@RequestParam (required = false) Integer total_compra, 
			@RequestParam (required = false) Integer usuarios_user_id) {
		return compraService.updateCompra(idcompra, total_compra, usuarios_user_id);
		
	}
	
}
