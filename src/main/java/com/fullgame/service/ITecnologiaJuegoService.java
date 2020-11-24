package com.fullgame.service;

import java.util.List;


import com.fullgame.model.TecnologiaJuego;

public interface ITecnologiaJuegoService {
	
	public List<TecnologiaJuego> getTecnologiaJuegos() throws Exception;
	public TecnologiaJuego getTecnologiaJuego(Integer ideTecnologiaJuego) throws Exception;
	public TecnologiaJuego createTecnologiaJuego(TecnologiaJuego tecnologiaJuego) throws Exception;
	public TecnologiaJuego updateTecnologiaJuego(TecnologiaJuego tecnologiaJuego) throws Exception;
	public boolean deleteTecnologiaJuego(Integer ideTecnologiaJuego) throws Exception;
	
}
