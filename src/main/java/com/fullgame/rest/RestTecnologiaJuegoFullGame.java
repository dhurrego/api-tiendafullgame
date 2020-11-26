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

import com.fullgame.model.TecnologiaJuego;
import com.fullgame.service.ITecnologiaJuegoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tecnologia-juegos")
public class RestTecnologiaJuegoFullGame {
	
	Logger LOG = LoggerFactory.getLogger(RestTecnologiaJuegoFullGame.class);
	
	@Autowired
	private ITecnologiaJuegoService repoTecnologiaJuego;
	
	@GetMapping
	public ResponseEntity<List<TecnologiaJuego>> getTecnologiaJuegos() throws Exception{
		LOG.info("Consultando Tecnologia Juego");
		List<TecnologiaJuego> tecnologiaJuegos = repoTecnologiaJuego.getTecnologiaJuegos();
		return ResponseEntity.ok(tecnologiaJuegos);
	}
	
	@RequestMapping(value="{ideTecnologiaJuego}", method = RequestMethod.GET)
	public ResponseEntity<TecnologiaJuego> getTecnologiaJuego(@PathVariable("ideTecnologiaJuego") Integer ideTecnologiaJuego) throws Exception{
		LOG.info("Consultando una juego");
		TecnologiaJuego tecnologiaJuego = repoTecnologiaJuego.getTecnologiaJuego(ideTecnologiaJuego);
		if(tecnologiaJuego != null) {
			return ResponseEntity.ok(tecnologiaJuego);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@RequestMapping(value="/juego/{ideJuego}", method = RequestMethod.GET)
	public ResponseEntity<List<TecnologiaJuego>> getTecnologiaJuegoByJuego(@PathVariable("ideJuego") Integer ideJuego) throws Exception{
		LOG.info("Consultando las plataformas de un juego");
		List<TecnologiaJuego> tecnologiaJuego = repoTecnologiaJuego.getTecnologiaJuegoByJuego(ideJuego);
		if(tecnologiaJuego != null) {
			return ResponseEntity.ok(tecnologiaJuego);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
		
	@PostMapping
	public ResponseEntity<TecnologiaJuego> createTecnologiaJuego(@RequestBody TecnologiaJuego tecnologiaJuego) throws Exception{
		LOG.info("Creando Juego");
		TecnologiaJuego newTecnologiaJuego = repoTecnologiaJuego.createTecnologiaJuego(tecnologiaJuego);
		if(newTecnologiaJuego != null) {
			return ResponseEntity.ok(newTecnologiaJuego);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<TecnologiaJuego> updateTecnologiaJuego(@RequestBody TecnologiaJuego tecnologiaJuego) throws Exception{
		LOG.info("Actualizando Juego");
		TecnologiaJuego updateTecnologiaJuego = repoTecnologiaJuego.updateTecnologiaJuego(tecnologiaJuego);
		if(updateTecnologiaJuego != null) {
			return ResponseEntity.ok(updateTecnologiaJuego);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteTecnologiaJuego(@PathVariable("id") Integer ideTecnologiaJuego) throws Exception{ //Metodo DELETE para eliminar un product
		LOG.info("Eliminando Tecnologia Juego");
		boolean deleteTecnologiaJuego = repoTecnologiaJuego.deleteTecnologiaJuego(ideTecnologiaJuego);
		if(deleteTecnologiaJuego) {
			return ResponseEntity.ok(null);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
