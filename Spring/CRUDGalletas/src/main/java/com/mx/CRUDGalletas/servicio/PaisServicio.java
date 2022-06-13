package com.mx.CRUDGalletas.servicio;

import java.util.List;

import com.mx.CRUDGalletas.dominio.Pais;

public interface PaisServicio {
	public void guardar(Pais p);
	public void editar(Pais p);
	public void eliminar(Pais p);
	public Pais buscar(Pais p);
	public List<Pais> listar();
}
