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

import com.fullgame.model.Protagonista;
import com.fullgame.service.IProtagonistaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/protagonistas")
public class RestProtagonistaFullGame {
	
	Logger LOG = LoggerFactory.getLogger(RestProtagonistaFullGame.class);
	
	@Autowired
	private IProtagonistaService repoProtagonista;
	
	@GetMapping
	public ResponseEntity<List<Protagonista>> getProtagonistas() throws Exception{
		LOG.info("Consultando Protagonistas");
		List<Protagonista> protagonistas = repoProtagonista.getProtagonistas();
		return ResponseEntity.ok(protagonistas);
	}
	
	@RequestMapping(value="{ideProtagonista}", method = RequestMethod.GET)
	public ResponseEntity<Protagonista> getProtagonista(@PathVariable("ideProtagonista") Integer ideProtagonista) throws Exception{
		LOG.info("Consultando una protagonista");
		Protagonista protagonista = repoProtagonista.getProtagonista(ideProtagonista);
		if(protagonista != null) {
			return ResponseEntity.ok(protagonista);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Protagonista> createProtagonista(@RequestBody Protagonista protagonista) throws Exception{
		LOG.info("Creando Protagonista");
		Protagonista newProtagonista = repoProtagonista.createProtagonista(protagonista);
		return ResponseEntity.ok(newProtagonista);
	}
	
	@PutMapping
	public ResponseEntity<Protagonista> updateProtagonista(@RequestBody Protagonista protagonista) throws Exception{
		LOG.info("Actualizando Protagonista");
		Protagonista updateProtagonista = repoProtagonista.updateProtagonista(protagonista);
		if(updateProtagonista != null) {
			return ResponseEntity.ok(updateProtagonista);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteProtagonista(@PathVariable("id") Integer ideProtagonista) throws Exception{ //Metodo DELETE para eliminar un product
		LOG.info("Eliminando Protagonista");
		boolean deleteProtagonista = repoProtagonista.deleteProtagonista(ideProtagonista);
		if(deleteProtagonista) {
			return ResponseEntity.ok(null);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
