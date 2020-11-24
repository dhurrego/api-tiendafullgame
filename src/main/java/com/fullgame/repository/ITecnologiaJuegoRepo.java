package com.fullgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullgame.model.TecnologiaJuego;

@Repository
public interface ITecnologiaJuegoRepo extends JpaRepository<TecnologiaJuego, Integer>{
	
	
}
