package com.fullgame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jue_marcas")
public class Marca {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ide_marca")
	private int ideMarca;
	@Column(name="nombre", length=50)
	private String nombre;
	
	public int getIdeMarca() {
		return ideMarca;
	}
	public void setIde_marca(int ideMarca) {
		this.ideMarca = ideMarca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
