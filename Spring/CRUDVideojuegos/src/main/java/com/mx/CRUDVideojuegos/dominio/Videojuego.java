package com.mx.CRUDVideojuegos.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIDEOJUEGO")
public class Videojuego {
	@Id
	int id;
	String nombre;
	String marca;
	String genero;
	double precio;
	
	public Videojuego() {
		
	}

	public Videojuego(int id, String nombre, String marca, String genero, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.genero = genero;
		this.precio = precio;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", genero=" + genero + ", precio="
				+ precio + "]\n";
	}
	
	
}
