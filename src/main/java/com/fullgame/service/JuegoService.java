package com.fullgame.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fullgame.model.Director;
import com.fullgame.model.Juego;
import com.fullgame.model.Marca;
import com.fullgame.model.Protagonista;
import com.fullgame.repository.IDirectorRepo;
import com.fullgame.repository.IJuegoRepo;
import com.fullgame.repository.IMarcaRepo;
import com.fullgame.repository.IProtagonistaRepo;

@Service
public class JuegoService implements IJuegoService{

Logger LOG = LoggerFactory.getLogger(JuegoService.class);
	
	@Autowired
	private IJuegoRepo repoJuego;
	@Autowired
	private IProtagonistaRepo repoProtagonista;
	@Autowired
	private IDirectorRepo repoDirector;
	@Autowired
	private IMarcaRepo repoMarca;
	
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
	public List<Juego> getJuegoByProtagonista(Integer ideProtagonista) throws Exception {
		LOG.info("Entrando al servicio Juegos - Metodo getJuego()");
		List<Juego> listJuegos = repoJuego.findByIdeProtagonista(ideProtagonista);
		if(listJuegos.size() > 0) {
			return listJuegos;
		}else {
			return null;
		}
	}
	
	@Override
	public List<Juego> getJuegoByDirector(Integer ideDirector) throws Exception {
		LOG.info("Entrando al servicio Juegos - Metodo getJuegoByDirector()");
		List<Juego> listJuegos = repoJuego.findByIdeDirector(ideDirector);
		if(listJuegos.size() > 0) {
			return listJuegos;
		}else {
			return null;
		}
	}
	
	@Override
	public List<Juego> getJuegoByMarca(Integer ideMarca) throws Exception {
		LOG.info("Entrando al servicio Juegos - Metodo getJuegoByMarca()");
		List<Juego> listJuegos = repoJuego.findByIdeMarca(ideMarca);
		if(listJuegos.size() > 0) {
			return listJuegos;
		}else {
			return null;
		}
	}

	@Override
	public Juego createJuego(Juego juego) throws Exception{
		LOG.info("Entrando al servicio Juegos - Metodo createJuego()");
		LOG.info("Consultando si existe Protagonista");
		Optional<Protagonista> optionalProtagonista = repoProtagonista.findById(juego.getIdeProtagonista());
		if(optionalProtagonista.isPresent()) {
			LOG.info("Consultando si existe Director");
			Optional<Director> optionalDirector = repoDirector.findById(juego.getIdeDirector());
			if(optionalDirector.isPresent()) {
				LOG.info("Consultando si existe Marca");
				Optional<Marca> optionalMarca = repoMarca.findById(juego.getIdeMarca());
				if(optionalMarca.isPresent()) {
					LOG.info("Insertando registro");
					juego.setDirector(optionalDirector.get());
					juego.setProtagonista(optionalProtagonista.get());
					juego.setMarca(optionalMarca.get());
					return repoJuego.save(juego);
				}else {
					LOG.info("No existe una marca registrada con el ID indicado");
					return null;
				}
			}else {
				LOG.info("No existe un director registrado con el ID indicado");
				return null;
			}
		}else {
			LOG.info("No existe un protagonista registrado con el ID indicado");
			return null;
		}
		
	}
	
	@Override
	public Juego updateJuego(Juego juego) throws Exception{
		LOG.info("Entrando al servicio Juegos - Metodo updateJuego()");
		Optional<Juego> optionalJuego = repoJuego.findById(juego.getIdeJuego());
		if(optionalJuego.isPresent()) {
			LOG.info("Consultando si existe Protagonista");
			Optional<Protagonista> optionalProtagonista = repoProtagonista.findById(juego.getIdeProtagonista());
			if(optionalProtagonista.isPresent()) {
				LOG.info("Consultando si existe Director");
				Optional<Director> optionalDirector = repoDirector.findById(juego.getIdeDirector());
				if(optionalDirector.isPresent()) {
					LOG.info("Consultando si existe Marca");
					Optional<Marca> optionalMarca = repoMarca.findById(juego.getIdeMarca());
					if(optionalMarca.isPresent()) {
						LOG.info("Actualizando registro");
						Juego updateJuego = optionalJuego.get();
						updateJuego.setTitulo(juego.getTitulo());
						updateJuego.setDescripcion(juego.getDescripcion());
						updateJuego.setAnnio(juego.getAnnio());
						updateJuego.setPrecioAlquiler(juego.getPrecioAlquiler());
						updateJuego.setIdeDirector(juego.getIdeDirector());
						updateJuego.setIdeProtagonista(juego.getIdeProtagonista());
						updateJuego.setIdeMarca(juego.getIdeMarca());
						updateJuego.setProtagonista(optionalProtagonista.get());
						updateJuego.setDirector(optionalDirector.get());
						updateJuego.setMarca(optionalMarca.get());
						return repoJuego.save(updateJuego);
					}else {
						LOG.info("No existe una marca registrada con el ID indicado");
						return null;
					}
				}else {
					LOG.info("No existe un director registrado con el ID indicado");
					return null;
				}
			}else {
				LOG.info("No existe un protagonista registrado con el ID indicado");
				return null;
			}
			
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
