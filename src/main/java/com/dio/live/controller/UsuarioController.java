package com.dio.live.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dio.live.model.Usuario;
import com.dio.live.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping
	public Usuario createJornada(@RequestBody Usuario usuario) {
		return usuarioService.SaveJornada(usuario);
	}

	@GetMapping
	public List<Usuario> gerJornadaList() {
		return usuarioService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getJornadaById(@PathVariable("id") long id) throws NoSuchElementException {
		return ResponseEntity.ok(usuarioService.findByid(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@PutMapping
	public Usuario updateJornada(@RequestBody Usuario usuario) {
		return usuarioService.SaveJornada(usuario);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity deleteJornada(@PathVariable("id") long id) throws NoSuchElementException {
	       try {
	    	   usuarioService.deleteJornada(id);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	       }
	        return (ResponseEntity<?>) ResponseEntity.ok();
		
	}

}
