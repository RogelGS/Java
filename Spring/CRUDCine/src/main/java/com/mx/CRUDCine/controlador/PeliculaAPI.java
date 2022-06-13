package com.mx.CRUDCine.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDCine.dominio.Pelicula;
import com.mx.CRUDCine.servicio.PeliculaServicio;

@RestController
@RequestMapping("APIPELICULA")
@CrossOrigin
public class PeliculaAPI {
	@Autowired
	PeliculaServicio ps;
	
	@GetMapping("LISTAR")
	public List<Pelicula> listar() {
		return ps.listar();
	}
	
	@PostMapping("GUARDAR")
	public void guardar(@RequestBody Pelicula pelicula) {
		ps.guardar(pelicula);
	}
	
	@PostMapping("EDITAR")
	public void editar(@RequestBody Pelicula pelicula) {
		ps.editar(pelicula);
	}
	
	@PostMapping("ELIMINAR")
	public void eliminar(@RequestBody Pelicula pelicula) {
		ps.eliminar(pelicula);
	}
	
	@PostMapping("BUSCAR")
	public Pelicula buscar(@RequestBody Pelicula pelicula) {
		return ps.buscar(pelicula);
	}
}
