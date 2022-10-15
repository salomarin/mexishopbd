package org.mexishop.mexishop.controller;

import java.util.List;

import org.mexishop.mexishop.model.Categoria;
import org.mexishop.mexishop.service.CategoriasService;
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
@RequestMapping(path="/api/categorias/") //URL donde mandaremos llamar nuestra API
public class CategoriasController {
	private final CategoriasService categoriasService;
	
		@Autowired
		public CategoriasController(CategoriasService categoriasService) {
			super();
			this.categoriasService = categoriasService;
		} //constructor
		
		@GetMapping
		public List<Categoria> getAllCategorias() {
			return categoriasService.getCategorias();
		} //getAllProductos

		@GetMapping (path="{catId}") //http://localhost:8080/api/categoria/1
		public Categoria getCategoria(@PathVariable("catId")Integer cate_id) {
			return categoriasService.getCategoria(cate_id);
		} //getProducto
		
		@DeleteMapping (path="{catId}") //http://localhost:8080/api/categoria/1
		public Categoria deleteCategoria(@PathVariable("catId")Integer cate_id) {
			return categoriasService.deleteCategoria(cate_id);
		} //deleteProducto
		
		@PostMapping
		public Categoria addCategoria(@RequestBody Categoria categoria) {
			return categoriasService.addCategoria(categoria);
		}// addProducto
		
		@PutMapping (path="{catId}") //http://localhost:8080/api/categoria/1
		public Categoria updateCategoria(@PathVariable("catId")Integer cate_id,
				@RequestParam (required = false) String nombre_cat) {
			return	categoriasService.updateCategoria(cate_id, nombre_cat);
		} // updateCategorias

} // class Categoria Controller
