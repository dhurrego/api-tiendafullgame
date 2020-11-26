package com.fullgame.service;

import java.util.List;


import com.fullgame.model.Juego;

public interface IJuegoService {
	
	public List<Juego> getJuegos() throws Exception;
	public Juego getJuego(Integer ideJuego) throws Exception;
	public Juego createJuego(Juego juego) throws Exception;
	public Juego updateJuego(Juego juego) throws Exception;
	public boolean deleteJuego(Integer ideJuego) throws Exception;
	public List<Juego> getJuegoByProtagonista(Integer ideProtagonista) throws Exception;
	public List<Juego> getJuegoByDirector(Integer ideDirector) throws Exception;
	public List<Juego> getJuegoByMarca(Integer ideMarca) throws Exception;
	
}
