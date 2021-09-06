package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.model.Empresa;
import com.dio.live.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	public Empresa SaveJornada(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public List<Empresa> findAll() {
		return empresaRepository.findAll();
	}

	public Optional<Empresa> findByid(long id) {
		return empresaRepository.findById(id);
	}

	public void deleteJornada(long id) {
		empresaRepository.deleteById(id);
	}
}
