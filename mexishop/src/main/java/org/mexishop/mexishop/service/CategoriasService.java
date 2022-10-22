package org.mexishop.mexishop.service;

import java.util.List;

import org.mexishop.mexishop.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriasService {
	private final CategoriasRepository categoriasRepository;

	@Autowired
	public CategoriasService(CategoriasRepository categoriasRepository) {
		super();
		this.categoriasRepository = categoriasRepository;
	} //constructor
	
	public List<Categoria> getCategorias (){
		return categoriasRepository.findAll();
	} // getCategoria
	
	public Categoria getCategoria(Integer cate_id){
		return categoriasRepository.findById(cate_id).orElseThrow(
				() ->new IllegalArgumentException("La categoría con el id" + cate_id + "no existe.")
				);
	} // getCategoria
	
	public Categoria deleteCategoria(Integer cate_id) {
		Categoria tmpCat = null;
		if (categoriasRepository.existsById(cate_id)) {
			tmpCat = categoriasRepository.findById(cate_id).get();
			categoriasRepository.deleteById(cate_id);
		} // if exist
		return tmpCat;
	} //deleteCategoria
	
	public Categoria addCategoria(Categoria categoria) {
		return categoriasRepository.save(categoria);
	} //addCategoria
	
	public Categoria updateCategoria(Integer cate_id, String nombre_cat) {
		Categoria tmpCat = null;
		if (categoriasRepository.existsById(cate_id)) {
			tmpCat = categoriasRepository.findById(cate_id).get();
			if(nombre_cat!=null) tmpCat.setNombre_cat(nombre_cat);
			categoriasRepository.save(tmpCat);
		} else {
			System.out.println("Update - La categoría con el id " + cate_id + "no existe.");
		} //if else
		return tmpCat;
	} // updateCategoria	
	
} //class CategoriasService