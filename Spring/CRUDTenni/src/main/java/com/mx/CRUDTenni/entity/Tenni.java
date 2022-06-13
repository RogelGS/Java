package com.mx.CRUDTenni.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TENNI")
public class Tenni {
	@Id
	int id;
	String modelo;
	String marca;
	double precio;
	int num_ini;
	int num_fin;
	
	public Tenni() {}

	public Tenni(int id, String modelo, String marca, double precio, int num_ini, int num_fin) {
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.num_ini = num_ini;
		this.num_fin = num_fin;
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

	public int getNum_ini() {
		return num_ini;
	}

	public void setNum_ini(int num_ini) {
		this.num_ini = num_ini;
	}

	public int getNum_fin() {
		return num_fin;
	}

	public void setNum_fin(int num_fin) {
		this.num_fin = num_fin;
	}

	@Override
	public String toString() {
		return "Tenni [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + ", num_ini="
				+ num_ini + ", num_fin=" + num_fin + "]\n";
	}
	
	
}
