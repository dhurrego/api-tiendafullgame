package com.fullgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullgame.model.Marca;

@Repository
public interface IMarcaRepo extends JpaRepository<Marca, Integer>{
	
	
}
