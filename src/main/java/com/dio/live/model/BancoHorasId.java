package com.dio.live.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class BancoHorasId implements Serializable{
	private static final long serialVersionUID = 1L;
	private long idBancoHoras;
	private long idUsuario;
	private long idMovimentacao;
}
