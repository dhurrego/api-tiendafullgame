package com.fullgame.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fullgame.model.Tecnologia;
import com.fullgame.repository.ITecnologiaRepo;

@Service
public class TecnologiaService implements ITecnologiaService{

Logger LOG = LoggerFactory.getLogger(TecnologiaService.class);
	
	@Autowired
	private ITecnologiaRepo repoTecnologia;
	
	@Override
	public List<Tecnologia> getTecnologias() throws Exception{
		LOG.info("Entrando al servicio Tecnologias - Metodo getTecnologias()");
		return repoTecnologia.findAll();
	}
	
	@Override
	public Tecnologia getTecnologia(Integer ideTecnologia) throws Exception {
		Optional<Tecnologia> optionalProduct = repoTecnologia.findById(ideTecnologia);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}

	@Override
	public Tecnologia createTecnologia(Tecnologia tecnologia) throws Exception{
		LOG.info("Entrando al servicio Tecnologias - Metodo createTecnologia()");
		return repoTecnologia.save(tecnologia);
	}
	
	@Override
	public Tecnologia updateTecnologia(Tecnologia tecnologia) throws Exception{
		LOG.info("Entrando al servicio Tecnologias - Metodo updateTecnologia()");
		Optional<Tecnologia> optionalTecnologia = repoTecnologia.findById(tecnologia.getIdeTecnologia());
		if(optionalTecnologia.isPresent()) {
			Tecnologia updateTecnologia = optionalTecnologia.get();
			updateTecnologia.setNombre(tecnologia.getNombre());
			repoTecnologia.save(updateTecnologia);
			return updateTecnologia;
		}else {
			return null;
		}
	}

	@Override
	public boolean deleteTecnologia(Integer ideTecnologia) throws Exception {
		try {
			LOG.info("Entrando al servicio Tecnologias - Metodo deleteTecnologia()");
			repoTecnologia.deleteById(ideTecnologia);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	

}
