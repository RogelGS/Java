package com.mx.CRUDSeries.Service;

import java.util.List;

import com.mx.CRUDSeries.Entity.Genero;

public interface GeneroService {
	public void guardar(Genero g);
	public void editar(Genero g);
	public void eliminar(Genero g);
	public Genero buscar(Genero g);
	public List<Genero> listar();
	public List<Genero> buscarNombre(Genero g);
}
