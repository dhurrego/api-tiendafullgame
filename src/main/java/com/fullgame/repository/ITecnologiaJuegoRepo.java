package com.fullgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fullgame.model.TecnologiaJuego;

@Repository
public interface ITecnologiaJuegoRepo extends JpaRepository<TecnologiaJuego, Integer>{
	
	@Query(value = "select * from jue_tecnologia_juegos t where t.ide_juego = ?1", nativeQuery = true)
	public List<TecnologiaJuego> findByIdeJuego(Integer ideJuego);
	
}
