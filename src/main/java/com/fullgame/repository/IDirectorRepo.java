package com.fullgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullgame.model.Director;

public interface IDirectorRepo extends JpaRepository<Director, Integer>{
	
	
}
