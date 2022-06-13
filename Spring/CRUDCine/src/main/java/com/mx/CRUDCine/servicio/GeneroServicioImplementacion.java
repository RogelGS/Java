package com.mx.CRUDCine.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CRUDCine.dao.GeneroDao;
import com.mx.CRUDCine.dominio.Genero;

@Service
public class GeneroServicioImplementacion implements GeneroServicio {
	@Autowired
	GeneroDao gd;
	
	@Override
	public void guardar(Genero genero) {
		gd.save(genero);
	}

	@Override
	public void editar(Genero genero) {
		gd.save(genero);
	}

	@Override
	public void eliminar(Genero genero) {
		gd.delete(genero);
	}

	@Override
	public Genero buscar(Genero genero) {
		return gd.findById(genero.getId()).orElse(null);
	}

	@Override
	public List<Genero> listar() {
		return (List<Genero>) gd.findAll();
	}

}
