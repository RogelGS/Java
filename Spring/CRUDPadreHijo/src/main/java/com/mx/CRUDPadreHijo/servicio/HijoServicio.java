package com.mx.CRUDPadreHijo.servicio;

import java.util.List;

import com.mx.CRUDPadreHijo.dominio.Hijo;

public interface HijoServicio {
	public void guardar(Hijo hijo);
	public void editar(Hijo hijo);
	public void eliminar(Hijo hijo);

	public Hijo buscar(Hijo hijo);
	public List<Hijo> listar();
	
	public List<Hijo> buscarPorApp(Hijo hijo);
	public List<Hijo> buscarPorPadre(Hijo hijo);
	public List<Hijo> buscarPorNombreContiene(Hijo hijo);
	
	public List<Hijo> findByNombreLike(Hijo hijo);
}
