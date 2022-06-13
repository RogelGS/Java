package com.mx.CRUDGalletas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDGalletas.dominio.Galleta;
import com.mx.CRUDGalletas.servicio.GalletaServicio;

@RestController
@RequestMapping("APIGALLETA")
@CrossOrigin
public class GalletaAPI {
	@Autowired
	GalletaServicio gs;
	
	@GetMapping("LISTAR")
	public List<Galleta> listar() {
		return gs.listar();
	}
	
	@PostMapping("GUARDAR")
	public void guardar(@RequestBody Galleta g) {
		gs.guardar(g);
	}
	
	@PostMapping("EDITAR")
	public void editar(@RequestBody Galleta g) {
		gs.editar(g);
	}
	
	@PostMapping("ELIMINAR")
	public void eliminar(@RequestBody Galleta g) {
		gs.eliminar(g);
	}
	
	@PostMapping("BUSCAR")
	public Galleta buscar(@RequestBody Galleta g) {
		return gs.buscar(g);
	}
	
	@PostMapping("BUSCARNOMBRE")
	public List<Galleta> buscarPorNombre(@RequestBody Galleta g) {
		return gs.findByNombreContaining(g);
	}
	
	@PostMapping("BUSCARMARCA")
	public List<Galleta> buscarPorMarca(@RequestBody Galleta g) {
		return gs.findByMarca(g);
	}
	
	@PostMapping("BUSCARPAIS")
	public List<Galleta> buscarPorPais(@RequestBody Galleta g) {
		return gs.findByPais(g);
	}
	
	@PostMapping("SEARCH")
	public List<Galleta> search(@RequestBody Galleta g) {
		return gs.search(g);
	}
}
