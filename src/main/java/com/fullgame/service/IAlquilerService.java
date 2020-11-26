package com.fullgame.service;

import java.util.Date;
import java.util.List;


import com.fullgame.model.Alquiler;
import com.fullgame.model.Cliente;
import com.fullgame.model.Juego;

public interface IAlquilerService {
	
	public List<Alquiler> getAlquileres() throws Exception;
	public Alquiler getAlquiler(String ideAlquiler) throws Exception;
	public int getPrecioAlquiler(int precioAlquilerDia, Date fechaInicio, Date fechaFin) throws Exception;
	public Alquiler createAlquiler(Alquiler alquiler) throws Exception;
	public Alquiler updateAlquiler(Alquiler alquiler) throws Exception;
	public boolean deleteAlquiler(String ideAlquiler) throws Exception;
	public Juego getJuegoMaxAlquilado() throws Exception;
	public List<Alquiler> getAlquilerByFechaInicio(String FechaInicio) throws Exception;
	public Cliente getClienteFrecuente() throws Exception;
	public List<Alquiler> getAlquilerByCliente(String ideCliente) throws Exception;
	
}
