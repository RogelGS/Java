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
@Table(name = "APIMARCA")
public class Marca {
	@Id
	@Column
	int id;
	@Column
	String nombre;
	@Column
	String slogan;
	
	@OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
	List<Galleta> lista = new ArrayList<Galleta>();
	
	public Marca() {}

	public Marca(int id, String nombre, String slogan) {
		this.id = id;
		this.nombre = nombre;
		this.slogan = slogan;
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

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	@Override
	public String toString() {
		return "Marca [id=" + id + ", nombre=" + nombre + ", slogan=" + slogan + "]\n";
	}
	
}
