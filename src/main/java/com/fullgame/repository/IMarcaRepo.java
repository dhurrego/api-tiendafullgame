package com.fullgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullgame.model.Marca;

public interface IMarcaRepo extends JpaRepository<Marca, Integer>{
	
	
}
