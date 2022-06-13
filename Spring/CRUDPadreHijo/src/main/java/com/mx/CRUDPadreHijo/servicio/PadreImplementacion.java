package com.mx.CRUDPadreHijo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CRUDPadreHijo.dao.PadreDao;
import com.mx.CRUDPadreHijo.dominio.Padre;

@Service
public class PadreImplementacion implements PadreServicio{
	@Autowired
	PadreDao pd;
	
	@Transactional
	@Override
	public void guardar(Padre padre) {
		pd.save(padre);
	}

	@Transactional
	@Override
	public void editar(Padre padre) {
		pd.save(padre);
	}

	@Transactional
	@Override
	public void eliminar(Padre padre) {
		pd.delete(padre);
	}

	@Transactional(readOnly = true)
	@Override
	public Padre buscar(Padre padre) {
		return pd.findById(padre.getId()).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Padre> listar() {
		return pd.findAll();
	}

}
