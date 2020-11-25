package com.fullgame.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fullgame.model.Juego;
import com.fullgame.model.Alquiler;
import com.fullgame.model.Cliente;
import com.fullgame.model.TecnologiaJuego;
import com.fullgame.repository.IJuegoRepo;
import com.fullgame.repository.IAlquilerRepo;
import com.fullgame.repository.IClienteRepo;
import com.fullgame.repository.ITecnologiaJuegoRepo;

@Service
public class AlquilerService implements IAlquilerService{

Logger LOG = LoggerFactory.getLogger(AlquilerService.class);
	
	@Autowired
	private IAlquilerRepo repoAlquiler;
	@Autowired
	private IJuegoRepo repoJuego;
	@Autowired
	private IClienteRepo repoCliente;
	@Autowired
	private ITecnologiaJuegoRepo repoTecnologiaJuego;
	
	@Override
	public List<Alquiler> getAlquileres() throws Exception{
		LOG.info("Entrando al servicio Alquileres - Metodo getAlquileres()");
		return repoAlquiler.findAll();
	}
	
	@Override
	public Alquiler getAlquiler(String ideAlquiler) throws Exception {
		LOG.info("Entrando al servicio Alquileres - Metodo getAlquiler()");
		Optional<Alquiler> optionalAlquiler = repoAlquiler.findById(ideAlquiler);
		if(optionalAlquiler.isPresent()) {
			return optionalAlquiler.get();
		}else {
			return null;
		}
	}

	@Override
	public Alquiler createAlquiler(Alquiler alquiler) throws Exception{
		LOG.info("Entrando al servicio Alquileres - Metodo createAlquiler()");
		LOG.info("Consultando si existe Juego");
		Optional<Juego> optionalJuego = repoJuego.findById(alquiler.getIdeJuego());
		if(optionalJuego.isPresent()) {
			LOG.info("Consultando si existe el Cliente");
			Optional<Cliente> optionalCliente = repoCliente.findById(alquiler.getIdeCliente());
			if(optionalCliente.isPresent()) {
				LOG.info("Consultando si existe Tecnologia Juego (Plataforma)");
				Optional<TecnologiaJuego> optionalTecnologiaJuego= repoTecnologiaJuego.findById(alquiler.getIdeTecnologiaJuego());
				if(optionalTecnologiaJuego.isPresent()) {
					if(optionalTecnologiaJuego.get().getIdeJuego() == alquiler.getIdeJuego()) {
						if(alquiler.getFechaFin().getTime() > alquiler.getFechaInicio().getTime()) {
							LOG.info("Insertando registro");
							Calendar fecha = Calendar.getInstance();
							String newIdeAlquiler = "AL" + fecha.getTimeInMillis();
							alquiler.setIdeAlquiler(newIdeAlquiler);
							int newPrecioAlquiler = getPrecioAlquiler(optionalJuego.get().getPrecioAlquiler(), alquiler.getFechaInicio(), alquiler.getFechaFin());
							alquiler.setPrecioAlquiler(newPrecioAlquiler);
							alquiler.setJuego(optionalJuego.get());
							alquiler.setCliente(optionalCliente.get());
							alquiler.setTecnologiaJuego(optionalTecnologiaJuego.get());
							return repoAlquiler.save(alquiler);
						}else {
							LOG.error("La fecha fin debe ser mayor a la fecha inicio");
							return null;
						}
					}else {
						LOG.info("La tecnologia de juego (plataforma) seleccionada no esta disponible para este juego");
						return null;
					}					
				}else {
					LOG.info("No existe una tecnologia juego (plataforma) registrada con el ID indicado");
					return null;
				}
			}else {
				LOG.info("No existe un cliente registrado con el correo indicado");
				return null;
			}
		}else {
			LOG.info("No existe un juego registrado con el ID indicado");
			return null;
		}
		
	}
	
