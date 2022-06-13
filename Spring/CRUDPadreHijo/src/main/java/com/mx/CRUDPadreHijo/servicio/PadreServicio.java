package com.mx.CRUDPadreHijo.servicio;

import java.util.List;

import com.mx.CRUDPadreHijo.dominio.Padre;

public interface PadreServicio {
	public void guardar(Padre padre);
	public void editar(Padre padre);
	public void eliminar(Padre padre);

	public Padre buscar(Padre padre);
	public List<Padre> listar();
}
