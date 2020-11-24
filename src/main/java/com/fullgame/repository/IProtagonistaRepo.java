package com.fullgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullgame.model.Protagonista;

@Repository
public interface IProtagonistaRepo extends JpaRepository<Protagonista, Integer>{
	
	
}
