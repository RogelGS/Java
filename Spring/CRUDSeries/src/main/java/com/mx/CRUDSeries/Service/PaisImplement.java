package com.mx.CRUDSeries.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CRUDSeries.Entity.Pais;
import com.mx.CRUDSeries.Repository.PaisRepository;

@Service
public class PaisImplement implements PaisService {
	@Autowired
	PaisRepository pr;
	
	@Transactional
	@Override
	public void guardar(Pais p) {
		pr.save(p);
	}

	@Transactional
	@Override
	public void editar(Pais p) {
		pr.save(p);
	}

	@Transactional
	@Override
	public void eliminar(Pais p) {
		pr.delete(p);
	}

	@Transactional(readOnly = true)
	@Override
	public Pais buscar(Pais p) {
		return pr.findById(p.getId()).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Pais> listar() {
		return pr.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Pais> buscarNombre(Pais p) {
		return pr.buscarNombre(p.getNombre().toUpperCase());
	}
	
}
