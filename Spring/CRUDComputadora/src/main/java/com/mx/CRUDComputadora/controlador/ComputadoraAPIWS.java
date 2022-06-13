package com.mx.CRUDComputadora.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDComputadora.dominio.Computadora;
import com.mx.CRUDComputadora.servicio.ComputadoraServicio;

@RestController
@RequestMapping("COMPUTADORAAPI")
@CrossOrigin
public class ComputadoraAPIWS {
	@Autowired
	ComputadoraServicio cs;
	
	@GetMapping("listar")
	public List<Computadora> listar() {
		return cs.listar();
	}
	
	@PostMapping("guardar")
	public void guardar(@RequestBody Computadora computadora) {
		cs.guardar(computadora);
	}
	
	@PostMapping("editar")
	public void editar(@RequestBody Computadora computadora) {
		cs.editar(computadora);
	}
	
	@PostMapping("eliminar")
	public void eliminar(@RequestBody Computadora computadora) {
		cs.eliminar(computadora);
	}
	
	@PostMapping("buscar")
	public Computadora buscar(@RequestBody Computadora computadora) {
		return cs.buscar(computadora);
	}
}
