package com.mx.CRUDVegetales.servicio;

import java.util.List;

import com.mx.CRUDVegetales.dominio.Vegetal;

public interface VegetalServicio {
	public void guardar(Vegetal v);
	public void editar(Vegetal v);
	public void eliminar(Vegetal v);
	public Vegetal buscar(Vegetal v);
	public List<Vegetal> listar();
	
	public long count();
	
	public List<Vegetal> search(Vegetal v);
}
