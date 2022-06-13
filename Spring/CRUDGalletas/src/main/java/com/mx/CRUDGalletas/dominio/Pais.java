package com.mx.CRUDGalletas.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APIPAIS")
public class Pais {
	@Id
	@Column
	int id;
	@Column
	String nombre;
	@Column
	int continente;
	
	@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
	List<Galleta> lista = new ArrayList<Galleta>();
	
	public Pais() {}

	public Pais(int id, String nombre, int continente) {
		this.id = id;
		this.nombre = nombre;
		this.continente = continente;
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

	public int getContinente() {
		return continente;
	}

	public void setContinente(int continente) {
		this.continente = continente;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre + ", continente=" + continente + "]\n";
	}
	
}
