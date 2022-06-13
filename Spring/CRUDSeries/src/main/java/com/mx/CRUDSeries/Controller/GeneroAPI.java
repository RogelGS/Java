package com.mx.CRUDSeries.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDSeries.Entity.Genero;
import com.mx.CRUDSeries.Service.GeneroService;

@RestController
@RequestMapping(value = "apigenero")
@CrossOrigin
public class GeneroAPI {
	@Autowired
	GeneroService gs;
	
	@GetMapping(value = "listar")
	public List<Genero> listar() {
		return gs.listar();
	}
	
	@PostMapping(value = "guardar")
	public void guardar(@RequestBody Genero g) {
		gs.guardar(g);
	}
	
	@PostMapping(value = "editar")
	public void editar(@RequestBody Genero g) {
		gs.editar(g);
	}
	
	
	@PostMapping(value = "eliminar")
	public void eliminar(@RequestBody Genero g) {
		gs.eliminar(g);
	}
	
	@PostMapping(value = "buscar")
	public Genero buscar(@RequestBody Genero g) {
		return gs.buscar(g);
	}
	
	@PostMapping(value = "buscarNombre")
	public List<Genero> buscarNombre(@RequestBody Genero g) {
		return gs.buscarNombre(g);
	}
}
