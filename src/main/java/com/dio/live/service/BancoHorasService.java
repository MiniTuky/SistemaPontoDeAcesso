package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.model.BancoHoras;
import com.dio.live.model.BancoHorasId;
import com.dio.live.repository.BancoHorasRepository;

@Service
public class BancoHorasService {
	
	@Autowired
	BancoHorasRepository bancoHorasRepository;
	
	public BancoHoras SaveJornada(BancoHoras bancoHoras) {
		return bancoHorasRepository.save(bancoHoras);
	}

	public List<BancoHoras> findAll() {
		return bancoHorasRepository.findAll();
	}

	public Optional<BancoHoras> findByid(BancoHorasId id) {
		return bancoHorasRepository.findById(id);
	}

	public void deleteJornada(BancoHorasId id) {
		bancoHorasRepository.deleteById(id);
	}
}
