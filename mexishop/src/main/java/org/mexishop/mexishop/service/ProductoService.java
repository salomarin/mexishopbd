package org.mexishop.mexishop.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.mexishop.mexishop.model.Producto;

@Service
public class ProductoService {
	
private final ProductoRepository productoRepository;
    
	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		super();
		this.productoRepository = productoRepository;
	}//constructor
	
	public List<Producto> getProductos(){
		return productoRepository.findAll();
		
	}//getProductos
	
    public Producto getProducto(int product_id){
		return productoRepository.findById(product_id).orElseThrow(
				()->new IllegalArgumentException("El producto con el id" + product_id + "no existe.")
				);	
	}//GetProducto
    
    public Producto deleteProducto(int product_id){
    	Producto tmpProd = null;
    	if (productoRepository.existsById(product_id)){
    		tmpProd = productoRepository.findById(product_id).get();
    		productoRepository.deleteById(product_id);
		}//if exist
		return tmpProd;
	}//deleteProducto
    
    public Producto addProducto(Producto producto) {
    	return productoRepository.save(producto);
    }//addProducto
    
    public Producto updateProducto(Integer product_id, String prod_nombr, String prod_Link, String prod_desc, Integer inventario_cant,
			Integer categorias_cate_id, Integer precio_prod ) {
    	Producto tmpProd = null;
    	if (productoRepository.existsById(product_id)) {
    		tmpProd = productoRepository.findById(product_id).get();
    		if (prod_nombr!=null) tmpProd.setProd_nombr(prod_nombr);	
    		if (prod_Link!=null) tmpProd.setProd_Link(prod_Link);
    		if (prod_desc!=null) tmpProd.setProd_desc(prod_desc);
    		if (inventario_cant!=null) tmpProd.setInventario_cant(inventario_cant.intValue());
    		if (categorias_cate_id!=null) tmpProd.setCategorias_cate_id(categorias_cate_id.intValue());
    		if (precio_prod!=null) tmpProd.setPrecio_prod(precio_prod.intValue());
    		productoRepository.save(tmpProd);
		}else {
		 System.out.println("Update - El producto con el id "+ product_id +"no existe.");
		}//if exist--else
    	return tmpProd;
    	}//updateProducto
    }//ProductoService
