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

import com.fullgame.model.Alquiler;
import com.fullgame.service.IAlquilerService;

@RestController
@RequestMapping("/alquileres")
public class RestAlquilerFullGame {
	
	Logger LOG = LoggerFactory.getLogger(RestAlquilerFullGame.class);
	
	@Autowired
	private IAlquilerService repoAlquiler;
	
	@GetMapping
	public ResponseEntity<List<Alquiler>> getAlquilers() throws Exception{
		LOG.info("Consultando Alquileres");
		List<Alquiler> alquilers = repoAlquiler.getAlquileres();
		return ResponseEntity.ok(alquilers);
	}
	
	@RequestMapping(value="{ideAlquiler}", method = RequestMethod.GET)
	public ResponseEntity<Alquiler> getAlquiler(@PathVariable("ideAlquiler") String ideAlquiler) throws Exception{
		LOG.info("Consultando una alquiler");
		Alquiler alquiler = repoAlquiler.getAlquiler(ideAlquiler);
		if(alquiler != null) {
			return ResponseEntity.ok(alquiler);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
		
	@PostMapping
	public ResponseEntity<Alquiler> createAlquiler(@RequestBody Alquiler alquiler) throws Exception{
		LOG.info("Creando Alquiler");
		Alquiler newAlquiler = repoAlquiler.createAlquiler(alquiler);
		if(newAlquiler != null) {
			return ResponseEntity.ok(newAlquiler);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Alquiler> updateAlquiler(@RequestBody Alquiler alquiler) throws Exception{
		LOG.info("Actualizando Alquiler");
		Alquiler updateAlquiler = repoAlquiler.updateAlquiler(alquiler);
		if(updateAlquiler != null) {
			return ResponseEntity.ok(updateAlquiler);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteAlquiler(@PathVariable("id") String ideAlquiler) throws Exception{ //Metodo DELETE para eliminar un product
		LOG.info("Eliminando Alquiler");
		boolean deleteAlquiler = repoAlquiler.deleteAlquiler(ideAlquiler);
		if(deleteAlquiler) {
			return ResponseEntity.ok(null);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
