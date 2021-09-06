package com.dio.live;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dio.live.model.BancoHoras;
import com.dio.live.model.BancoHorasId;
import com.dio.live.model.Calendario;
import com.dio.live.model.Movimentacao;
import com.dio.live.model.MovimentacaoId;
import com.dio.live.model.Ocorrencia;
import com.dio.live.model.TipoData;
import com.dio.live.repository.BancoHorasRepository;
import com.dio.live.repository.MovimentacaoRepository;

@SpringBootApplication
public class LiveApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiveApplication.class, args);
	}

	@Autowired
	BancoHorasRepository br;

	@Override
	public void run(String... args) throws Exception {

		BancoHorasId id = new BancoHorasId(1L, 1L, 1L); 
		BancoHoras bh = new BancoHoras(id ,LocalDateTime.now(), BigDecimal.ONE,BigDecimal.ONE);

		br.save(bh);
	}

}
