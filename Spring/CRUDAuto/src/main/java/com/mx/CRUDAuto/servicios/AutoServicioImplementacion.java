package com.mx.CRUDAuto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CRUDAuto.dao.AutoDao;
import com.mx.CRUDAuto.entidad.Auto;

@Service
public class AutoServicioImplementacion implements AutoServicio {
	@Autowired
	AutoDao ad;

	@Override
	public void guardar(Auto auto) {
		ad.save(auto);
	}

	@Override
	public void editar(Auto auto) {
		ad.save(auto);
	}

	@Override
	public void eliminar(Auto auto) {
		ad.delete(auto);
	}

	@Override
	public Auto buscar(Auto auto) {
		return ad.findById(auto.getId()).orElse(null);
	}

	@Override
	public List<Auto> listar() {
		return (List<Auto>) ad.findAll();
	}

}
