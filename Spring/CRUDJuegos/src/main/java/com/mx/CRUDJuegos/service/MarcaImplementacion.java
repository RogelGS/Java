package com.mx.CRUDJuegos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CRUDJuegos.dao.MarcaDao;
import com.mx.CRUDJuegos.entity.Marca;

@Service
public class MarcaImplementacion implements MarcaServicio {
	@Autowired
	MarcaDao md;
	
	@Override
	public void guardar(Marca m) {
		md.save(m);
	}

	@Override
	public void editar(Marca m) {
		md.save(m);
	}

	@Override
	public void eliminar(Marca m) {
		md.delete(m);
	}

	@Override
	public Marca buscar(Marca m) {
		return md.findById(m.getId()).orElse(null);
	}

	@Override
	public List<Marca> listar() {
		return md.findAll();
	}

	@Override
	public long count() {
		return md.count();
	}

	@Override
	public List<Marca> search(Marca m) {
		return md.search(m.getNombre());
	}

}
