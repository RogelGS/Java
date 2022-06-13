package com.mx.CRUDCine.servicio;

import java.util.List;

import com.mx.CRUDCine.dominio.Genero;

public interface GeneroServicio {
	public void guardar(Genero genero);
	public void editar(Genero genero);
	public void eliminar(Genero genero);

	public Genero buscar(Genero genero);
	public List<Genero> listar();
}
