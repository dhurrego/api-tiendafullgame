package com.fullgame.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fullgame.model.Director;
import com.fullgame.service.IDirectorService;

@RestController
@RequestMapping("/directores")
public class RestDirectorFullGame {
	
	Logger LOG = LoggerFactory.getLogger(RestDirectorFullGame.class);
	
	@Autowired
	private IDirectorService repoDirector;
	
	@GetMapping
	public ResponseEntity<List<Director>> getDirectors() throws Exception{
		LOG.info("Consultando Directors");
		List<Director> directors = repoDirector.getDirectores();
		return ResponseEntity.ok(directors);
	}
	
	@RequestMapping(value="{ideDirector}", method = RequestMethod.GET)
	public ResponseEntity<Director> getDirector(@PathVariable("ideDirector") Integer ideDirector) throws Exception{
		LOG.info("Consultando una director");
		Director director = repoDirector.getDirector(ideDirector);
		if(director != null) {
			return ResponseEntity.ok(director);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Director> createDirector(@RequestBody Director director) throws Exception{
		LOG.info("Creando Director");
		Director newDirector = repoDirector.createDirector(director);
		return ResponseEntity.ok(newDirector);
	}
	
	@PutMapping
	public ResponseEntity<Director> updateDirector(@RequestBody Director director) throws Exception{
		LOG.info("Actualizando Director");
		Director updateDirector = repoDirector.updateDirector(director);
		if(updateDirector != null) {
			return ResponseEntity.ok(updateDirector);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteDirector(@PathVariable("id") Integer ideDirector) throws Exception{ //Metodo DELETE para eliminar un product
		LOG.info("Eliminando Director");
		boolean deleteDirector = repoDirector.deleteDirector(ideDirector);
		if(deleteDirector) {
			return ResponseEntity.ok(null);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
