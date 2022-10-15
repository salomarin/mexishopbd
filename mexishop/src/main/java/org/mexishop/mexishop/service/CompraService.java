package org.mexishop.mexishop.service;

import java.util.List;

import org.mexishop.mexishop.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CompraService {
	private final CompraRepository compraRepository;
@Autowired
	public CompraService(CompraRepository compraRepository) {
		super();
		this.compraRepository = compraRepository;
	}
	
	public List<Compra> GetCompras () {
		return compraRepository.findAll();
	}
	
	public Compra GetCompra (Integer idcompra) {
		return compraRepository.findById(idcompra).orElseThrow(
				() -> new IllegalArgumentException("La compra con el Id" + idcompra + "No existe.")
				);
	}
	public Compra DeleteCompra (Integer idcompra) {
		Compra tmpCompra = null;
		if (compraRepository.existsById(idcompra)) {
			tmpCompra = compraRepository.findById(idcompra).get();
			compraRepository.deleteById(idcompra);
		}
		return tmpCompra;
	}
	
	public Compra addCompra(Compra compra) {
		return compraRepository.save(compra);
	}
	public Compra updateCompra (Integer idcompra, Integer total_compra, Integer usuarios_user_id) {
		Compra tmpCompra = null;
		if (compraRepository.existsById(idcompra)) {
			tmpCompra = compraRepository.findById(idcompra).get();
			if (total_compra!=null) tmpCompra.setTotal_compra(total_compra);
			if (usuarios_user_id!=null) tmpCompra.setUsuarios_user_id(usuarios_user_id);
			compraRepository.save(tmpCompra);
		} else {
			System.out.println("update - la compra con el id " + idcompra + " no existe.");
		}
		
		return tmpCompra;
		
	}
}
