package com.mx.CRUDComputadora.servicio;

import java.util.List;

import com.mx.CRUDComputadora.dominio.Computadora;


public interface ComputadoraServicio {
	public void guardar(Computadora computadora);
	public void editar(Computadora computadora);
	public void eliminar(Computadora computadora);

	public Computadora buscar(Computadora computadora);
	public List<Computadora> listar();
}
