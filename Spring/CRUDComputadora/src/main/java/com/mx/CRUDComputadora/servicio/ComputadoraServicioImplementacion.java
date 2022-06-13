package com.mx.CRUDComputadora.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CRUDComputadora.dao.ComputadoraDao;
import com.mx.CRUDComputadora.dominio.Computadora;

@Service
public class ComputadoraServicioImplementacion implements ComputadoraServicio{
	@Autowired
	ComputadoraDao cd;
	
	@Override
	public void guardar(Computadora computadora) {
		cd.save(computadora);
	}

	@Override
	public void editar(Computadora computadora) {
		cd.save(computadora);
	}

	@Override
	public void eliminar(Computadora computadora) {
		cd.delete(computadora);
	}

	@Override
	public Computadora buscar(Computadora computadora) {
		return cd.findById(computadora.getId()).orElse(null);
	}

	@Override
	public List<Computadora> listar() {
		return (List<Computadora>) cd.findAll();
	}
	
}
