package com.mx.CRUDTenni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDTenni.entity.Tenni;
import com.mx.CRUDTenni.service.TenniServicio;

@RestController
@RequestMapping("APITENNI")
@CrossOrigin
public class TenniAPI {
	@Autowired
	TenniServicio ts;
	
	@GetMapping("LISTAR")
	public List<Tenni> listar() {
		return ts.listar();
	}
	
	@PostMapping("GUARDAR")
	public void guardar(@RequestBody Tenni t) {
		ts.guardar(t);
	}
	
	@PostMapping("EDITAR")
	public void editar(@RequestBody Tenni t) {
		ts.editar(t);
	}
	
	@PostMapping("ELIMINAR")
	public void eliminar(@RequestBody Tenni t) {
		ts.eliminar(t);
	}
	
	@PostMapping("BUSCAR")
	public Tenni buscar(@RequestBody Tenni t) {
		return ts.buscar(t);
	}
	
	@PostMapping("SEARCH")
	public List<Tenni> search(@RequestBody Tenni t) {
		return ts.search(t);
	}
	
}
