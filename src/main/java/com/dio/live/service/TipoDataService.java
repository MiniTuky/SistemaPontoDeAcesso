package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.model.TipoData;
import com.dio.live.repository.TipoDataRepository;

@Service
public class TipoDataService {
	
	@Autowired
	TipoDataRepository tipoDataRepository;
	
	public TipoData SaveJornada(TipoData tipoData) {
		return tipoDataRepository.save(tipoData);
	}

	public List<TipoData> findAll() {
		return tipoDataRepository.findAll();
	}

	public Optional<TipoData> findByid(long id) {
		return tipoDataRepository.findById(id);
	}

	public void deleteJornada(long id) {
		tipoDataRepository.deleteById(id);
	}
}
