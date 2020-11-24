package com.fullgame.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fullgame.model.Juego;
import com.fullgame.model.Tecnologia;
import com.fullgame.model.TecnologiaJuego;
import com.fullgame.repository.IJuegoRepo;
import com.fullgame.repository.ITecnologiaJuegoRepo;
import com.fullgame.repository.ITecnologiaRepo;

@Service
public class TecnologiaJuegoService implements ITecnologiaJuegoService{

Logger LOG = LoggerFactory.getLogger(TecnologiaJuegoService.class);
	
	@Autowired
	private ITecnologiaJuegoRepo repoTecnologiaJuego;
	@Autowired
	private IJuegoRepo repoJuego;
	@Autowired
	private ITecnologiaRepo repoTecnologia;
	
	@Override
	public List<TecnologiaJuego> getTecnologiaJuegos() throws Exception{
		LOG.info("Entrando al servicio Tecnologia Juegos - Metodo getTecnologiaJuegos()");
		return repoTecnologiaJuego.findAll();
	}
	
	@Override
	public TecnologiaJuego getTecnologiaJuego(Integer ideTecnologiaJuego) throws Exception {
		LOG.info("Entrando al servicio Tecnologia Juegos - Metodo getTecnologiaJuego()");
		Optional<TecnologiaJuego> optionalProduct = repoTecnologiaJuego.findById(ideTecnologiaJuego);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}

	@Override
	public TecnologiaJuego createTecnologiaJuego(TecnologiaJuego tecnologiaJuego) throws Exception{
		LOG.info("Entrando al servicio Tecnologia Juegos - Metodo createTecnologiaJuego()");
		LOG.info("Consultando si existe el Juego");
		Optional<Juego> optionalJuego = repoJuego.findById(tecnologiaJuego.getIdeJuego());
		if(optionalJuego.isPresent()) {
			LOG.info("Consultando si existe la Tecnologia");
			Optional<Tecnologia> optionalTecnologia = repoTecnologia.findById(tecnologiaJuego.getIdeTecnologia());
			if(optionalTecnologia.isPresent()) {
					LOG.info("Insertando registro");
					tecnologiaJuego.setJuego(optionalJuego.get());
					tecnologiaJuego.setTecnologia(optionalTecnologia.get());
					return repoTecnologiaJuego.save(tecnologiaJuego);
			}else {
				LOG.info("No existe una tecnologia registrada con el ID indicado");
				return null;
			}
		}else {
			LOG.info("No existe un juego registrado con el ID indicado");
			return null;
		}
		
	}
	
	@Override
	public TecnologiaJuego updateTecnologiaJuego(TecnologiaJuego tecnologiaJuego) throws Exception{
		LOG.info("Entrando al servicio Tecnologia Juego - Metodo updateTecnologiaJuego()");
		Optional<TecnologiaJuego> optionalTecnologiaJuego = repoTecnologiaJuego.findById(tecnologiaJuego.getIdeTecnologiaJuego());
		if(optionalTecnologiaJuego.isPresent()) {
			Optional<Juego> optionalJuego = repoJuego.findById(tecnologiaJuego.getIdeJuego());
			if(optionalJuego.isPresent()) {
				LOG.info("Consultando si existe la Tecnologia");
				Optional<Tecnologia> optionalTecnologia = repoTecnologia.findById(tecnologiaJuego.getIdeTecnologia());
				if(optionalTecnologia.isPresent()) {
					LOG.info("Actualizando registro");
					TecnologiaJuego updateTecnologiaJuego = optionalTecnologiaJuego.get();
					updateTecnologiaJuego.setIdeJuego(tecnologiaJuego.getIdeJuego());
					updateTecnologiaJuego.setIdeTecnologia(tecnologiaJuego.getIdeTecnologia());
					updateTecnologiaJuego.setJuego(optionalJuego.get());
					updateTecnologiaJuego.setTecnologia(optionalTecnologia.get());
					return repoTecnologiaJuego.save(updateTecnologiaJuego);
				}else {
					LOG.info("No existe una tecnologia registrada con el ID indicado");
					return null;
				}
			}else {
				LOG.info("No existe un juego registrado con el ID indicado");
				return null;
			}
		}else {
			LOG.info("No existe una tecnologia juego registrada con el ID indicado");
			return null;
		}
		
	}

	@Override
	public boolean deleteTecnologiaJuego(Integer ideTecnologiaJuego) throws Exception {
		try {
			LOG.info("Entrando al servicio Tecnologia Juegos - Metodo deleteTecnologiaJuego()");
			repoTecnologiaJuego.deleteById(ideTecnologiaJuego);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	

}
