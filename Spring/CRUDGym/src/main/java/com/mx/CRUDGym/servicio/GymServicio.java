package com.mx.CRUDGym.servicio;

import java.util.List;

import com.mx.CRUDGym.dominio.Gym;

public interface GymServicio {
	public void guardar(Gym g);
	public void editar(Gym g);
	public void eliminar(Gym g);
	public Gym buscar(Gym g);
	public List<Gym> listar();
}
