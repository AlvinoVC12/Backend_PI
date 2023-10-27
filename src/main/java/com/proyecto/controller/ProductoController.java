package com.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Producto;
import com.proyecto.servicesImpl.ProductoServices;
import com.proyecto.utils.NotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoServices servicioPro;
	
	@PostMapping("/registrar")
	public ResponseEntity<Producto> registrar(@RequestBody Producto bean) {
		Producto obj = servicioPro.registrar(bean);
		
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Producto> actualizar(@RequestBody Producto bean) {
		Producto pro = servicioPro.buscarPorID(bean.getCodigo());
		if (pro == null)
			throw new NotFoundException();
		else
			pro = servicioPro.actualizar(bean);
		
		return new ResponseEntity<>(pro, HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") Integer cod) {
		Producto pro = servicioPro.buscarPorID(cod);
		if (pro == null)
			throw new NotFoundException();
		else
			servicioPro.eliminarPorID(cod);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<Producto>> lista() {
		return new ResponseEntity<>(servicioPro.listarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{cod}")
	public ResponseEntity<Producto> buscar(@PathVariable("cod") Integer codi) {
		Producto pro = servicioPro.buscarPorID(codi);
		if (pro == null)
			throw new NotFoundException();
		else
			pro = servicioPro.buscarPorID(codi);
		
		return new ResponseEntity<>(pro, HttpStatus.OK);
	}
}