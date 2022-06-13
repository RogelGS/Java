package com.mx.CRUDGym.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CRUDGym.dao.GymDao;
import com.mx.CRUDGym.dominio.Gym;

@Service
public class GymImplementacion implements GymServicio {
	@Autowired
	GymDao gd;
	
	@Transactional
	@Override
	public void guardar(Gym g) {
		gd.save(g);
	}

	@Transactional
	@Override
	public void editar(Gym g) {
		gd.save(g);
	}

	@Transactional
	@Override
	public void eliminar(Gym g) {
		gd.delete(g);
	}

	@Transactional(readOnly = true)
	@Override
	public Gym buscar(Gym g) {
		return gd.findById(g.getId()).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Gym> listar() {
		return gd.findAll();
	}

}
