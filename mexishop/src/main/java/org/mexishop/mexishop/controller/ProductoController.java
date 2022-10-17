package org.mexishop.mexishop.controller;
import java.util.List;
import org.mexishop.mexishop.model.Producto;
import org.mexishop.mexishop.service.ProductoService;
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
@RequestMapping(path="/api/productos/")
public class ProductoController {
	
	private final ProductoService productoService;
	
	@Autowired
	public ProductoController(ProductoService productoService){
		super();
		this.productoService = productoService;
	}//auto wired
	@GetMapping
	public List<Producto> getAllProductos(){
		return productoService.getProductos();
	}//ListProducto
	
	@GetMapping (path="{prodId}")//http://localhost:8080/api/productos/1
	public Producto getProducto(@PathVariable("prodId")Integer product_id){
		return productoService.getProducto(product_id);
	}
	
	@DeleteMapping (path="{prodId}")//http://localhost:8080/api/productos/1
	public Producto deleteProducto(@PathVariable("prodId")Integer product_id){
		return productoService.deleteProducto(product_id);
	}//deleteProducto
	
	@PostMapping 
	public Producto addProducto(@RequestBody Producto producto){
		return productoService.addProducto(producto);
	}
	
	@PutMapping (path="{prodId}")//http://localhost:8080/api/productos/1
	public Producto updateProducto(@PathVariable("prodId")Integer product_id,
		@RequestParam (required=false) String prod_nombr,
		@RequestParam (required=false) String prod_Link,
		@RequestParam (required=false) String prod_desc,
		@RequestParam (required=false) Integer inventario_cant,
		@RequestParam (required=false) Integer categorias_cate_id,
		@RequestParam (required=false) Integer precio_prod){
		return productoService.updateProducto(product_id,prod_nombr,prod_Link,prod_desc, inventario_cant,
				categorias_cate_id,precio_prod);
	}//PutProducto
	

}//ProductoController
