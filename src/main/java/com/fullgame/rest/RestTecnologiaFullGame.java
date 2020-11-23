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

import com.fullgame.model.Tecnologia;
import com.fullgame.service.ITecnologiaService;

@RestController
@RequestMapping("/tecnologias")
public class RestTecnologiaFullGame {
	
	Logger LOG = LoggerFactory.getLogger(RestTecnologiaFullGame.class);
	
	@Autowired
	private ITecnologiaService repoTecnologia;
	
	@GetMapping
	public ResponseEntity<List<Tecnologia>> getTecnologias() throws Exception{
		LOG.info("Consultando Tecnologias");
		List<Tecnologia> tecnologias = repoTecnologia.getTecnologias();
		return ResponseEntity.ok(tecnologias);
	}
	
	@RequestMapping(value="{ideTecnologia}", method = RequestMethod.GET)
	public ResponseEntity<Tecnologia> getTecnologia(@PathVariable("ideTecnologia") Integer ideTecnologia) throws Exception{
		LOG.info("Consultando una tecnologia");
		Tecnologia tecnologia = repoTecnologia.getTecnologia(ideTecnologia);
		if(tecnologia != null) {
			return ResponseEntity.ok(tecnologia);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Tecnologia> createTecnologia(@RequestBody Tecnologia tecnologia) throws Exception{
		LOG.info("Creando Tecnologia");
		Tecnologia newTecnologia = repoTecnologia.createTecnologia(tecnologia);
		return ResponseEntity.ok(newTecnologia);
	}
	
	@PutMapping
	public ResponseEntity<Tecnologia> updateTecnologia(@RequestBody Tecnologia tecnologia) throws Exception{
		LOG.info("Actualizando Tecnologia");
		Tecnologia updateTecnologia = repoTecnologia.updateTecnologia(tecnologia);
		if(updateTecnologia != null) {
			return ResponseEntity.ok(updateTecnologia);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteTecnologia(@PathVariable("id") Integer ideTecnologia) throws Exception{ //Metodo DELETE para eliminar un product
		LOG.info("Eliminando Tecnologia");
		boolean deleteTecnologia = repoTecnologia.deleteTecnologia(ideTecnologia);
		if(deleteTecnologia) {
			return ResponseEntity.ok(null);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
