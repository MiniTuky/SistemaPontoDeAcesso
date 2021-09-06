package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movimentacao {
	@EmbeddedId
	private MovimentacaoId id;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private BigDecimal periodo;
	@ManyToOne(cascade = {CascadeType.ALL})
	private Ocorrencia ocorrencia;
	@ManyToOne(cascade = {CascadeType.ALL})
	private Calendario calendario;
}


