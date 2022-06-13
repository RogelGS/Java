package com.mx.CRUDComputadora.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CRUDComputadora.dao.MarcaDao;
import com.mx.CRUDComputadora.dominio.Marca;

@Service
public class MarcaServicioImplementacion implements MarcaServicio {
	@Autowired
	MarcaDao md;
	
	@Override
	public void guardar(Marca marca) {
		md.save(marca);
	}

	@Override
	public void editar(Marca marca) {
		md.save(marca);
	}

	@Override
	public void eliminar(Marca marca) {
		md.delete(marca);
	}

	@Override
	public Marca buscar(Marca marca) {
		return md.findById(marca.getId()).orElse(null);
	}

	@Override
	public List<Marca> listar() {
		return (List<Marca>) md.findAll();
	}

}
