package com.mx.CRUDCine.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APIGENERO")
public class Genero {
	@Id
	int id;
	String nombre;
	int estatus;
	
	@OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
	List<Pelicula> lista = new ArrayList<>();
	
	public Genero() {}
	
	public Genero(int id) {
		this.id = id;
	}

	public Genero(int id, String nombre, int estatus) {
		this.id = id;
		this.nombre = nombre;
		this.estatus = estatus;
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

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Genero [id=" + id + ", nombre=" + nombre + ", estatus=" + estatus + "]\n";
	}
	
	
}
