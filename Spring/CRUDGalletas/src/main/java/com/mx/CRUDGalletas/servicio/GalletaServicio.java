package com.mx.CRUDGalletas.servicio;

import java.util.List;

import com.mx.CRUDGalletas.dominio.Galleta;

public interface GalletaServicio {
	public void guardar(Galleta g);
	public void editar(Galleta g);
	public void eliminar(Galleta g);
	public Galleta buscar(Galleta g);
	public List<Galleta> listar();
	
	public List<Galleta> findByNombreContaining(Galleta g);
	
	public List<Galleta> search(Galleta g);
	
	public List<Galleta> findByMarca(Galleta g);
	public List<Galleta> findByPais(Galleta g);
}
