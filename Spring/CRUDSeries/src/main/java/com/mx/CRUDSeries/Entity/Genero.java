package com.mx.CRUDSeries.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "API_GENERO")
@Data
public class Genero {
	@Id
	private int id;
	private String nombre;
	private String descripcion;
}
