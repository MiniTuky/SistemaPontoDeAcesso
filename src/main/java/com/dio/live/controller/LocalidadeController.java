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

import com.dio.live.model.Localidade;
import com.dio.live.service.LocalidadeService;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

	@Autowired
	LocalidadeService localidadeService;

	@PostMapping
	public Localidade createJornada(@RequestBody Localidade localidade) {
		return localidadeService.SaveJornada(localidade);
	}

	@GetMapping
	public List<Localidade> gerJornadaList() {
		return localidadeService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Localidade> getJornadaById(@PathVariable("id") long id) throws NoSuchElementException {
		return ResponseEntity.ok(localidadeService.findByid(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@PutMapping
	public Localidade updateJornada(@RequestBody Localidade localidade) {
		return localidadeService.SaveJornada(localidade);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity deleteJornada(@PathVariable("id") long id) throws NoSuchElementException {
	       try {
	    	   localidadeService.deleteJornada(id);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	       }
	        return (ResponseEntity<?>) ResponseEntity.ok();
		
	}

}
