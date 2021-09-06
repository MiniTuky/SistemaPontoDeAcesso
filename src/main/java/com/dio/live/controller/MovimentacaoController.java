package com.dio.live.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
import com.dio.live.model.Movimentacao;
import com.dio.live.model.MovimentacaoId;
import com.dio.live.model.Ocorrencia;
import com.dio.live.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

	@Autowired
	MovimentacaoService movimentacaoService;

	@PostMapping
	public Movimentacao create(@RequestBody Movimentacao movimentacao) {
		return movimentacaoService.Save(movimentacao);
	}

	@GetMapping
	public List<Movimentacao> gerList() {
		return movimentacaoService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Movimentacao> getJornadaById(@PathVariable("id") MovimentacaoId id) throws NoSuchElementException {
		return ResponseEntity.ok(movimentacaoService.findByid(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@PutMapping
	public Movimentacao updateJornada(@RequestBody Movimentacao movimentacao) {
		return movimentacaoService.Save(movimentacao);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity deleteJornada(@PathVariable("id") MovimentacaoId id) throws NoSuchElementException {
	       try {
	    	   movimentacaoService.delete(id);
	       }catch (Exception e){
	           System.out.println(e.getMessage());
	       }
	        return (ResponseEntity<?>) ResponseEntity.ok();
		
	}

}
