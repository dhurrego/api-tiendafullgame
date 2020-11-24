package com.fullgame.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullgame.model.Cliente;

@Repository
public interface IClienteRepo extends JpaRepository<Cliente, String>{
	
	
}
