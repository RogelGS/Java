package com.mx.CRUDGym.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDGym.dominio.Gym;
import com.mx.CRUDGym.servicio.GymServicio;

@RestController
@RequestMapping("APIGYM")
@CrossOrigin
public class GymAPI {
	@Autowired
	GymServicio gs;
	
	@GetMapping("LISTAR")
	public List<Gym> listar() {
		return gs.listar();
	}
	
	@PostMapping("GUARDAR")
	public void guardar(@RequestBody Gym g) {
		gs.guardar(g);
	}
	
	@PostMapping("EDITAR")
	public void editar(@RequestBody Gym g) {
		gs.editar(g);
	}
	
	@PostMapping("ELIMINAR")
	public void eliminar(@RequestBody Gym g) {
		gs.eliminar(g);
	}
	
	@PostMapping("BUSCAR")
	public Gym buscar(@RequestBody Gym g) {
		return gs.buscar(g);
	}
}
