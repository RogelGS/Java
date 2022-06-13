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
import com.mx.CRUDSeries.Entity.Serie;
import com.mx.CRUDSeries.Service.SerieService;

@RestController
@RequestMapping(value = "apiserie")
@CrossOrigin
public class SerieAPI {
	@Autowired
	SerieService ss;
	
	@GetMapping(value = "listar")
	public List<Serie> listar() {
		return ss.listar();
	}
	
	@PostMapping(value = "guardar")
	public void guardar(@RequestBody Serie s) {
		ss.guardar(s);
	}
	
	@PostMapping(value = "editar")
	public void editar(@RequestBody Serie s) {
		ss.editar(s);
	}
	
	@PostMapping(value = "eliminar")
	public void eliminar(@RequestBody Serie s) {
		ss.eliminar(s);
	}
	
	@PostMapping(value = "buscar")
	public Serie buscar(@RequestBody Serie s) {
		return ss.buscar(s);
	}
	
	@PostMapping(value = "buscarNombre")
	public List<Serie> buscarNombre(@RequestBody Serie s) {
		return ss.buscarNombre(s);
	}
	
	@PostMapping(value = "buscarGenero")
	public List<Serie> buscarGenero(@RequestBody Genero g) {
		return ss.buscarGenero(g);
	}
}
