package com.mx.CRUDSeries.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mx.CRUDSeries.Entity.Pais;
import com.mx.CRUDSeries.Service.PaisService;

@Controller
@RequestMapping(value = "pais")
public class PaisController {
	String[] paises = {"AMERICA", "EUROPA", "ASIA", "OCEANIA", "AFRICA"};
	@Autowired
	PaisService ps;

	@GetMapping(value = "index")
	public String index(Pais p, Model m) {
		m.addAttribute("pais", p);
		m.addAttribute("paises", paises);
		m.addAttribute("listar", ps.listar());
		return "indexPais";
	}

	@GetMapping(value = "abrirGuardar")
	public String abrirGuardar(Pais g) {
		return "guardarPais";
	}

	@GetMapping(value = "abrirEditar/{id}")
	public String abrirEditar(Pais p, Model m) {
		p = ps.buscar(p);
		m.addAttribute("pais", p);
		return "editarPais";
	}

	@GetMapping(value = "abrirEliminar/{id}")
	public String abrirEliminar(Pais p, Model m) {
		p = ps.buscar(p);
		m.addAttribute("pais", p);
		return "eliminarPais";
	}

	@PostMapping(value = "guardar")
	public String guardar(Pais p) {
		ps.guardar(p);
		return "redirect:/pais/index";
	}

	@PostMapping(value = "editar")
	public String editar(Pais p) {
		ps.editar(p);
		return "redirect:/pais/index";
	}

	@PostMapping(value = "eliminar")
	public String eliminar(Pais p) {
		ps.eliminar(p);
		return "redirect:/pais/index";
	}

	@PostMapping(value = "buscar")
	public String buscar(Pais p, Model m) {
		m.addAttribute("Pais", p);
		m.addAttribute("listar", ps.buscarNombre(p));
		return "indexPais";
	}
}
