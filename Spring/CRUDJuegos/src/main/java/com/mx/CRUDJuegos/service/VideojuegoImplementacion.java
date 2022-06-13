package com.mx.CRUDJuegos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CRUDJuegos.dao.VideojuegoDao;
import com.mx.CRUDJuegos.entity.Videojuego;

@Service
public class VideojuegoImplementacion implements VideojuegoServicio {
	@Autowired
	VideojuegoDao vd;
	
	@Override
	public void guardar(Videojuego v) {
		vd.save(v);
	}

	@Override
	public void editar(Videojuego v) {
		vd.save(v);
	}

	@Override
	public void eliminar(Videojuego v) {
		vd.delete(v);
	}

	@Override
	public Videojuego buscar(Videojuego v) {
		return vd.findById(v.getId()).orElse(null);
	}

	@Override
	public List<Videojuego> listar() {
		return vd.findAll();
	}

	@Override
	public long count() {
		return vd.count();
	}

	@Override
	public List<Videojuego> search(Videojuego v) {
		return vd.search(v.getNombre());
	}

}
