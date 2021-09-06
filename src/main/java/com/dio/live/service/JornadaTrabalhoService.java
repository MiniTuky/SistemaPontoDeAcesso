package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaTrabalhoRepository;

@Service
public class JornadaTrabalhoService {
	
	@Autowired
	JornadaTrabalhoRepository jornadaTrabalhoRepository;
	
	public JornadaTrabalho SaveJornada(JornadaTrabalho jornadaTrabalho) {
		return jornadaTrabalhoRepository.save(jornadaTrabalho);
	}

	public List<JornadaTrabalho> findAll() {
		return jornadaTrabalhoRepository.findAll();
	}

	public Optional<JornadaTrabalho> findByid(long id) {
		return jornadaTrabalhoRepository.findById(id);
	}

	public void deleteJornada(long id) {
		jornadaTrabalhoRepository.deleteById(id);
	}
}
