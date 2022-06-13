package com.mx.CRUDRefresco.servicios;

import java.util.List;

import com.mx.CRUDRefresco.entity.Refresco;

public interface RefrescoServicio {
	public void guardar(Refresco refresco);
	public void editar(Refresco refresco);
	public void eliminar(Refresco refresco);

	public Refresco buscar(Refresco refresco);
	public List<Refresco> listar();
}
