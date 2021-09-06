package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.model.Localidade;
import com.dio.live.repository.LocalidadeRepository;

@Service
public class LocalidadeService {
	
	@Autowired
	LocalidadeRepository localidadeRepository;
	
	public Localidade SaveJornada(Localidade localidade) {
		return localidadeRepository.save(localidade);
	}

	public List<Localidade> findAll() {
		return localidadeRepository.findAll();
	}

	public Optional<Localidade> findByid(long id) {
		return localidadeRepository.findById(id);
	}

	public void deleteJornada(long id) {
		localidadeRepository.deleteById(id);
	}
}
