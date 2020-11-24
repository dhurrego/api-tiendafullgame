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
@Table(name="jue_juegos")
public class Juego implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ide_juego")
	private int ideJuego;
	@Column(name="titulo", length=120)
	private String titulo;
	@Column(name="descripcion", length=255)
	private String descripcion;
	@Column(name="año")
	private int año;
	@Column(name="precio_alquiler")
	private int precioAlquiler;

	@ManyToOne
	@JoinColumn(name="ide_protagonista", insertable = false, updatable = false)
	private Protagonista protagonista;
	
	@Column(name="ide_protagonista")
	private int ideProtagonista;
	
	@ManyToOne
	@JoinColumn(name="ide_director", insertable = false, updatable = false)
	private Director director;
	
	@Column(name="ide_director")
	private int ideDirector;
	
	@ManyToOne
	@JoinColumn(name="ide_marca", insertable = false, updatable = false)
	private Marca marca;
	
	@Column(name="ide_marca")
	private int ideMarca;

	public int getIdeJuego() {
		return ideJuego;
	}

	public void setIdeJuego(int ideJuego) {
		this.ideJuego = ideJuego;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getPrecioAlquiler() {
		return precioAlquiler;
	}

	public void setPrecioAlquiler(int precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}

	public Protagonista getProtagonista() {
		return protagonista;
	}

	public void setProtagonista(Protagonista protagonista) {
		this.protagonista = protagonista;
	}

	public int getIdeProtagonista() {
		return ideProtagonista;
	}

	public void setIdeProtagonista(int ideProtagonista) {
		this.ideProtagonista = ideProtagonista;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public int getIdeDirector() {
		return ideDirector;
	}

	public void setIdeDirector(int ideDirector) {
		this.ideDirector = ideDirector;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public int getIdeMarca() {
		return ideMarca;
	}

	public void setIdeMarca(int ideMarca) {
		this.ideMarca = ideMarca;
	}
	
	
	
	
	
}
