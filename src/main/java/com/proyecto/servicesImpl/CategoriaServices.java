package com.proyecto.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Categoria;
import com.proyecto.repository.CategoriaRepository;

@Service
public class CategoriaServices extends ICRUDImpl<Categoria, Integer> {
	
	@Autowired
	private CategoriaRepository repo;

	@Override
	public JpaRepository<Categoria, Integer> getRepository() {
		return repo;
	}

}