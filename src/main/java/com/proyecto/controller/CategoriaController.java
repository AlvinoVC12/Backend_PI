package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Categoria;
import com.proyecto.servicesImpl.CategoriaServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	private CategoriaServices servicioCat;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Categoria>> lista() {
		return new ResponseEntity<>(servicioCat.listarTodos(), HttpStatus.OK);
	}
}