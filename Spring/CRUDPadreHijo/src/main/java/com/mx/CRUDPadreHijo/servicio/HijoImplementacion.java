package com.mx.CRUDPadreHijo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CRUDPadreHijo.dao.HijoDao;
import com.mx.CRUDPadreHijo.dominio.Hijo;

@Service
public class HijoImplementacion implements HijoServicio{
	@Autowired
	HijoDao hd;
	
	@Transactional
	@Override
	public void guardar(Hijo hijo) {
		hd.save(hijo);
	}

	@Transactional
	@Override
	public void editar(Hijo hijo) {
		hd.save(hijo);
	}

	@Transactional
	@Override
	public void eliminar(Hijo hijo) {
		hd.delete(hijo);
	}

	@Transactional(readOnly = true)
	@Override
	public Hijo buscar(Hijo hijo) {
		return hd.findById(hijo.getId()).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Hijo> listar() {
		return hd.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Hijo> buscarPorApp(Hijo hijo) {
		return hd.findByApp(hijo.getApp());
	}

	@Transactional(readOnly = true)
	@Override
	public List<Hijo> buscarPorPadre(Hijo hijo) {
		return hd.findByPadre(hijo.getPadre());
	}

	@Transactional(readOnly = true)
	@Override
	public List<Hijo> buscarPorNombreContiene(Hijo hijo) {
		return hd.findByNombreContaining(hijo.getNombre());
	}

	@Override
	public List<Hijo> findByNombreLike(Hijo hijo) {
		return hd.findByNombreLike("%"+hijo.getNombre()+"%");
	}

}
