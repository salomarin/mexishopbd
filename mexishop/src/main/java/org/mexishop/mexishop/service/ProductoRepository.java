package org.mexishop.mexishop.service;
import org.mexishop.mexishop.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository <Producto, Integer> {

}
