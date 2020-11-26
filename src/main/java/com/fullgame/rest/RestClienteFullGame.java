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

import com.fullgame.model.Cliente;
import com.fullgame.service.IClienteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/clientes")
public class RestClienteFullGame {
	
	Logger LOG = LoggerFactory.getLogger(RestClienteFullGame.class);
	
	@Autowired
	private IClienteService repoCliente;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes() throws Exception{
		LOG.info("Consultando Clientes");
		List<Cliente> clientes = repoCliente.getClientes();
		return ResponseEntity.ok(clientes);
	}
	
	@RequestMapping(value="{correo}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> getCliente(@PathVariable("correo") String correo) throws Exception{
		LOG.info("Consultando una cliente");
		Cliente cliente = repoCliente.getCliente(correo);
		if(cliente != null) {
			return ResponseEntity.ok(cliente);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) throws Exception{
		LOG.info("Creando Cliente");
		Cliente newCliente = repoCliente.createCliente(cliente);
		return ResponseEntity.ok(newCliente);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) throws Exception{
		LOG.info("Actualizando Cliente");
		Cliente updateCliente = repoCliente.updateCliente(cliente);
		if(updateCliente != null) {
			return ResponseEntity.ok(updateCliente);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value="{correo}")
	public ResponseEntity<Void> deleteCliente(@PathVariable("correo") String correo) throws Exception{ //Metodo DELETE para eliminar un product
		LOG.info("Eliminando Cliente");
		boolean deleteCliente = repoCliente.deleteCliente(correo);
		if(deleteCliente) {
			return ResponseEntity.ok(null);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
