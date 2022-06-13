package com.mx.CRUDComputadora.dominio;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPUTADORA")
public class Computadora {
	@Id
	int id;
	String modelo;
	double precio;
	int ram;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MARCA")
	Marca marca;
	
	public Computadora() {}

	public Computadora(int id, String modelo, double precio, int ram, Marca marca) {
		this.id = id;
		this.modelo = modelo;
		this.precio = precio;
		this.ram = ram;
		this.marca = marca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Computadora [id=" + id + ", modelo=" + modelo + ", precio=" + precio + ", ram=" + ram + ", marca="
				+ marca + "]\n";
	}

	
	
}
