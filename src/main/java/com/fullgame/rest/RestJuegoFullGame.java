package com.fullgame.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fullgame.model.Juego;
import com.fullgame.service.IJuegoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/juegos")
public class RestJuegoFullGame {
	
	Logger LOG = LoggerFactory.getLogger(RestJuegoFullGame.class);
	
	@Autowired
	private IJuegoService repoJuego;
	
	@GetMapping
	public ResponseEntity<List<Juego>> getJuegos() throws Exception{
		LOG.info("Consultando Juegos");
		List<Juego> juegos = repoJuego.getJuegos();
		return ResponseEntity.ok(juegos);
	}
	
	@RequestMapping(value="{ideJuego}", method = RequestMethod.GET)
	public ResponseEntity<Juego> getJuego(@PathVariable("ideJuego") Integer ideJuego) throws Exception{
		LOG.info("Consultando una juego");
		Juego juego = repoJuego.getJuego(ideJuego);
		if(juego != null) {
			return ResponseEntity.ok(juego);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@RequestMapping(value="/protagonista/{ideProtagonista}", method = RequestMethod.GET)
	public ResponseEntity<List<Juego>> getJuegoByProtagonista(@PathVariable("ideProtagonista") Integer ideProtagonista) throws Exception{
		LOG.info("Consultando juegos por protagonista");
		List<Juego> juego = repoJuego.getJuegoByProtagonista(ideProtagonista);
		if(juego != null) {
			return ResponseEntity.ok(juego);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@RequestMapping(value="/director/{ideDirector}", method = RequestMethod.GET)
	public ResponseEntity<List<Juego>> getJuegoByDirector(@PathVariable("ideDirector") Integer ideDirector) throws Exception{
		LOG.info("Consultando juegos por director");
		List<Juego> juego = repoJuego.getJuegoByDirector(ideDirector);
		if(juego != null) {
			return ResponseEntity.ok(juego);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@RequestMapping(value="/marca/{ideMarca}", method = RequestMethod.GET)
	public ResponseEntity<List<Juego>> getJuegoByMarca(@PathVariable("ideMarca") Integer ideMarca) throws Exception{
		LOG.info("Consultando juegos por marca");
		List<Juego> juego = repoJuego.getJuegoByMarca(ideMarca);
		if(juego != null) {
			return ResponseEntity.ok(juego);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
		
	@PostMapping
	public ResponseEntity<Juego> createJuego(@RequestBody Juego juego) throws Exception{
		LOG.info("Creando Juego");
		Juego newJuego = repoJuego.createJuego(juego);
		if(newJuego != null) {
			return ResponseEntity.ok(newJuego);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Juego> updateJuego(@RequestBody Juego juego) throws Exception{
		LOG.info("Actualizando Juego");
		Juego updateJuego = repoJuego.updateJuego(juego);
		if(updateJuego != null) {
			return ResponseEntity.ok(updateJuego);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteJuego(@PathVariable("id") Integer ideJuego) throws Exception{ //Metodo DELETE para eliminar un product
		LOG.info("Eliminando Juego");
		boolean deleteJuego = repoJuego.deleteJuego(ideJuego);
		if(deleteJuego) {
			return ResponseEntity.ok(null);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
