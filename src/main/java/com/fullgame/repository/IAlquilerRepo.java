package com.fullgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fullgame.model.Alquiler;

@Repository
public interface IAlquilerRepo extends JpaRepository<Alquiler, String>{
	
	
	
	@Query(value = "SELECT ide_juego FROM jue_alquileres\r\n"
			+ "	GROUP BY ide_juego\r\n"
			+ "	ORDER BY count(ide_juego) DESC", nativeQuery = true)
	public List<Integer> countJuegoAlquilado();
	
	@Query(value = "SELECT * FROM jue_alquileres\r\n"
			+ "WHERE fecha_inicio = ?1", nativeQuery = true)
	public List<Alquiler> findByFechaInicio(String fechaInicio);
	
	@Query(value = "SELECT ide_cliente FROM jue_alquileres\r\n"
			+ "			GROUP BY ide_cliente \r\n"
			+ "			ORDER BY count(ide_cliente) DESC", nativeQuery = true)
	public List<String> countClienteFrecuente();
	
	@Query(value = "SELECT * FROM jue_alquileres\r\n"
			+ "WHERE ide_cliente = ?1", nativeQuery = true)
	public List<Alquiler> findByIdeCliente(String ideCliente);
	
}
