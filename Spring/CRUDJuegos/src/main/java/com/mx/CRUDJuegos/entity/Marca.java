package com.mx.CRUDJuegos.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MARCA_J")
public class Marca {
	@Id
	int id;
	String nombre;
	
	@OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
	List<Videojuego> lista = new ArrayList<>();
	
	public Marca() {}

	public Marca(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "\nMarca [id=" + id + ", nombre=" + nombre + "]\n";
	}
	
}
