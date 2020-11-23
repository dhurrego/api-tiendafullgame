package com.fullgame.service;

import java.util.List;


import com.fullgame.model.Marca;

public interface IMarcaService {
	
	public List<Marca> getMarcas() throws Exception;
	public Marca getMarca(Integer idMarca) throws Exception;
	public Marca createMarca(Marca marca) throws Exception;
	public Marca updateMarca(Marca marca) throws Exception;
	public boolean deleteMarca(Integer ideMarca) throws Exception;
	
}
