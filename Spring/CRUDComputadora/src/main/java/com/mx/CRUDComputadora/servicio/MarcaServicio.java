package com.mx.CRUDComputadora.servicio;

import java.util.List;

import com.mx.CRUDComputadora.dominio.Marca;

public interface MarcaServicio {
	public void guardar(Marca marca);
	public void editar(Marca marca);
	public void eliminar(Marca marca);

	public Marca buscar(Marca marca);
	public List<Marca> listar();
}
