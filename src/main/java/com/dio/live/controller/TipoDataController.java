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

import com.dio.live.model.TipoData;
import com.dio.live.service.TipoDataService;

@RestController
@RequestMapping("/tipodata")
public class TipoDataController {

	@Autowired
	TipoDataService tipoDataService;

	@PostMapping
	public TipoData createJornada(@RequestBody TipoData tipoData) {
		return tipoDataService.SaveJornada(tipoData);
	}

	@GetMapping
	public List<TipoData> gerJornadaList() {
		return tipoDataService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoData> getJornadaById(@PathVariable("id") long id) throws NoSuchElementException {
		return ResponseEntity.ok(tipoDataService.findByid(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@PutMapping
	public TipoData updateJornada(@RequestBody TipoData tipoData) {
		return tipoDataService.SaveJornada(tipoData);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity deleteJornada(@PathVariable("id") long id) throws NoSuchElementException {
	       try {
	    	   tipoDataService.deleteJornada(id);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	       }
	        return (ResponseEntity<?>) ResponseEntity.ok();
		
	}

}
