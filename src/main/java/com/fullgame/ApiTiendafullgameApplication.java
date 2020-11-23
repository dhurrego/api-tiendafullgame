package com.fullgame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTiendafullgameApplication implements CommandLineRunner{
	
	Logger LOG = LoggerFactory.getLogger(ApiTiendafullgameApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ApiTiendafullgameApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Iniciando API...");
		
	}

}
