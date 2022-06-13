package com.mx.CRUDPelicula.servicio;

import java.util.List;

import com.mx.CRUDPelicula.entity.Pelicula;

public interface PeliculaServicio {
	public void guardar(Pelicula pelicula);
	public void editar(Pelicula pelicula);
	public void eliminar(Pelicula pelicula);

	public Pelicula buscar(Pelicula pelicula);
	public List<Pelicula> listar();
}
