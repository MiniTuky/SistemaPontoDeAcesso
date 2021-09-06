package com.dio.live.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.live.model.Empresa;
import com.dio.live.model.JornadaTrabalho;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
