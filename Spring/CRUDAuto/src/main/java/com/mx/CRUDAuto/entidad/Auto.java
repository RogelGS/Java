package com.mx.CRUDAuto.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AUTO")
public class Auto {
	
	@Id
	@Column(name="ID", columnDefinition="NUMBER")
	int id;
	
	@Column(name="MODELO", columnDefinition="NVARCHAR2(100)")
	String modelo;
	
	@Column(name="MARCA", columnDefinition="NVARCHAR2(100)")
	String marca;
	
	@Column(name="PRECIO", columnDefinition="NUMBER")
	double precio;
	
	@Column(name="COLOR", columnDefinition="NVARCHAR2(100)")
	String color;
	
	public Auto() {}

	public Auto(int id, String modelo, String marca, double precio, String color) {
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.color = color;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Auto [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + ", color=" + color
				+ "]\n";
	}
	
	
}
