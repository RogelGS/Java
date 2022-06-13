package com.mx.CRUDGym.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GYM")
public class Gym {
	@Id
	int id;
	String nombre;
	double mensualidad;
	double inscripcion;
	String estado;
	
	public Gym() {}

	public Gym(int id, String nombre, double mensualidad, double inscripcion, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.mensualidad = mensualidad;
		this.inscripcion = inscripcion;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getMensualidad() {
		return mensualidad;
	}

	public void setMensualidad(double mensualidad) {
		this.mensualidad = mensualidad;
	}

	public double getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(double inscripcion) {
		this.inscripcion = inscripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Gym [id=" + id + ", nombre=" + nombre + ", mensualidad=" + mensualidad + ", inscripcion=" + inscripcion
				+ ", estado=" + estado + "]\n";
	}
	
	
}
