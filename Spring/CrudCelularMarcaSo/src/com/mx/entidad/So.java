package com.mx.entidad;

public class So {

	String nombre;
	String tipo;
	String version;

	public So() {

	}

	public So(String nombre) {
		this.nombre = nombre;
	}

	public So(String nombre, String tipo, String version) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.version = version;
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", tipo=" + tipo + ", version=" + version + "]\n";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
