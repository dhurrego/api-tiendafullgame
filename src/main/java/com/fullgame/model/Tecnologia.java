package com.fullgame.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jue_tecnologias")
public class Tecnologia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ide_tecnologia")
	private int ideTecnologia;
	@Column(name="nombre", length=60)
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
