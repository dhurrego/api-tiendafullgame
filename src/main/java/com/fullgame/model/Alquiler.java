package com.fullgame.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="jue_alquileres")
public class Alquiler implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ide_alquiler", length=20)
	private String ideAlquiler;
	@Column(name="fecha_inicio")
	@Temporal(TemporalType.DATE)
    private Date fechaInicio;
	@Column(name="fecha_fin")
	@Temporal(TemporalType.DATE)
    private Date fechaFin;
	@Column(name="precio_alquiler")
	private int precioAlquiler;

	@ManyToOne
	@JoinColumn(name="ide_juego", insertable = false, updatable = false)
	private Juego juego;
	
	@Column(name="ide_juego")
	private int ideJuego;
	
	@ManyToOne
	@JoinColumn(name="ide_cliente", insertable = false, updatable = false)
	private Cliente cliente;
	
	@Column(name="ide_cliente", length=120)
	private String ideCliente;
	
	@ManyToOne
	@JoinColumn(name="ide_tecnologia_juegos", insertable = false, updatable = false)
	private TecnologiaJuego tecnologiaJuego;
	
	@Column(name="ide_tecnologia_juegos")
	private int ideTecnologiaJuego;

	public String getIdeAlquiler() {
		return ideAlquiler;
	}

	public void setIdeAlquiler(String ideAlquiler) {
		this.ideAlquiler = ideAlquiler;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getPrecioAlquiler() {
		return precioAlquiler;
	}

	public void setPrecioAlquiler(int precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getIdeCliente() {
		return ideCliente;
	}

	public void setIdeCliente(String ideCliente) {
		this.ideCliente = ideCliente;
	}

	public TecnologiaJuego getTecnologiaJuego() {
		return tecnologiaJuego;
	}

	public void setTecnologiaJuego(TecnologiaJuego tecnologiaJuego) {
		this.tecnologiaJuego = tecnologiaJuego;
	}

	public int getIdeTecnologiaJuego() {
		return ideTecnologiaJuego;
	}

	public void setIdeTecnologiaJuego(int ideTecnologiaJuego) {
		this.ideTecnologiaJuego = ideTecnologiaJuego;
	}
	
}
