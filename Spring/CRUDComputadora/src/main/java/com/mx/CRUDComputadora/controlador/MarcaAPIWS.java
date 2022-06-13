package com.mx.CRUDComputadora.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDComputadora.dominio.Marca;
import com.mx.CRUDComputadora.servicio.MarcaServicio;

@RestController
@RequestMapping("MARCAAPI")
@CrossOrigin
public class MarcaAPIWS {
	@Autowired
	MarcaServicio ms;
	
	@GetMapping("listar")
	public List<Marca> listar() {
		return ms.listar();
	}
	
	@PostMapping("guardar")
	public void guardar(@RequestBody Marca marca) {
		ms.guardar(marca);
	}
	
	@PostMapping("editar")
	public void editar(@RequestBody Marca marca) {
		ms.editar(marca);
	}
	
	@PostMapping("eliminar")
	public void eliminar(@RequestBody Marca marca) {
		ms.eliminar(marca);
	}
	
	@PostMapping("buscar")
	public Marca buscar(@RequestBody Marca marca) {
		return ms.buscar(marca);
	}
}
