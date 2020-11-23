package com.fullgame.service;

import java.util.List;


import com.fullgame.model.Protagonista;

public interface IProtagonistaService {
	
	public List<Protagonista> getProtagonistas() throws Exception;
	public Protagonista getProtagonista(Integer ideProtagonista) throws Exception;
	public Protagonista createProtagonista(Protagonista protagonista) throws Exception;
	public Protagonista updateProtagonista(Protagonista protagonista) throws Exception;
	public boolean deleteProtagonista(Integer ideProtagonista) throws Exception;
	
}
