package com.mx.CRUDCine.dominio;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APIPELICULA")
public class Pelicula {
	@Id
	int id;
	String nombre;
	double precio;
	String fecha_estreno;
	String duracion;
	int idioma;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_GENERO")
	Genero genero;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CLASIFICACION")
	Clasificacion clasificacion;
	
	public Pelicula() {}

	public Pelicula(int id, String nombre, double precio, String fecha_estreno, String duracion, int idioma,
			Genero genero, Clasificacion clasificacion) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fecha_estreno = fecha_estreno;
		this.duracion = duracion;
		this.idioma = idioma;
		this.genero = genero;
		this.clasificacion = clasificacion;
	}

	public Pelicula(int id) {
		this.id = id;
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

	public String getFecha_estreno() {
		return fecha_estreno;
	}

	public void setFecha_estreno(String fecha_estreno) {
		this.fecha_estreno = fecha_estreno;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public int getIdioma() {
		return idioma;
	}

	public void setIdioma(int idioma) {
		this.idioma = idioma;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", fecha_estreno=" + fecha_estreno
				+ ", duracion=" + duracion + ", idioma=" + idioma + ", genero=" + genero + ", clasificacion="
				+ clasificacion + "]\n";
	}
	
}
