package org.mexishop.mexishop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.mexishop.mexishop.jwt.config.JwtFilter;

@SpringBootApplication 
public class MexishopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MexishopApplication.class, args);
	} //main
	
	@Bean
	public FilterRegistrationBean<JwtFilter>JwtFilter(){
	      FilterRegistrationBean<JwtFilter>registrationBean= new FilterRegistrationBean<>();
	      registrationBean.setFilter(new JwtFilter());
	      registrationBean.addUrlPatterns("/api/productos/*");
	      registrationBean.addUrlPatterns("/api/user/*");
	      registrationBean.addUrlPatterns("/api/compra/*");
	      registrationBean.addUrlPatterns("/api/prod_compra/*");
	      return registrationBean;
		} //JwtFilter
}  //clasAPI
