package com.mx.CRUDGalletas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CRUDGalletas.dao.MarcaDao;
import com.mx.CRUDGalletas.dominio.Marca;

@Service
public class MarcaImplementacion implements MarcaServicio{
	@Autowired
	MarcaDao md;
	
	@Transactional
	@Override
	public void guardar(Marca m) {
		md.save(m);
	}

	@Transactional
	@Override
	public void editar(Marca m) {
		md.save(m);
	}

	@Transactional
	@Override
	public void eliminar(Marca m) {
		md.delete(m);
	}

	@Transactional(readOnly = true)
	@Override
	public Marca buscar(Marca m) {
		return md.findById(m.getId()).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Marca> listar() {
		return md.findAll();
	}

}
