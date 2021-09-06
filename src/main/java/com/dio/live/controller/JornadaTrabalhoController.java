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

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaTrabalhoService;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

	@Autowired
	JornadaTrabalhoService jornadaTrabalhoService;

	@PostMapping
	public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return jornadaTrabalhoService.SaveJornada(jornadaTrabalho);
	}

	@GetMapping
	public List<JornadaTrabalho> gerJornadaList() {
		return jornadaTrabalhoService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable("id") long id) throws NoSuchElementException {
		return ResponseEntity.ok(jornadaTrabalhoService.findByid(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@PutMapping
	public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
		return jornadaTrabalhoService.SaveJornada(jornadaTrabalho);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity deleteJornada(@PathVariable("id") long id) throws NoSuchElementException {
	       try {
	    	   jornadaTrabalhoService.deleteJornada(id);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	       }
	        return (ResponseEntity<?>) ResponseEntity.ok();
		
	}

}
