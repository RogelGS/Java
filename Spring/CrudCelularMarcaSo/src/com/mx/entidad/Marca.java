package com.mx.entidad;

public class Marca {

	String nombre;
	String pais;
	int anios;

	public Marca() {

	}

	public Marca(String nombre) {
		this.nombre = nombre;
	}

	public Marca(String nombre, String pais, int anios) {
		this.nombre = nombre;
		this.pais = pais;
		this.anios = anios;
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", pais=" + pais + ", anios=" + anios + "]\n";
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

	public int getAnios() {
		return anios;
	}

	public void setAnios(int anios) {
		this.anios = anios;
	}

}
