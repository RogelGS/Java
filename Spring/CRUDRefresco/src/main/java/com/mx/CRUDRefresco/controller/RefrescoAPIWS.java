package com.mx.CRUDRefresco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDRefresco.entity.Refresco;
import com.mx.CRUDRefresco.servicios.RefrescoServicio;

@RestController
@RequestMapping("APIREFRESCO")
@CrossOrigin
public class RefrescoAPIWS {
	@Autowired
	RefrescoServicio rs;
	
	@GetMapping("listar")
	public List<Refresco> listar() {
		return rs.listar();
	}
	
	@PostMapping("guardar")
	public void guardar(@RequestBody Refresco refresco) {
		rs.guardar(refresco);
	}
	
	@PostMapping("editar")
	public void editar(@RequestBody Refresco refresco) {
		rs.editar(refresco);
	}
	
	@PostMapping("eliminar")
	public void eliminar(@RequestBody Refresco refresco) {
		rs.eliminar(refresco);
	}
	
	@PostMapping("buscar")
	public Refresco buscar(@RequestBody Refresco refresco) {
		return rs.buscar(refresco);
	}
}
