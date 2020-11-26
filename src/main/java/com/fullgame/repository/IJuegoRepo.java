package com.fullgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fullgame.model.Juego;

@Repository
public interface IJuegoRepo extends JpaRepository<Juego, Integer>{
	
	@Query(value = "select * from jue_juegos j where j.ide_protagonista = ?1", nativeQuery = true)
	public List<Juego> findByIdeProtagonista(Integer ideProtagonista);
	
	@Query(value = "select * from jue_juegos j where j.ide_director = ?1", nativeQuery = true)
	public List<Juego> findByIdeDirector(Integer ideDirector);
	
	@Query(value = "select * from jue_juegos j where j.ide_marca = ?1", nativeQuery = true)
	public List<Juego> findByIdeMarca(Integer ideMarca);
	
}
