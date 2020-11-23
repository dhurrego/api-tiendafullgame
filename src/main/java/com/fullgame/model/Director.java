package com.fullgame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jue_directores")
public class Director {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ide_director")
	private int ideDirector;
	@Column(name="nombre", length=120)
	private String nombre;
	
	public int getIdeDirector() {
		return ideDirector;
	}
	public void setIdeDirector(int ideDirector) {
		this.ideDirector = ideDirector;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
