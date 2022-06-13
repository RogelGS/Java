package com.mx.CRUDTenni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CRUDTenni.dao.TenniDao;
import com.mx.CRUDTenni.entity.Tenni;

@Service
public class TenniImplementacion implements TenniServicio {
	@Autowired
	TenniDao td;
	
	@Transactional
	@Override
	public void guardar(Tenni t) {
		td.save(t);
	}

	@Transactional
	@Override
	public void editar(Tenni t) {
		td.save(t);
	}

	@Transactional
	@Override
	public void eliminar(Tenni t) {
		td.delete(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Tenni buscar(Tenni t) {
		return td.findById(t.getId()).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Tenni> listar() {
		return td.findAll();
	}

	@Override
	public List<Tenni> search(Tenni t) {
		return td.search(t.getModelo().toUpperCase());
	}
	
}
