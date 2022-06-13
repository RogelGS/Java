package com.mx.CRUDVegetales.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDVegetales.dominio.Vegetal;
import com.mx.CRUDVegetales.servicio.VegetalServicio;

@RestController
@RequestMapping("APIVEGETAL")
@CrossOrigin
public class VegetalAPI {
	@Autowired
	VegetalServicio vs;
	
	@GetMapping("LISTAR")
	public List<Vegetal> listar() {
		return vs.listar();
	}
	
	@PostMapping("GUARDAR")
	public void guardar(@RequestBody Vegetal v) {
		vs.guardar(v);
	}
	
	@PostMapping("EDITAR")
	public void editar(@RequestBody Vegetal v) {
		vs.editar(v);
	}
	
	@PostMapping("ELIMINAR")
	public void eliminar(@RequestBody Vegetal v) {
		vs.eliminar(v);
	}
	
	@PostMapping("BUSCAR")
	public Vegetal buscar(@RequestBody Vegetal v) {
		return vs.buscar(v);
	}
	
	@GetMapping("CONTAR")
	public long contar() {
		return vs.count();
	}
	
	@PostMapping("SEARCH")
	public List<Vegetal> search(@RequestBody Vegetal v) {
		return vs.search(v);
	}
}
