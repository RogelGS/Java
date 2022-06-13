package com.mx.CRUDVideojuegos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDVideojuegos.dominio.Videojuego;
import com.mx.CRUDVideojuegos.servicio.VideojuegoServicio;

@RestController
@RequestMapping("APIVIDEOJUEGO")
@CrossOrigin
public class VideojuegoAPI {
	@Autowired
	VideojuegoServicio vs;
	
	@GetMapping("LISTAR")
	public List<Videojuego> listar() {
		return vs.listar();
	}
	
	@PostMapping("GUARDAR")
	public void guardar(@RequestBody Videojuego v) {
		vs.guardar(v);
	}
	
	@PostMapping("EDITAR")
	public void editar(@RequestBody Videojuego v) {
		vs.editar(v);
	}
	
	@PostMapping("ELIMINAR")
	public void eliminar(@RequestBody Videojuego v) {
		vs.eliminar(v);
	}
	
	@PostMapping("BUSCAR")
	public Videojuego buscar(@RequestBody Videojuego v) {
		return vs.buscar(v);
	}
	
	@GetMapping("CONTAR")
	public long contar() {
		return vs.count();
	}
	
	@PostMapping("SEARCH")
	public List<Videojuego> search(@RequestBody Videojuego v) {
		return vs.search(v);
	}
}
