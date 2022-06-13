package com.mx.CRUDVegetales.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEGETALES")
public class Vegetal {
	@Id
	int id;
	String nombre;
	int calorias;
	double precio;
	String color;
	
	public Vegetal() {}

	public Vegetal(int id, String nombre, int calorias, double precio, String color) {
		this.id = id;
		this.nombre = nombre;
		this.calorias = calorias;
		this.precio = precio;
		this.color = color;
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

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vegetal [id=" + id + ", nombre=" + nombre + ", calorias=" + calorias + ", precio=" + precio + ", color="
				+ color + "]\n";
	}
	
	
}
