package com.fullgame.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fullgame.model.Marca;
import com.fullgame.repository.IMarcaRepo;
import com.fullgame.rest.RestMarcaFullGame;

@Service
public class MarcaService implements IMarcaService{

Logger LOG = LoggerFactory.getLogger(RestMarcaFullGame.class);
	
	@Autowired
	private IMarcaRepo repoMarca;
	
	@Override
	public List<Marca> getMarcas() throws Exception{
		LOG.info("Entrando al servicio Marcas - Metodo getMarcas()");
		return repoMarca.findAll();
	}

	@Override
	public Marca createMarca(Marca marca) throws Exception{
		LOG.info("Entrando al servicio Marcas - Metodo createMarca()");
		return repoMarca.save(marca);
	}
	
	@Override
	public Marca updateMarca(Marca marca) throws Exception{
		LOG.info("Entrando al servicio Marcas - Metodo updateMarca()");
		Optional<Marca> optionalMarca = repoMarca.findById(marca.getIdeMarca());
		if(optionalMarca.isPresent()) {
			Marca updateMarca = optionalMarca.get();
			updateMarca.setNombre(marca.getNombre());
			repoMarca.save(updateMarca);
			return updateMarca;
		}else {
			return null;
		}
	}

	@Override
	public boolean deleteMarca(Integer ideMarca) throws Exception {
		try {
			LOG.info("Entrando al servicio Marcas - Metodo deleteMarca()");
			repoMarca.deleteById(ideMarca);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

}
