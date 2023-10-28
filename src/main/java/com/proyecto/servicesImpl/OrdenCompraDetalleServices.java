package com.proyecto.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto.entity.OrdenCompraDetalle;
import com.proyecto.repository.OrdenCompraDetalleRepository;

@Service
public class OrdenCompraDetalleServices extends ICRUDImpl<OrdenCompraDetalle, Integer>{
	@Autowired
	private OrdenCompraDetalleRepository repo;
	
	@Override
	public JpaRepository<OrdenCompraDetalle, Integer> getRepository() {
		return repo;
	}
}
