package com.mx.CRUDSeries.Service;

import java.util.List;

import com.mx.CRUDSeries.Entity.Genero;
import com.mx.CRUDSeries.Entity.Serie;

public interface SerieService {
	public void guardar(Serie s);
	public void editar(Serie s);
	public void eliminar(Serie s);
	public Serie buscar(Serie s);
	public List<Serie> listar();
	public List<Serie> buscarNombre(Serie s);
	public List<Serie> buscarGenero(Genero g);
}
