package com.fullgame.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fullgame.model.Cliente;
import com.fullgame.repository.IClienteRepo;

@Service
public class ClienteService implements IClienteService{

Logger LOG = LoggerFactory.getLogger(ClienteService.class);
	
	@Autowired
	private IClienteRepo repoCliente;
	
	@Override
	public List<Cliente> getClientes() throws Exception{
		LOG.info("Entrando al servicio Clientes - Metodo getClientes()");
		return repoCliente.findAll();
	}
	
	@Override
	public Cliente getCliente(String correo) throws Exception {
		LOG.info("Entrando al servicio Clientes - Metodo getCliente()");
		Optional<Cliente> optionalProduct = repoCliente.findById(correo);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}

	@Override
	public Cliente createCliente(Cliente cliente) throws Exception{
		LOG.info("Entrando al servicio Clientes - Metodo createCliente()");
		return repoCliente.save(cliente);
	}
	
	@Override
	public Cliente updateCliente(Cliente cliente) throws Exception{
		LOG.info("Entrando al servicio Clientes - Metodo updateCliente()");
		Optional<Cliente> optionalCliente = repoCliente.findById(cliente.getCorreo());
		if(optionalCliente.isPresent()) {
			Cliente updateCliente = optionalCliente.get();
			updateCliente.setNombre(cliente.getNombre());
			updateCliente.setCelular(cliente.getCelular());
			updateCliente.setCorreo(cliente.getCorreo());
			updateCliente.setEdad(cliente.getEdad());
			updateCliente.setDireccion(cliente.getDireccion());
			repoCliente.save(updateCliente);
			return updateCliente;
		}else {
			return null;
		}
	}

	@Override
	public boolean deleteCliente(String correo) throws Exception {
		try {
			LOG.info("Entrando al servicio Clientes - Metodo deleteCliente()");
			repoCliente.deleteById(correo);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	

}
