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

import com.dio.live.model.BancoHoras;
import com.dio.live.model.BancoHorasId;
import com.dio.live.service.BancoHorasService;

@RestController
@RequestMapping("/banco")
public class BancoHorasController {

	@Autowired
	BancoHorasService bancoHorasService;

	@PostMapping
	public BancoHoras createJornada(@RequestBody BancoHoras bancoHoras) {
		return bancoHorasService.SaveJornada(bancoHoras);
	}

	@GetMapping
	public List<BancoHoras> gerJornadaList() {
		return bancoHorasService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<BancoHoras> getJornadaById(@PathVariable("id") BancoHorasId id) throws NoSuchElementException {
		return ResponseEntity.ok(bancoHorasService.findByid(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@PutMapping
	public BancoHoras updateJornada(@RequestBody BancoHoras bancoHoras) {
		return bancoHorasService.SaveJornada(bancoHoras);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity deleteJornada(@PathVariable("id") BancoHorasId id) throws NoSuchElementException {
	       try {
	    	   bancoHorasService.deleteJornada(id);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	       }
	        return (ResponseEntity<?>) ResponseEntity.ok();
		
	}

}
