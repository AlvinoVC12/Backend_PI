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

import com.proyecto.entity.OrdenCompraDetalle;
import com.proyecto.servicesImpl.OrdenCompraDetalleServices;
import com.proyecto.utils.NotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orden-compra-detalle")
public class OrdenCompraDetalleController {
	@Autowired
	private OrdenCompraDetalleServices servicioProv;
	
	@PostMapping("/registrar")
	public ResponseEntity<OrdenCompraDetalle> registrar(@RequestBody OrdenCompraDetalle bean) {
		OrdenCompraDetalle obj = servicioProv.registrar(bean);
		
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<OrdenCompraDetalle> actualizar(@RequestBody OrdenCompraDetalle bean) {
		OrdenCompraDetalle pro = servicioProv.buscarPorID(bean.getCodigo());
		if (pro == null)
			throw new NotFoundException();
		else
			pro = servicioProv.actualizar(bean);
		
		return new ResponseEntity<>(pro, HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") Integer cod) {
		OrdenCompraDetalle pro = servicioProv.buscarPorID(cod);
		if (pro == null)
			throw new NotFoundException();
		else
			servicioProv.eliminarPorID(cod);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<OrdenCompraDetalle>> lista() {
		return new ResponseEntity<>(servicioProv.listarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{cod}")
	public ResponseEntity<OrdenCompraDetalle> buscar(@PathVariable("cod") Integer codi) {
		OrdenCompraDetalle pro = servicioProv.buscarPorID(codi);
		if (pro == null)
			throw new NotFoundException();
		else
			pro = servicioProv.buscarPorID(codi);
		
		return new ResponseEntity<>(pro, HttpStatus.OK);
	}
}
