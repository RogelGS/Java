package com.mx.CRUDSeries.Service;

import java.util.List;

import com.mx.CRUDSeries.Entity.Pais;

public interface PaisService {
	public void guardar(Pais p);
	public void editar(Pais p);
	public void eliminar(Pais p);
	public Pais buscar(Pais p);
	public List<Pais> listar();
	public List<Pais> buscarNombre(Pais p);
}
