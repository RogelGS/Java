package com.mx.CRUDVideojuegos.servicio;

import java.util.List;

import com.mx.CRUDVideojuegos.dominio.Videojuego;

public interface VideojuegoServicio {
	public void guardar(Videojuego v);
	public void editar(Videojuego v);
	public void eliminar(Videojuego v);
	public Videojuego buscar(Videojuego v);
	public List<Videojuego> listar();
	
	public long count();
	
	public List<Videojuego> search(Videojuego v);
}
