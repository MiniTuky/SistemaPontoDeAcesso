package com.dio.live.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.live.model.Calendario;
import com.dio.live.model.Movimentacao;
import com.dio.live.model.MovimentacaoId;
import com.dio.live.model.Ocorrencia;
import com.dio.live.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	MovimentacaoRepository movimentacaoRepository;
	
	public Movimentacao Save(Movimentacao movimentacao) {
		return movimentacaoRepository.save(movimentacao);
	}

	public List<Movimentacao> findAll() {
		return movimentacaoRepository.findAll();
	}

	public Optional<Movimentacao> findByid(MovimentacaoId id) {
		return movimentacaoRepository.findById(id);
	}

	public void delete(MovimentacaoId id) {
		movimentacaoRepository.deleteById(id);
	}
}
