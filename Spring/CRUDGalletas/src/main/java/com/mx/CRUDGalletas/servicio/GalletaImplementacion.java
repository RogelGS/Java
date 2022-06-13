package com.mx.CRUDGalletas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CRUDGalletas.dao.GalletaDao;
import com.mx.CRUDGalletas.dominio.Galleta;

@Service
public class GalletaImplementacion implements GalletaServicio{
	@Autowired
	GalletaDao gd;
	
	@Transactional
	@Override
	public void guardar(Galleta g) {
		gd.save(g);
	}

	@Transactional
	@Override
	public void editar(Galleta g) {
		gd.save(g);
	}

	@Transactional
	@Override
	public void eliminar(Galleta g) {
		gd.delete(g);
	}

	@Transactional(readOnly = true)
	@Override
	public Galleta buscar(Galleta g) {
		return gd.findById(g.getId()).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Galleta> listar() {
		return gd.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Galleta> findByNombreContaining(Galleta g) {
		System.out.println("Galleta a buscar ->" + g);
		return gd.findByNombreContaining(g.getNombre());
	}

	@Override
	public List<Galleta> findByMarca(Galleta g) {
		return gd.findByMarca(g.getMarca());
	}

	@Override
	public List<Galleta> findByPais(Galleta g) {
		return gd.findByPais(g.getPais());
	}

	@Override
	public List<Galleta> search(Galleta g) {
		return gd.search(g.getNombre());
	}
	
}
