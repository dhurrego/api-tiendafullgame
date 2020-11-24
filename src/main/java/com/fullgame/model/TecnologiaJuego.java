package com.fullgame.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jue_tecnologia_juegos")
public class TecnologiaJuego implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ide_tecnologia_juego")
	private int ideTecnologiaJuego;

	@ManyToOne
	@JoinColumn(name="ide_juego", insertable = false, updatable = false)
	private Juego juego;
	
	@Column(name="ide_juego")
	private int ideJuego;
	
	@ManyToOne
	@JoinColumn(name="ide_tecnologia", insertable = false, updatable = false)
	private Tecnologia tecnologia;
	
	@Column(name="ide_tecnologia")
	private int ideTecnologia;

	public int getIdeTecnologiaJuego() {
		return ideTecnologiaJuego;
	}

	public void setIdeTecnologiaJuego(int ideTecnologiaJuego) {
		this.ideTecnologiaJuego = ideTecnologiaJuego;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public int getIdeJuego() {
		return ideJuego;
	}

	public void setIdeJuego(int ideJuego) {
		this.ideJuego = ideJuego;
	}

	public Tecnologia getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}

	public int getIdeTecnologia() {
		return ideTecnologia;
	}

	public void setIdeTecnologia(int ideTecnologia) {
		this.ideTecnologia = ideTecnologia;
	}		
	
}
