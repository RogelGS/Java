package com.mx.CRUDPelicula.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDPelicula.entity.Pelicula;
import com.mx.CRUDPelicula.servicio.PeliculaServicio;

@RestController
@RequestMapping("PELICULAAPI")
@CrossOrigin
public class PeliculaAPIWS {
	@Autowired
	PeliculaServicio ps;
	
	@GetMapping("listar")
	public List<Pelicula> listar() {
		return ps.listar();
	}
	
	@PostMapping("guardar")
	public void guardar(@RequestBody Pelicula pelicula) {
		ps.guardar(pelicula);
	}
	
	@PostMapping("editar")
	public void editar(@RequestBody Pelicula pelicula) {
		ps.editar(pelicula);
	}
	
	@PostMapping("eliminar")
	public void eliminar(@RequestBody Pelicula pelicula) {
		ps.eliminar(pelicula);
	}
	
	@PostMapping("buscar")
	public Pelicula buscar(@RequestBody Pelicula pelicula) {
		return ps.buscar(pelicula);
	}
}
