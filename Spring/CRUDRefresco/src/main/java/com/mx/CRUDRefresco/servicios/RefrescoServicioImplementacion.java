package com.mx.CRUDRefresco.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CRUDRefresco.dao.RefrescoDao;
import com.mx.CRUDRefresco.entity.Refresco;

@Service
public class RefrescoServicioImplementacion implements RefrescoServicio {
	@Autowired
	RefrescoDao rd;
	
	@Override
	public void guardar(Refresco refresco) {
		rd.save(refresco);
	}

	@Override
	public void editar(Refresco refresco) {
		rd.save(refresco);
	}

	@Override
	public void eliminar(Refresco refresco) {
		rd.delete(refresco);
	}

	@Override
	public Refresco buscar(Refresco refresco) {
		return rd.findById(refresco.getId()).orElse(null);
	}

	@Override
	public List<Refresco> listar() {
		return (List<Refresco>) rd.findAll();
	}

}
