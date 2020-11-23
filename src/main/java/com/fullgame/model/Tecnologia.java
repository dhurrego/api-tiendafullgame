package com.fullgame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jue_tecnologias")
public class Tecnologia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ide_tecnologia")
	private int ideTecnologia;
	@Column(name="nombre", length=50)
	private String nombre;
	public int getIdeTecnologia() {
		return ideTecnologia;
	}
	public void setIdeTecnologia(int ideTecnologia) {
		this.ideTecnologia = ideTecnologia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
