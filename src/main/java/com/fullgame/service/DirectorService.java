package com.fullgame.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fullgame.model.Director;
import com.fullgame.repository.IDirectorRepo;

@Service
public class DirectorService implements IDirectorService{

Logger LOG = LoggerFactory.getLogger(DirectorService.class);
	
	@Autowired
	private IDirectorRepo repoDirector;
	
	@Override
	public List<Director> getDirectores() throws Exception{
		LOG.info("Entrando al servicio Directores - Metodo getDirectores()");
		return repoDirector.findAll();
	}
	
	@Override
	public Director getDirector(Integer ideDirector) throws Exception {
		LOG.info("Entrando al servicio Directores - Metodo getDirector()");
		Optional<Director> optionalProduct = repoDirector.findById(ideDirector);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}

	@Override
	public Director createDirector(Director director) throws Exception{
		LOG.info("Entrando al servicio Directores - Metodo createDirector()");
		return repoDirector.save(director);
	}
	
	@Override
	public Director updateDirector(Director director) throws Exception{
		LOG.info("Entrando al servicio Directors - Metodo updateDirector()");
		Optional<Director> optionalDirector = repoDirector.findById(director.getIdeDirector());
		if(optionalDirector.isPresent()) {
			Director updateDirector = optionalDirector.get();
			updateDirector.setNombre(director.getNombre());
			repoDirector.save(updateDirector);
			return updateDirector;
		}else {
			return null;
		}
	}

	@Override
	public boolean deleteDirector(Integer ideDirector) throws Exception {
		try {
			LOG.info("Entrando al servicio Directors - Metodo deleteDirector()");
			repoDirector.deleteById(ideDirector);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	

}
