package com.mx.CRUDTenni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mx.CRUDTenni.entity.Tenni;
import com.mx.CRUDTenni.service.TenniServicio;

@Controller
@RequestMapping("TENNI")
public class TenniController {
	@Autowired
	TenniServicio ts;
	
	@GetMapping("INICIO")
	public String inicio(Tenni t, Model m) {
		m.addAttribute("tenni", t);
		m.addAttribute("listar", ts.listar());
		return "index";
	}
	
	@GetMapping("ABRIRGUARDAR")
	public String abrirGuardar(Tenni t) {
		return "guardar";
	}
	
	@PostMapping("SEARCH")
	public String search(Tenni t, Model m) {
		m.addAttribute("tenni", t);
		m.addAttribute("listar", ts.search(t));
		return "index";
	}
	
	@PostMapping("GUARDAR")
	public String guardar(Tenni t) {
		ts.guardar(t);
		return "redirect:/TENNI/INICIO";
	}
	
	@GetMapping("/ABRIREDITAR/{id}")
	public String abrirEditar(Tenni t, Model m) {
		t = ts.buscar(t);
		m.addAttribute("tenni", t);
		return "editar";
	}
	
	@PostMapping("EDITAR")
	public String editar(Tenni t) {
		ts.editar(t);
		return "redirect:/TENNI/INICIO";
	}
	
	@GetMapping("/ABRIRELIMINAR/{id}")
	public String abrirEeliminar(Tenni t, Model m) {
		t = ts.buscar(t);
		m.addAttribute("tenni", t);
		return "eliminar";
	}
	
	@PostMapping("ELIMINAR")
	public String eliminar(Tenni t) {
		ts.eliminar(t);
		return "redirect:/TENNI/INICIO";
	}
}
