package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.model.Ocorrencia;
import com.dio.live.repository.OcorrenciaRepository;

@Service
public class OcorrenciaService {
	
	@Autowired
	OcorrenciaRepository ocorrenciaRepository;
	
	public Ocorrencia SaveJornada(Ocorrencia ocorrencia) {
		return ocorrenciaRepository.save(ocorrencia);
	}

	public List<Ocorrencia> findAll() {
		return ocorrenciaRepository.findAll();
	}

	public Optional<Ocorrencia> findByid(long id) {
		return ocorrenciaRepository.findById(id);
	}

	public void deleteJornada(long id) {
		ocorrenciaRepository.deleteById(id);
	}
}
