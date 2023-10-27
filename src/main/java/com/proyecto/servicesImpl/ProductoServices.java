package com.proyecto.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Producto;
import com.proyecto.repository.ProductoRepository;

@Service
public class ProductoServices extends ICRUDImpl<Producto, Integer> {
	
	@Autowired
	private ProductoRepository repo;
	
	@Override
	public JpaRepository<Producto, Integer> getRepository() {
		return repo;
	}
	
}