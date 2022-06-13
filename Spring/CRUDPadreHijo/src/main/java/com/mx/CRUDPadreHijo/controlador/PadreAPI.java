package com.mx.CRUDPadreHijo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDPadreHijo.dominio.Padre;
import com.mx.CRUDPadreHijo.servicio.PadreServicio;

@RestController
@RequestMapping("APIPADRE")
@CrossOrigin
public class PadreAPI {
	@Autowired
	PadreServicio ps;
	
	@GetMapping("LISTAR")
	public List<Padre> listar() {
		return ps.listar();
	}
	
	@PostMapping("GUARDAR")
	public void guardar(@RequestBody Padre p) {
		ps.guardar(p);
	}
	
	@PostMapping("EDITAR")
	public void editar(@RequestBody Padre p) {
		ps.editar(p);
	}
	
	@PostMapping("ELIMINAR")
	public void eliminar(@RequestBody Padre p) {
		ps.eliminar(p);
	}
	
	@PostMapping("BUSCAR")
	public Padre buscar(@RequestBody Padre p) {
		return ps.buscar(p);
	}
}
