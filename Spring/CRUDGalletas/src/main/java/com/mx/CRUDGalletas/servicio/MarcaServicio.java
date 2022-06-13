package com.mx.CRUDGalletas.servicio;

import java.util.List;

import com.mx.CRUDGalletas.dominio.Marca;

public interface MarcaServicio {
	public void guardar(Marca m);
	public void editar(Marca m);
	public void eliminar(Marca m);
	public Marca buscar(Marca m);
	public List<Marca> listar();
}