	@Override
	public Alquiler updateAlquiler(Alquiler alquiler) throws Exception{
		LOG.info("Entrando al servicio Alquilers - Metodo updateAlquiler()");
		Optional<Alquiler> optionalAlquiler = repoAlquiler.findById(alquiler.getIdeAlquiler());
		if(optionalAlquiler.isPresent()) {
			LOG.info("Consultando si existe Juego");
			Optional<Juego> optionalJuego = repoJuego.findById(alquiler.getIdeJuego());
			if(optionalJuego.isPresent()) {
				LOG.info("Consultando si existe el Cliente");
				Optional<Cliente> optionalCliente = repoCliente.findById(alquiler.getIdeCliente());
				if(optionalCliente.isPresent()) {
					LOG.info("Consultando si existe Tecnologia Juego (Plataforma)");
					Optional<TecnologiaJuego> optionalTecnologiaJuego= repoTecnologiaJuego.findById(alquiler.getIdeTecnologiaJuego());
					if(optionalTecnologiaJuego.isPresent()) {
						if(optionalTecnologiaJuego.get().getIdeJuego() == alquiler.getIdeJuego()) {
							if(alquiler.getFechaFin().getTime() >= alquiler.getFechaInicio().getTime()) {
								LOG.info("Actualizando registro");
								Alquiler updateAlquiler = optionalAlquiler.get();
								int newPrecioAlquiler = getPrecioAlquiler(optionalJuego.get().getPrecioAlquiler(), alquiler.getFechaInicio(), alquiler.getFechaFin());
								updateAlquiler.setIdeJuego(alquiler.getIdeJuego());
								updateAlquiler.setIdeCliente(alquiler.getIdeCliente());
								updateAlquiler.setTecnologiaJuego(alquiler.getTecnologiaJuego());
								updateAlquiler.setPrecioAlquiler(newPrecioAlquiler);
								updateAlquiler.setFechaInicio(alquiler.getFechaInicio());
								updateAlquiler.setFechaFin(alquiler.getFechaFin());
								updateAlquiler.setJuego(optionalJuego.get());
								updateAlquiler.setCliente(optionalCliente.get());
								updateAlquiler.setTecnologiaJuego(optionalTecnologiaJuego.get());
								return repoAlquiler.save(updateAlquiler);
							}else {
								LOG.error("La fecha fin debe ser mayor a la fecha inicio");
								return null;
							}
							
						}else {
							LOG.info("La tecnologia de juego (plataforma) seleccionada no esta disponible para este juego");
							return null;
						}					
					}else {
						LOG.info("No existe una tecnologia juego (plataforma) registrada con el ID indicado");
						return null;
					}
				}else {
					LOG.info("No existe un cliente registrado con el correo indicado");
					return null;
				}
			}else {
				LOG.info("No existe un juego registrado con el ID indicado");
				return null;
			}
		}else {
			LOG.info("No existe un alquiler con el ID ingresado");
			return null;
		}
	}

	@Override
	public boolean deleteAlquiler(String ideAlquiler) throws Exception {
		try {
			LOG.info("Entrando al servicio Alquilers - Metodo deleteAlquiler()");
			repoAlquiler.deleteById(ideAlquiler);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	@Override
	public int getPrecioAlquiler(int precioAlquilerDia, Date fechaInicio, Date fechaFin) throws Exception {
		if(fechaFin.getTime()>=fechaInicio.getTime()) {
			LOG.info("Calculando el precio del alquiler");
			long diferencia = fechaFin.getTime() - fechaInicio.getTime(); 
			long dias = TimeUnit.DAYS.convert(diferencia, TimeUnit.MILLISECONDS);
			if(dias == 0) { // En caso de que la fecha fin sea igual a la fecha de inicio
				dias = 1;
			}
			int precio = (int) (precioAlquilerDia * dias);
			return precio;
		}else {
			return -1;
		}
		
	}

	

}
