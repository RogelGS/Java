package com.mx.CRUDGalletas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CRUDGalletas.dao.PaisDao;
import com.mx.CRUDGalletas.dominio.Pais;

@Service
public class PaisImplementacion implements PaisServicio{
	@Autowired
	PaisDao pd;
	
	@Transactional
	@Override
	public void guardar(Pais p) {
		pd.save(p);
	}

	@Transactional
	@Override
	public void editar(Pais p) {
		pd.save(p);
	}

	@Transactional
	@Override
	public void eliminar(Pais p) {
		pd.delete(p);
	}

	@Transactional(readOnly = true)
	@Override
	public Pais buscar(Pais p) {
		return pd.findById(p.getId()).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Pais> listar() {
		return pd.findAll();
	}

}
