package com.fullgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullgame.model.Juego;

@Repository
public interface IJuegoRepo extends JpaRepository<Juego, Integer>{
	
	
}
