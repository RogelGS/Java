package com.mx.CRUDJuegos.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JUEGO_J")
public class Videojuego {
	@Id
	int id;
	String nombre;
	String genero;
	double precio;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MARCA")
	Marca marca;
	
	public Videojuego() {}

	public Videojuego(int id, String nombre, String genero, double precio, Marca marca) {
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.precio = precio;
		this.marca = marca;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "\nVideojuego [id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", precio=" + precio + ", marca="
				+ marca + "]\n";
	}
	
}
