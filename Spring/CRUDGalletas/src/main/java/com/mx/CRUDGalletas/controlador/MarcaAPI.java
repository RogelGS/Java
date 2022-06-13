package com.mx.CRUDGalletas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDGalletas.dominio.Marca;
import com.mx.CRUDGalletas.servicio.MarcaServicio;

@RestController
@RequestMapping("APIMARCA")
@CrossOrigin
public class MarcaAPI {
	@Autowired
	MarcaServicio ms;
	
	@GetMapping("LISTAR")
	public List<Marca> listar() {
		return ms.listar();
	}
	
	@PostMapping("GUARDAR")
	public void guardar(@RequestBody Marca m) {
		ms.guardar(m);
	}
	
	@PostMapping("EDITAR")
	public void editar(@RequestBody Marca m) {
		ms.editar(m);
	}
	
	@PostMapping("ELIMINAR")
	public void eliminar(@RequestBody Marca m) {
		ms.eliminar(m);
	}
	
	@PostMapping("BUSCAR")
	public Marca buscar(@RequestBody Marca m) {
		return ms.buscar(m);
	}
}
