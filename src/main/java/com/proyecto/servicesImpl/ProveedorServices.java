package com.proyecto.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Proveedor;
import com.proyecto.repository.ProveedorRepository;

@Service
public class ProveedorServices extends ICRUDImpl<Proveedor, Integer>{
	@Autowired
	private ProveedorRepository repo;
	
	@Override
	public JpaRepository<Proveedor, Integer> getRepository() {
		return repo;
	}
}
