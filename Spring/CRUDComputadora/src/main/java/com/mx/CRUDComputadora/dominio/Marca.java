package com.mx.CRUDComputadora.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MARCA_COMPUTADORA")
public class Marca {
	@Id
	int id;
	String nombre;
	String pais;
	
	@OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
	List<Computadora> lista = new ArrayList<Computadora>();
	
	public Marca() {}

	public Marca(int id, String nombre, String pais) {
		this.id = id;
		this.nombre = nombre;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Marca_Computadora [id=" + id + ", nombre=" + nombre + ", pais=" + pais + "]\n";
	}
	
	
}
