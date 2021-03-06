package com.mx.CRUDVegetales.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CRUDVegetales.dao.VegetalDao;
import com.mx.CRUDVegetales.dominio.Vegetal;

@Service
public class VegetalImplementacion implements VegetalServicio{
	@Autowired
	VegetalDao vd;
	
	@Override
	public void guardar(Vegetal v) {
		vd.save(v);
	}

	@Override
	public void editar(Vegetal v) {
		vd.save(v);
	}

	@Override
	public void eliminar(Vegetal v) {
		vd.delete(v);
	}

	@Override
	public Vegetal buscar(Vegetal v) {
		return vd.findById(v.getId()).orElse(null);
	}

	@Override
	public List<Vegetal> listar() {
		return vd.findAll();
	}

	@Override
	public long count() {
		return vd.count();
	}

	@Override
	public List<Vegetal> search(Vegetal v) {
		return vd.search(v.getNombre());
	}

}
