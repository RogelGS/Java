package com.mx.CRUDJuegos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDJuegos.entity.Marca;
import com.mx.CRUDJuegos.service.MarcaServicio;

@RestController
@RequestMapping("APIMARCA")
@CrossOrigin
public class MarcaAPI {
	@Autowired
	MarcaServicio ms;
	
	@GetMapping("LISTAR")
	public List<Marca> listar() {
		return ms.listar();
	}
	
	@PostMapping("GUARDAR")
	public void guardar(@RequestBody Marca m) {
		ms.guardar(m);
	}
	
	@PostMapping("EDITAR")
	public void editar(@RequestBody Marca m) {
		ms.editar(m);
	}
	
	@PostMapping("ELIMINAR")
	public void eliminar(@RequestBody Marca m) {
		ms.eliminar(m);
	}
	
	@PostMapping("BUSCAR")
	public Marca buscar(@RequestBody Marca m) {
		return ms.buscar(m);
	}
	
	@GetMapping("CONTAR")
	public long contar() {
		return ms.count();
	}
	
	@PostMapping("SEARCH")
	public List<Marca> search(@RequestBody Marca m) {
		return ms.search(m);
	}
}
