package com.mx.CRUDPokemon.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pokemon")
public class Pokemon {
	
	@Id
	@Column(name="ID", columnDefinition="NUMBER")
	
	int id;
	
	@Column(name="NOMBRE", columnDefinition="NVARCHAR2(100)")
	String nombre;
	
	@Column(name="PREEVOLUCION", columnDefinition="NVARCHAR2(100)")
	String preEvolucion;
	
	@Column(name="EVOLUCION", columnDefinition="NVARCHAR2(100)")
	String evolucion;
	
	@Column(name="TIPO", columnDefinition="NVARCHAR2(100)")
	String tipo;
	
	@Column(name="NIVELPODER", columnDefinition="NUMBER")
	double nivelPoder;
	
	public Pokemon() {}

	public Pokemon(int id, String nombre, String preEvolucion, String evolucion, String tipo, double nivelPoder) {
		this.id = id;
		this.nombre = nombre;
		this.preEvolucion = preEvolucion;
		this.evolucion = evolucion;
		this.tipo = tipo;
		this.nivelPoder = nivelPoder;
	}
	
	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nombre=" + nombre + ", preEvolucion=" + preEvolucion + ", evolucion="
				+ evolucion + ", tipo=" + tipo + ", nivelPoder=" + nivelPoder + "]\n";
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

	public String getPreEvolucion() {
		return preEvolucion;
	}

	public void setPreEvolucion(String preEvolucion) {
		this.preEvolucion = preEvolucion;
	}

	public String getEvolucion() {
		return evolucion;
	}

	public void setEvolucion(String evolucion) {
		this.evolucion = evolucion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getNivelPoder() {
		return nivelPoder;
	}

	public void setNivelPoder(double nivelPoder) {
		this.nivelPoder = nivelPoder;
	}
	
	
}
