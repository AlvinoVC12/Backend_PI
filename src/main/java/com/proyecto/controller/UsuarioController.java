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

import com.proyecto.entity.Usuario;
import com.proyecto.servicesImpl.UsuarioServices;
import com.proyecto.utils.NotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioServices servicioUsu;

	@PostMapping("/registrar")
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario bean) {
		Usuario obj = servicioUsu.registrar(bean);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<Usuario> actualizar(@RequestBody Usuario bean) {
		Usuario usu = servicioUsu.buscarPorID(bean.getCodigo());
		if (usu == null)
			throw new NotFoundException();
		else
			usu = servicioUsu.actualizar(bean);

		return new ResponseEntity<>(usu, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") Integer cod) {
		Usuario usu = servicioUsu.buscarPorID(cod);
		if (usu == null)
			throw new NotFoundException();
		else
			servicioUsu.eliminarPorID(cod);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/lista")
	public ResponseEntity<List<Usuario>> lista() {
		return new ResponseEntity<>(servicioUsu.listarTodos(), HttpStatus.OK);
	}

	@GetMapping("/buscar/{cod}")
	public ResponseEntity<Usuario> buscar(@PathVariable("cod") Integer codi) {
		Usuario usu = servicioUsu.buscarPorID(codi);
		if (usu == null)
			throw new NotFoundException();
		else
			usu = servicioUsu.buscarPorID(codi);

		return new ResponseEntity<>(usu, HttpStatus.OK);
	}
}
