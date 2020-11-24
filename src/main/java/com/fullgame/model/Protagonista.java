package com.fullgame.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jue_protagonistas")
public class Protagonista implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ide_protagonista")
	private int ideProtagonista;
	@Column(name="nombre", length=120)
	private String nombre;
	
	public int getIdeProtagonista() {
		return ideProtagonista;
	}
	public void setIdeProtagonista(int ideProtagonista) {
		this.ideProtagonista = ideProtagonista;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
