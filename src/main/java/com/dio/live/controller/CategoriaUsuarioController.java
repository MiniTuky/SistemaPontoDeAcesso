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

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.service.CategoriaUsuarioService;

@RestController
@RequestMapping("/categoria")
public class CategoriaUsuarioController {

	@Autowired
	CategoriaUsuarioService categoriaUsuarioService;

	@PostMapping
	public CategoriaUsuario createJornada(@RequestBody CategoriaUsuario categoriaUsuario) {
		return categoriaUsuarioService.SaveJornada(categoriaUsuario);
	}

	@GetMapping
	public List<CategoriaUsuario> gerJornadaList() {
		return categoriaUsuarioService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaUsuario> getJornadaById(@PathVariable("id") long id) throws NoSuchElementException {
		return ResponseEntity.ok(categoriaUsuarioService.findByid(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@PutMapping
	public CategoriaUsuario updateJornada(@RequestBody CategoriaUsuario categoriaUsuario) {
		return categoriaUsuarioService.SaveJornada(categoriaUsuario);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity deleteJornada(@PathVariable("id") long id) throws NoSuchElementException {
	       try {
	    	   categoriaUsuarioService.deleteJornada(id);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	       }
	        return (ResponseEntity<?>) ResponseEntity.ok();
		
	}

}
