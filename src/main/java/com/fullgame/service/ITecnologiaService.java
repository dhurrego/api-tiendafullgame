package com.fullgame.service;

import java.util.List;


import com.fullgame.model.Tecnologia;

public interface ITecnologiaService {
	
	public List<Tecnologia> getTecnologias() throws Exception;
	public Tecnologia getTecnologia(Integer ideTecnologia) throws Exception;
	public Tecnologia createTecnologia(Tecnologia tecnologia) throws Exception;
	public Tecnologia updateTecnologia(Tecnologia tecnologia) throws Exception;
	public boolean deleteTecnologia(Integer ideTecnologia) throws Exception;
	
}
