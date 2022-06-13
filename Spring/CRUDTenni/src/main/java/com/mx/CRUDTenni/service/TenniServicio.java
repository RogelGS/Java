package com.mx.CRUDTenni.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mx.CRUDTenni.entity.Tenni;

@Repository
public interface TenniServicio {
	public void guardar(Tenni t);
	public void editar(Tenni t);
	public void eliminar(Tenni t);
	public Tenni buscar(Tenni t);
	public List<Tenni> listar();
	
	public List<Tenni> search(Tenni t);
}
