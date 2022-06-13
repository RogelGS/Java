package com.mx.CRUDPelicula.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CRUDPelicula.dao.PeliculaDao;
import com.mx.CRUDPelicula.entity.Pelicula;

@Service
public class PeliculaServicioImplementacion implements PeliculaServicio {
	@Autowired
	PeliculaDao pd;

	@Override
	public void guardar(Pelicula pelicula) {
		pd.save(pelicula);
	}

	@Override
	public void editar(Pelicula pelicula) {
		pd.save(pelicula);
	}

	@Override
	public void eliminar(Pelicula pelicula) {
		pd.delete(pelicula);
	}

	@Override
	public Pelicula buscar(Pelicula pelicula) {
		return pd.findById(pelicula.getId()).orElse(null);
	}

	@Override
	public List<Pelicula> listar() {
		return (List<Pelicula>) pd.findAll();
	}
	
	
}
