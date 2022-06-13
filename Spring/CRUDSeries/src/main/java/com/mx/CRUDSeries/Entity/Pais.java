package com.mx.CRUDSeries.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "API_PAIS")
@Data
public class Pais {
	@Id
	private int id;
	private String nombre;
	private int continente;
}
