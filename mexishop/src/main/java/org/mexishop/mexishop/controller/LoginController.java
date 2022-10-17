package org.mexishop.mexishop.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.mexishop.mexishop.jwt.config.JwtFilter;
import org.mexishop.mexishop.model.Token;
import org.mexishop.mexishop.model.Usuario;
import org.mexishop.mexishop.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


	
	@RestController
	@RequestMapping(path="/api/login/")
	public class LoginController{
		private final UsuarioService usuarioService;
		
		@Autowired
		public LoginController(UsuarioService usuarioService) {
			super();
			this.usuarioService = usuarioService;
		}//constructor
		
		@PostMapping
		public Token login (@RequestBody Usuario usuario) throws ServletException {
			if (usuarioService.validaUsuario(usuario)) {
				return new Token(generateToken(usuario.getEmail()));
			}//if
			throw new ServletException("Nombre de usuario o contrasena incorrectos.");
		}//login
		
	

		private String generateToken (String username) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.HOUR, 1);
			return Jwts.builder().setSubject(username).claim("role", "user")
					.setIssuedAt(new Date()).setExpiration(calendar.getTime())
					.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();}// generateToken
		}//Class LoginController
