package com.mx.CRUDRefresco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REFRESCO")
public class Refresco {
	@Id
	@Column(name="ID", columnDefinition="NUMBER")
	int id;
	
	@Column(name="NOMBRE", columnDefinition="NVARCHAR2(100)")
	String nombre;
	
	@Column(name="MARCA", columnDefinition="NVARCHAR2(100)")
	String marca;
	
	@Column(name="PRECIO", columnDefinition="NUMBER")
	double precio;
	
	@Column(name="CONTENIDO", columnDefinition="NUMBER")
	int contenido;
	
	public Refresco() {}

	public Refresco(int id, String nombre, String marca, double precio, int contenido) {
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.contenido = contenido;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getContenido() {
		return contenido;
	}

	public void setContenido(int contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "Refresco [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", precio=" + precio + ", contenido="
				+ contenido + "]\n";
	}
	
	
}
