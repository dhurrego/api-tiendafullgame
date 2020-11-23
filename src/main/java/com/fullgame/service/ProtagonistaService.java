package com.fullgame.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fullgame.model.Protagonista;
import com.fullgame.repository.IProtagonistaRepo;

@Service
public class ProtagonistaService implements IProtagonistaService{

Logger LOG = LoggerFactory.getLogger(ProtagonistaService.class);
	
	@Autowired
	private IProtagonistaRepo repoProtagonista;
	
	@Override
	public List<Protagonista> getProtagonistas() throws Exception{
		LOG.info("Entrando al servicio Protagonistas - Metodo getProtagonistas()");
		return repoProtagonista.findAll();
	}
	
	@Override
	public Protagonista getProtagonista(Integer ideProtagonista) throws Exception {
		Optional<Protagonista> optionalProduct = repoProtagonista.findById(ideProtagonista);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}

	@Override
	public Protagonista createProtagonista(Protagonista protagonista) throws Exception{
		LOG.info("Entrando al servicio Protagonistas - Metodo createProtagonista()");
		return repoProtagonista.save(protagonista);
	}
	
	@Override
	public Protagonista updateProtagonista(Protagonista protagonista) throws Exception{
		LOG.info("Entrando al servicio Protagonistas - Metodo updateProtagonista()");
		Optional<Protagonista> optionalProtagonista = repoProtagonista.findById(protagonista.getIdeProtagonista());
		if(optionalProtagonista.isPresent()) {
			Protagonista updateProtagonista = optionalProtagonista.get();
			updateProtagonista.setNombre(protagonista.getNombre());
			repoProtagonista.save(updateProtagonista);
			return updateProtagonista;
		}else {
			return null;
		}
	}

	@Override
	public boolean deleteProtagonista(Integer ideProtagonista) throws Exception {
		try {
			LOG.info("Entrando al servicio Protagonistas - Metodo deleteProtagonista()");
			repoProtagonista.deleteById(ideProtagonista);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	

}
