package com.mx.CRUDCine.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDCine.dominio.Clasificacion;
import com.mx.CRUDCine.servicio.ClasificacionServicio;

@RestController
@RequestMapping("APICLASIFICACION")
@CrossOrigin
public class ClasificacionAPI {
	@Autowired
	ClasificacionServicio cs;
	
	@GetMapping("LISTAR")
	public List<Clasificacion> listar() {
		return cs.listar();
	}
	
	@PostMapping("GUARDAR")
	public void guardar(@RequestBody Clasificacion clasificacion) {
		cs.guardar(clasificacion);
	}
	
	@PostMapping("EDITAR")
	public void editar(@RequestBody Clasificacion clasificacion) {
		cs.editar(clasificacion);
	}
	
	@PostMapping("ELIMINAR")
	public void eliminar(@RequestBody Clasificacion clasificacion) {
		cs.eliminar(clasificacion);
	}
	
	@PostMapping("BUSCAR")
	public Clasificacion buscar(@RequestBody Clasificacion clasificacion) {
		return cs.buscar(clasificacion);
	}
}
