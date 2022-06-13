package com.mx.CRUDAuto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDAuto.entidad.Auto;
import com.mx.CRUDAuto.servicios.AutoServicio;

@RestController
@RequestMapping("APIAUTO")
@CrossOrigin
public class AutoAPIWS {
	@Autowired
	AutoServicio as;
	
	@GetMapping("listar")
	public List<Auto> listar() {
		return as.listar();
	}
	
	@PostMapping("guardar")
	public void guardar(@RequestBody Auto auto) {
		as.guardar(auto);
	}
	
	@PostMapping("editar")
	public void editar(@RequestBody Auto auto) {
		as.editar(auto);
	}
	
	@PostMapping("eliminar")
	public void eliminar(@RequestBody Auto auto) {
		as.eliminar(auto);
	}
	
	@PostMapping("buscar")
	public Auto buscar(@RequestBody Auto auto) {
		return as.buscar(auto);
	}
}
