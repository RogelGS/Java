package com.mx.CRUDPadreHijo.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APIPADRE")
public class Padre {
	@Id
	int id;
	String nombre;
	String app;
	String apm;
	Date fecha_nac;
	
	@OneToMany(mappedBy = "padre", cascade = CascadeType.ALL)
	List<Hijo> lista = new ArrayList<>();
	
	public Padre() {}

	public Padre(int id, String nombre, String app, String apm, Date fecha_nac) {
		this.id = id;
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.fecha_nac = fecha_nac;
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

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getApm() {
		return apm;
	}

	public void setApm(String apm) {
		this.apm = apm;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	@Override
	public String toString() {
		return "Padre [id=" + id + ", nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", fecha_nac=" + fecha_nac
				+ "]\n";
	}
	
	
}
