package com.proyecto.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto.entity.OrdenCompra;
import com.proyecto.repository.OrdenCompraRepository;

@Service
public class OrdenCompraServices extends ICRUDImpl<OrdenCompra, Integer>{
	@Autowired
	private OrdenCompraRepository repo;
	
	@Override
	public JpaRepository<OrdenCompra, Integer> getRepository() {
		return repo;
	}
}
