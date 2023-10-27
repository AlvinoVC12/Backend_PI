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

import com.proyecto.entity.Proveedor;
import com.proyecto.servicesImpl.ProveedorServices;
import com.proyecto.utils.NotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
	@Autowired
	private ProveedorServices servicioProv;
	
	@PostMapping("/registrar")
	public ResponseEntity<Proveedor> registrar(@RequestBody Proveedor bean) {
		Proveedor obj = servicioProv.registrar(bean);
		
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Proveedor> actualizar(@RequestBody Proveedor bean) {
		Proveedor pro = servicioProv.buscarPorID(bean.getCodigo());
		if (pro == null)
			throw new NotFoundException();
		else
			pro = servicioProv.actualizar(bean);
		
		return new ResponseEntity<>(pro, HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") Integer cod) {
		Proveedor pro = servicioProv.buscarPorID(cod);
		if (pro == null)
			throw new NotFoundException();
		else
			servicioProv.eliminarPorID(cod);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<Proveedor>> lista() {
		return new ResponseEntity<>(servicioProv.listarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{cod}")
	public ResponseEntity<Proveedor> buscar(@PathVariable("cod") Integer codi) {
		Proveedor pro = servicioProv.buscarPorID(codi);
		if (pro == null)
			throw new NotFoundException();
		else
			pro = servicioProv.buscarPorID(codi);
		
		return new ResponseEntity<>(pro, HttpStatus.OK);
	}
}
