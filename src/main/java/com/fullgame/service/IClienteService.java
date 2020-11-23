package com.fullgame.service;

import java.util.List;


import com.fullgame.model.Cliente;

public interface IClienteService {
	
	public List<Cliente> getClientes() throws Exception;
	public Cliente getCliente(String correo) throws Exception;
	public Cliente createCliente(Cliente cliente) throws Exception;
	public Cliente updateCliente(Cliente cliente) throws Exception;
	public boolean deleteCliente(String correo) throws Exception;
	
}
