package com.mx.CRUDSeries.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "API_SERIE")
@Data
public class Serie {
	@Id
	private int id;
	private String nombre;
	private int capitulos;
	private int temporadas;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_GENERO")
	private Genero genero;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PAIS")
	private Pais pais;
}
