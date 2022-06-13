package com.mx.CRUDPelicula.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PELICULAAPI")
public class Pelicula {
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER")
	int Id;
	
	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(100)")
	String nombre;
	
	@Column(name = "GENERO", columnDefinition = "NVARCHAR2(100)")
	String genero;
	
	@Column(name = "DURACION", columnDefinition = "NVARCHAR2(100)")
	String duracion;

	public Pelicula() {}

	public Pelicula(int id, String nombre, String genero, String duracion) {
		Id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.duracion = duracion;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Pelicula [Id=" + Id + ", nombre=" + nombre + ", genero=" + genero + ", duracion=" + duracion + "]\n";
	}
	
	
}
