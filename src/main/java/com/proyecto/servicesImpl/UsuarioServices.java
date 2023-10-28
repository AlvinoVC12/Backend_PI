package com.proyecto.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Usuario;
import com.proyecto.repository.UsuarioRepository;

@Service
public class UsuarioServices extends ICRUDImpl<Usuario, Integer>{
	
	@Autowired 
	private UsuarioRepository repo;
	
	@Override
	public JpaRepository<Usuario, Integer> getRepository(){
		return repo;
	}
	 
	

}
