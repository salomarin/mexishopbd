package org.mexishop.mexishop.service;

import java.util.List;

import org.mexishop.mexishop.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}//constructor
	
	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}//getUsuarios
	
	public Usuario getUsuario(Integer id){
		return usuarioRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El Usuario con el id " + id + " no existe.")
				);
	}//getUsuario
	
	public Usuario deleteUsuario(Integer id) {
		Usuario tmpUser=null;
		if(usuarioRepository.existsById(id)) {
			tmpUser = usuarioRepository.findById(id).get();
			usuarioRepository.deleteById(id);
		}//if exist
		return tmpUser;
	}//deleteProducto
	
	public Usuario addUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}//addProducto
	
	public Usuario updateUsuario(Integer id, String nombre, String tel, 
			String email, String contrasena) {
		Usuario tmpUser = null;
		if(usuarioRepository.existsById(id)) {
			tmpUser = usuarioRepository.findById(id).get();
			if(nombre!=null) tmpUser.setNombre(nombre);
			if(tel!=null) tmpUser.setTel(tel);
			if(email!=null) tmpUser.setEmail(email);
			if(contrasena!=null) tmpUser.setContrasena(contrasena);
			usuarioRepository.save(tmpUser);
		}else {
			System.out.println("Update - El usuario con el id " + id + " no existe");
		}//if exist
		return tmpUser;
	}//updateProducto
	

}// class UsuarioService
