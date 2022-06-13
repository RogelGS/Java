package com.mx.CRUDSeries.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mx.CRUDSeries.Entity.Genero;
import com.mx.CRUDSeries.Service.GeneroService;

@Controller
@RequestMapping(value = "genero")
public class GeneroController {
	@Autowired
	GeneroService gs;
	
	@GetMapping(value = "index")
	public String index(Genero g, Model m) {
		m.addAttribute("genero", g);
		m.addAttribute("listar", gs.listar());
		return "indexGenero";
	}

	@GetMapping(value = "abrirGuardar")
	public String abrirGuardar(Genero g) {
		return "guardarGenero";
	}
	
	@GetMapping(value = "abrirEditar/{id}")
	public String abrirEditar(Genero g, Model m) {
		g = gs.buscar(g);
		m.addAttribute("genero", g);
		return "editarGenero";
	}
	
	@GetMapping(value = "abrirEliminar/{id}")
	public String abrirEliminar(Genero g, Model m) {
		g = gs.buscar(g);
		m.addAttribute("genero", g);
		return "eliminarGenero";
	}
	
	@PostMapping(value = "guardar")
	public String guardar(Genero g) {
		gs.guardar(g);
		return "redirect:/genero/index";
	}
	
	@PostMapping(value = "editar")
	public String editar(Genero g) {
		gs.editar(g);
		return "redirect:/genero/index";
	}
	
	@PostMapping(value = "eliminar")
	public String eliminar(Genero g) {
		gs.eliminar(g);
		return "redirect:/genero/index";
	}
	
	@PostMapping(value = "buscar")
	public String buscar(Genero g, Model m) {
		m.addAttribute("genero", g);
		m.addAttribute("listar", gs.buscarNombre(g));
		return "indexGenero";
	}
}
