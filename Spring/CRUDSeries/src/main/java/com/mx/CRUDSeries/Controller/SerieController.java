package com.mx.CRUDSeries.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mx.CRUDSeries.Entity.Serie;
import com.mx.CRUDSeries.Service.GeneroService;
import com.mx.CRUDSeries.Service.PaisService;
import com.mx.CRUDSeries.Service.SerieService;

@Controller
@RequestMapping(value = "serie")
public class SerieController {
	@Autowired
	SerieService ss;
	@Autowired
	PaisService ps;
	@Autowired
	GeneroService gs;

	@GetMapping(value = "index")
	public String index(Serie s, Model m) {
		m.addAttribute("serie", s);
		m.addAttribute("listar", ss.listar());
		return "indexSerie";
	}

	@GetMapping(value = "abrirGuardar")
	public String abrirGuardar(Serie s, Model m) {
		m.addAttribute("generos", gs.listar());
		m.addAttribute("paises", ps.listar());
		return "guardarSerie";
	}

	@GetMapping(value = "abrirEditar/{id}")
	public String abrirEditar(Serie s, Model m) {
		m.addAttribute("generos", gs.listar());
		m.addAttribute("paises", ps.listar());
		s = ss.buscar(s);
		m.addAttribute("serie", s);
		return "editarSerie";
	}

	@GetMapping(value = "abrirEliminar/{id}")
	public String abrirEliminar(Serie s, Model m) {
		m.addAttribute("generos", gs.listar());
		m.addAttribute("paises", ps.listar());
		s = ss.buscar(s);
		m.addAttribute("serie", s);
		return "eliminarSerie";
	}

	@PostMapping(value = "guardar")
	public String guardar(Serie s) {
		ss.guardar(s);
		return "redirect:/serie/index";
	}

	@PostMapping(value = "editar")
	public String editar(Serie s) {
		ss.editar(s);
		return "redirect:/serie/index";
	}

	@PostMapping(value = "eliminar")
	public String eliminar(Serie s) {
		ss.eliminar(s);
		return "redirect:/serie/index";
	}

	@PostMapping(value = "buscar")
	public String buscar(Serie s, Model m) {
		m.addAttribute("serie", s);
		m.addAttribute("listar", ss.buscarNombre(s));
		return "indexSerie";
	}
}
