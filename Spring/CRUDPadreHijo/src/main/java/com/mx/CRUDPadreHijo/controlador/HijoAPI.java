package com.mx.CRUDPadreHijo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDPadreHijo.dominio.Hijo;
import com.mx.CRUDPadreHijo.servicio.HijoServicio;

@RestController
@RequestMapping("APIHIJO")
@CrossOrigin
public class HijoAPI {
	@Autowired
	HijoServicio hs;
	
	@GetMapping("LISTAR")
	public List<Hijo> listar() {
		return hs.listar();
	}
	
	@PostMapping("GUARDAR")
	public void guardar(@RequestBody Hijo h) {
		hs.guardar(h);
	}
	
	@PostMapping("EDITAR")
	public void editar(@RequestBody Hijo h) {
		hs.editar(h);
	}
	
	@PostMapping("ELIMINAR")
	public void eliminar(@RequestBody Hijo h) {
		hs.eliminar(h);
	}
	
	@PostMapping("BUSCAR")
	public Hijo buscar(@RequestBody Hijo h) {
		return hs.buscar(h);
	}
	
	@PostMapping("BUSCARAPP")
	public List<Hijo> buscarPorApp(@RequestBody Hijo h) {
		return hs.buscarPorApp(h);
	}
	
	@PostMapping("BUSCARPADRE")
	public List<Hijo> buscarPorPadre(@RequestBody Hijo h) {
		return hs.buscarPorPadre(h);
	}
	
	@PostMapping("BUSCARNOMBRE")
	public List<Hijo> buscarPorNombreContiene(@RequestBody Hijo h) {
		return hs.buscarPorNombreContiene(h);
	}
}
