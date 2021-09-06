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

import com.dio.live.model.NivelAcesso;
import com.dio.live.service.NivelAcessoService;

@RestController
@RequestMapping("/nivelacesso")
public class NivelAcessoController {

	@Autowired
	NivelAcessoService nivelAcessoService;

	@PostMapping
	public NivelAcesso createJornada(@RequestBody NivelAcesso nivelAcesso) {
		return nivelAcessoService.SaveJornada(nivelAcesso);
	}

	@GetMapping
	public List<NivelAcesso> gerJornadaList() {
		return nivelAcessoService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<NivelAcesso> getJornadaById(@PathVariable("id") long id) throws NoSuchElementException {
		return ResponseEntity.ok(nivelAcessoService.findByid(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@PutMapping
	public NivelAcesso updateJornada(@RequestBody NivelAcesso nivelAcesso) {
		return nivelAcessoService.SaveJornada(nivelAcesso);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity deleteJornada(@PathVariable("id") long id) throws NoSuchElementException {
	       try {
	    	   nivelAcessoService.deleteJornada(id);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	       }
	        return (ResponseEntity<?>) ResponseEntity.ok();
		
	}

}
