package com.fullgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullgame.model.Tecnologia;

@Repository
public interface ITecnologiaRepo extends JpaRepository<Tecnologia, Integer>{
	
	
}
