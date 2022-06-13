package com.mx.CRUDGalletas.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APIGALLETA")
public class Galleta {
	@Id
	@Column
	int id;
	@Column
	String nombre;
	@Column
	double precio;
	@Column
	int conte_neto;
	@Column
	String sabor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MARCA")
	Marca marca;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PAIS")
	Pais pais;
	
	public Galleta() {}

	public Galleta(int id, String nombre, double precio, int conte_neto, String sabor, Marca marca, Pais pais) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.conte_neto = conte_neto;
		this.sabor = sabor;
		this.marca = marca;
		this.pais = pais;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getConte_neto() {
		return conte_neto;
	}

	public void setConte_neto(int conte_neto) {
		this.conte_neto = conte_neto;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Galleta [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", conte_neto=" + conte_neto
				+ ", sabor=" + sabor + ", marca=" + marca + ", pais=" + pais + "]\n";
	}
	
}
