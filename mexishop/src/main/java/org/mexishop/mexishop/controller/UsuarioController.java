package org.mexishop.mexishop.controller;

import java.util.List;


import org.mexishop.mexishop.model.Usuario;
import org.mexishop.mexishop.service.UsuarioService;
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
@RequestMapping(path="/api/user/")
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}//constructor
	
	
	@GetMapping
	public List<Usuario> getAllUsuarios(){
		return usuarioService.getUsuarios();
	}//getAllUsuarios
	
	@GetMapping(path="{userId}") // http://localhost:8080/api/user/
	public Usuario getProducto(@PathVariable("userId") Integer id ){
		return usuarioService.getUsuario(id);
	}//getUsuario
	
	@DeleteMapping(path="{userId}") 
	public Usuario deleteUsuario(@PathVariable("userId") Integer id ){
		return usuarioService.deleteUsuario(id);
	}//deleteUsuario
	
	@PostMapping
	public Usuario addProducto(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}//addProducto
	
	@PutMapping(path="{userId}") 
	public Usuario updateProducto(@PathVariable("userId") Integer id,
			@RequestParam (required = false) String nombre,
			@RequestParam (required = false) String tel,
			@RequestParam (required = false) String email,
			@RequestParam (required = false) String contrasena) {
		return usuarioService.updateUsuario(id, nombre, tel, email,contrasena);
	}//updateProducto
	
	
	
	
}//class UsuarioController
