package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.model.NivelAcesso;
import com.dio.live.repository.NivelAcessoRepository;

@Service
public class NivelAcessoService {
	
	@Autowired
	NivelAcessoRepository nivelAcessoRepository;
	
	public NivelAcesso SaveJornada(NivelAcesso nivelAcesso) {
		return nivelAcessoRepository.save(nivelAcesso);
	}

	public List<NivelAcesso> findAll() {
		return nivelAcessoRepository.findAll();
	}

	public Optional<NivelAcesso> findByid(long id) {
		return nivelAcessoRepository.findById(id);
	}

	public void deleteJornada(long id) {
		nivelAcessoRepository.deleteById(id);
	}
}
