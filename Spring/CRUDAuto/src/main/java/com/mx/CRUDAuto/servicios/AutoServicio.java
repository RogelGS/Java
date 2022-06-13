package com.mx.CRUDAuto.servicios;

import java.util.List;

import com.mx.CRUDAuto.entidad.Auto;

public interface AutoServicio {
	public void guardar(Auto auto);
	public void editar(Auto auto);
	public void eliminar(Auto auto);

	public Auto buscar(Auto auto);
	public List<Auto> listar();
}
