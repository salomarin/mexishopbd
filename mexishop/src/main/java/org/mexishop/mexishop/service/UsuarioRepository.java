package org.mexishop.mexishop.service;
import java.util.Optional;
import org.mexishop.mexishop.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{
	@Query("SELECT u FROM Usuario u WHERE u.email=?1")  // JPQL
	Optional<Usuario> findByEmail(String email);

}//InterfaceUsuarioRepository