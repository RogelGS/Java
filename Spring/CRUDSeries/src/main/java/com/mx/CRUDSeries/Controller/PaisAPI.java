package com.mx.CRUDSeries.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDSeries.Entity.Pais;
import com.mx.CRUDSeries.Service.PaisService;

@RestController
@RequestMapping(value = "apipais")
@CrossOrigin
public class PaisAPI {
	@Autowired
	PaisService ps;
	
	@GetMapping(value = "listar")
	public List<Pais> listar() {
		return ps.listar();
	}
	
	@PostMapping(value = "guardar")
	public void guardar(@RequestBody Pais p) {
		ps.guardar(p);
	}
	
	@PostMapping(value = "editar")
	public void editar(@RequestBody Pais p) {
		ps.editar(p);
	}
	
	@PostMapping(value = "eliminar")
	public void eliminar(@RequestBody Pais p) {
		ps.eliminar(p);
	}
	
	@PostMapping(value = "buscar")
	public Pais buscar(@RequestBody Pais p) {
		return ps.buscar(p);
	}
	
	@PostMapping(value = "buscarNombre")
	public List<Pais> buscarNombre(@RequestBody Pais p) {
		return ps.buscarNombre(p);
	}
}
