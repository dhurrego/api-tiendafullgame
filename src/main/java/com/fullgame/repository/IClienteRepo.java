package com.fullgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullgame.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, String>{
	
	
}
