package com.mx.CRUDSeries.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CRUDSeries.Entity.Genero;
import com.mx.CRUDSeries.Repository.GeneroRepository;

@Service
public class GeneroImplement implements GeneroService {
	@Autowired
	GeneroRepository gr;
	
	@Transactional
	@Override
	public void guardar(Genero g) {
		gr.save(g);
	}

	@Transactional
	@Override
	public void editar(Genero g) {
		gr.save(g);
	}

	@Transactional
	@Override
	public void eliminar(Genero g) {
		gr.delete(g);
	}

	@Transactional(readOnly = true)
	@Override
	public Genero buscar(Genero g) {
		return gr.findById(g.getId()).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Genero> listar() {
		return gr.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Genero> buscarNombre(Genero g) {
		return gr.buscarNombre(g.getNombre().toUpperCase());
	}

}
