package com.mx.CRUDCine.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CRUDCine.dao.ClasificacionDao;
import com.mx.CRUDCine.dominio.Clasificacion;

@Service
public class ClasificacionServicioImplementacion implements ClasificacionServicio{
	@Autowired
	ClasificacionDao cd;
	
	@Override
	public void guardar(Clasificacion clasificacion) {
		cd.save(clasificacion);
	}

	@Override
	public void editar(Clasificacion clasificacion) {
		cd.save(clasificacion);
	}

	@Override
	public void eliminar(Clasificacion clasificacion) {
		cd.delete(clasificacion);
	}

	@Override
	public Clasificacion buscar(Clasificacion clasificacion) {
		return cd.findById(clasificacion.getId()).orElse(null);
	}

	@Override
	public List<Clasificacion> listar() {
		return (List<Clasificacion>) cd.findAll();
	}

}
