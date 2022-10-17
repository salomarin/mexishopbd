package org.mexishop.mexishop.service;

import java.util.List;
import java.util.Optional;

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
	
	public Usuario updateUsuario(Integer id, String contrasena, String newContrasena) {
		Usuario tmpUser = null;
		if(usuarioRepository.existsById(id)) {
			tmpUser = usuarioRepository.findById(id).get();
			if((contrasena!=null) && (newContrasena!=null)){
			    if (contrasena.equals(tmpUser.getContrasena())) {//si el password es correcto
			     tmpUser.setContrasena(newContrasena);
			     usuarioRepository.save(tmpUser);
			    }//if password.equals
			   }//if !=null
			  }//if
			  return tmpUser;
			 }//updateUsuario
	
	public boolean validaUsuario(Usuario usuario) {
		 boolean res = false;
		 Optional<Usuario> userByEmail = usuarioRepository.findByEmail(usuario.getEmail());
		 if (userByEmail.isPresent()) {
			 Usuario u = userByEmail.get();
			 if(u.getContrasena().equals(usuario.getContrasena())) {
				 res = true;
			 }//if password
		 }//if
		 return res;
	 }//validateUsuario
	

}// class UsuarioService
