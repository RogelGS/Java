package com.mx.CRUDPadreHijo.dominio;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APIHIJO")
public class Hijo {
	@Id
	int id;
	String nombre;
	String app;
	String apm;
	String hobby;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PADRE")
	Padre padre;
	
	public Hijo() {}

	public Hijo(int id, String nombre, String app, String apm, String hobby, Padre padre) {
		this.id = id;
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.hobby = hobby;
		this.padre = padre;
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

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Padre getPadre() {
		return padre;
	}

	public void setPadre(Padre padre) {
		this.padre = padre;
	}

	@Override
	public String toString() {
		return "Hijo [id=" + id + ", nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", hobby=" + hobby
				+ ", padre=" + padre + "]\n";
	}
	
	
}
