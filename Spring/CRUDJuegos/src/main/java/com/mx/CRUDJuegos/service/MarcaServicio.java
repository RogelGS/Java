package com.mx.CRUDJuegos.service;

import java.util.List;

import com.mx.CRUDJuegos.entity.Marca;

public interface MarcaServicio {
	public void guardar(Marca m);
	public void editar(Marca m);
	public void eliminar(Marca m);
	public Marca buscar(Marca m);
	public List<Marca> listar();
	
	public long count();
	public List<Marca> search(Marca m);
}
