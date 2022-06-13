package com.mx.CRUDSeries.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CRUDSeries.Entity.Genero;
import com.mx.CRUDSeries.Entity.Serie;
import com.mx.CRUDSeries.Repository.SerieRepository;

@Service
public class SerieImplement implements SerieService {
	@Autowired
	SerieRepository sr;
	
	@Transactional
	@Override
	public void guardar(Serie s) {
		sr.save(s);
	}

	@Transactional
	@Override
	public void editar(Serie s) {
		sr.save(s);
	}

	@Transactional
	@Override
	public void eliminar(Serie s) {
		sr.delete(s);
	}

	@Transactional(readOnly = true)
	@Override
	public Serie buscar(Serie s) {
		return sr.findById(s.getId()).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Serie> listar() {
		return sr.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Serie> buscarNombre(Serie s) {
		return sr.buscarNombre(s.getNombre().toUpperCase());
	}

	@Transactional(readOnly = true)
	@Override
	public List<Serie> buscarGenero(Genero g) {
		return sr.buscarGenero(g.getNombre().toUpperCase());
	}

}
