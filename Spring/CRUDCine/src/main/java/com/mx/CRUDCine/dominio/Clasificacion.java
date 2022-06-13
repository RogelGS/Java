package com.mx.CRUDCine.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APICLASIFICACION")
public class Clasificacion {
	@Id
	int id;
	String nombre;
	int edad_min;
	int edad_max;
	
	@OneToMany(mappedBy = "clasificacion", cascade = CascadeType.ALL)
	List<Pelicula> lista = new ArrayList<>();
	
	public Clasificacion() {}
	
	public Clasificacion(int id) {
		this.id = id;
	}

	public Clasificacion(int id, String nombre, int edad_min, int edad_max) {
		this.id = id;
		this.nombre = nombre;
		this.edad_min = edad_min;
		this.edad_max = edad_max;
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

	public int getEdad_min() {
		return edad_min;
	}

	public void setEdad_min(int edad_min) {
		this.edad_min = edad_min;
	}

	public int getEdad_max() {
		return edad_max;
	}

	public void setEdad_max(int edad_max) {
		this.edad_max = edad_max;
	}

	@Override
	public String toString() {
		return "Clasificacion [id=" + id + ", nombre=" + nombre + ", edad_min=" + edad_min + ", edad_max=" + edad_max
				+ "]\n";
	}
	
	
}
