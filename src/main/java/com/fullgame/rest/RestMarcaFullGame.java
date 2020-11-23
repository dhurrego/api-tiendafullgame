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
import org.springframework.web.bind.annotation.RestController;

import com.fullgame.model.Marca;
import com.fullgame.service.IMarcaService;

@RestController
@RequestMapping("/marcas")
public class RestMarcaFullGame {
	
	Logger LOG = LoggerFactory.getLogger(RestMarcaFullGame.class);
	
	@Autowired
	private IMarcaService repoMarca;
	
	@GetMapping
	public ResponseEntity<List<Marca>> getMarcas() throws Exception{
		LOG.info("Consultando Marcas");
		List<Marca> marcas = repoMarca.getMarcas();
		return ResponseEntity.ok(marcas);
	}
	
	@PostMapping
	public ResponseEntity<Marca> createMarca(@RequestBody Marca marca) throws Exception{
		LOG.info("Creando Marca");
		Marca newMarca = repoMarca.createMarca(marca);
		return ResponseEntity.ok(newMarca);
	}
	
	@PutMapping
	public ResponseEntity<Marca> updateMarca(@RequestBody Marca marca) throws Exception{
		LOG.info("Actualizando Marca");
		Marca updateMarca = repoMarca.updateMarca(marca);
		if(updateMarca != null) {
			return ResponseEntity.ok(updateMarca);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteMarca(@PathVariable("id") Integer ideMarca) throws Exception{ //Metodo DELETE para eliminar un product
		LOG.info("Eliminando Marca");
		boolean deleteMarca = repoMarca.deleteMarca(ideMarca);
		if(deleteMarca) {
			return ResponseEntity.ok(null);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
