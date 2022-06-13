package com.mx.CRUDCine.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDCine.dominio.Genero;
import com.mx.CRUDCine.servicio.GeneroServicio;

@RestController
@RequestMapping("APIGENERO")
@CrossOrigin
public class GeneroAPI {
	@Autowired
	GeneroServicio gs;
	
	@GetMapping("LISTAR")
	public List<Genero> listar() {
		return gs.listar();
	}
	
	@PostMapping("GUARDAR")
	public void guardar(@RequestBody Genero genero) {
		gs.guardar(genero);
	}
	
	@PostMapping("EDITAR")
	public void editar(@RequestBody Genero genero) {
		gs.editar(genero);
	}
	
	@PostMapping("ELIMINAR")
	public void eliminar(@RequestBody Genero genero) {
		gs.eliminar(genero);
	}
	
	@PostMapping("BUSCAR")
	public Genero buscar(@RequestBody Genero genero) {
		return gs.buscar(genero);
	}
}
