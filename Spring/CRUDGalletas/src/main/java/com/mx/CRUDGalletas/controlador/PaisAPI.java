package com.mx.CRUDGalletas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDGalletas.dominio.Pais;
import com.mx.CRUDGalletas.servicio.PaisServicio;

@RestController
@RequestMapping("APIPAIS")
@CrossOrigin
public class PaisAPI {
	@Autowired
	PaisServicio ps;
	
	@GetMapping("LISTAR")
	public List<Pais> listar() {
		return ps.listar();
	}
	
	@PostMapping("GUARDAR")
	public void guardar(@RequestBody Pais p) {
		ps.guardar(p);
	}
	
	@PostMapping("EDITAR")
	public void editar(@RequestBody Pais p) {
		ps.editar(p);
	}
	
	@PostMapping("ELIMINAR")
	public void eliminar(@RequestBody Pais p) {
		ps.eliminar(p);
	}
	
	@PostMapping("BUSCAR")
	public Pais buscar(@RequestBody Pais p) {
		return ps.buscar(p);
	}
}
