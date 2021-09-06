package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.repository.CategoriaUsuarioRepository;

@Service
public class CategoriaUsuarioService {
	
	@Autowired
	CategoriaUsuarioRepository categoriaUsuarioRepository;
	
	public CategoriaUsuario SaveJornada(CategoriaUsuario categoriaUsuario) {
		return categoriaUsuarioRepository.save(categoriaUsuario);
	}

	public List<CategoriaUsuario> findAll() {
		return categoriaUsuarioRepository.findAll();
	}

	public Optional<CategoriaUsuario> findByid(long id) {
		return categoriaUsuarioRepository.findById(id);
	}

	public void deleteJornada(long id) {
		categoriaUsuarioRepository.deleteById(id);
	}
}
