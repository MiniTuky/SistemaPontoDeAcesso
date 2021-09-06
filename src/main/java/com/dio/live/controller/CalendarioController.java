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

import com.dio.live.model.Calendario;
import com.dio.live.service.CalendarioService;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

	@Autowired
	CalendarioService calendarioService;

	@PostMapping
	public Calendario createJornada(@RequestBody Calendario calendario) {
		return calendarioService.SaveJornada(calendario);
	}

	@GetMapping
	public List<Calendario> gerJornadaList() {
		return calendarioService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Calendario> getJornadaById(@PathVariable("id") long id) throws NoSuchElementException {
		return ResponseEntity.ok(calendarioService.findByid(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@PutMapping
	public Calendario updateJornada(@RequestBody Calendario calendario) {
		return calendarioService.SaveJornada(calendario);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity deleteJornada(@PathVariable("id") long id) throws NoSuchElementException {
	       try {
	    	   calendarioService.deleteJornada(id);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	       }
	        return (ResponseEntity<?>) ResponseEntity.ok();
		
	}

}
