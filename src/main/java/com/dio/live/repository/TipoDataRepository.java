package com.dio.live.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.model.TipoData;

@Repository
public interface TipoDataRepository extends JpaRepository<TipoData, Long> {

}
