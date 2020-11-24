package com.fullgame.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fullgame.model.Juego;
import com.fullgame.repository.IJuegoRepo;

@Service
public class JuegoService implements IJuegoService{

Logger LOG = LoggerFactory.getLogger(JuegoService.class);
	
	@Autowired
	private IJuegoRepo repoJuego;
	
	@Override
	public List<Juego> getJuegos() throws Exception{
		LOG.info("Entrando al servicio Juegos - Metodo getJuegos()");
		return repoJuego.findAll();
	}
	
	@Override
	public Juego getJuego(Integer ideJuego) throws Exception {
		LOG.info("Entrando al servicio Juegos - Metodo getJuego()");
		Optional<Juego> optionalProduct = repoJuego.findById(ideJuego);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}

	@Override
	public Juego createJuego(Juego juego) throws Exception{
		LOG.info("Entrando al servicio Juegos - Metodo createJuego()");
		return repoJuego.save(juego);
	}
	
	@Override
	public Juego updateJuego(Juego juego) throws Exception{
		LOG.info("Entrando al servicio Juegos - Metodo updateJuego()");
		Optional<Juego> optionalJuego = repoJuego.findById(juego.getIdeJuego());
		if(optionalJuego.isPresent()) {
			Juego updateJuego = optionalJuego.get();
			repoJuego.save(updateJuego);
			return updateJuego;
		}else {
			return null;
		}
	}

	@Override
	public boolean deleteJuego(Integer ideJuego) throws Exception {
		try {
			LOG.info("Entrando al servicio Juegos - Metodo deleteJuego()");
			repoJuego.deleteById(ideJuego);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	

}
