package com.fullgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullgame.model.Director;

@Repository
public interface IDirectorRepo extends JpaRepository<Director, Integer>{
	
	
}
