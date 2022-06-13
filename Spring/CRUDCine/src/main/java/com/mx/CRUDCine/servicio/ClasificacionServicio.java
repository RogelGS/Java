package com.mx.CRUDCine.servicio;

import java.util.List;

import com.mx.CRUDCine.dominio.Clasificacion;

public interface ClasificacionServicio {
	public void guardar(Clasificacion clasificacion);
	public void editar(Clasificacion clasificacion);
	public void eliminar(Clasificacion clasificacion);

	public Clasificacion buscar(Clasificacion clasificacion);
	public List<Clasificacion> listar();
}
