package com.mx.CRUDGym.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mx.CRUDGym.dominio.Gym;
import com.mx.CRUDGym.servicio.GymServicio;

@Controller
@RequestMapping("GYM")
public class GymControlador {
	@Autowired
	GymServicio gs;
	
	@GetMapping("INICIO")
	public String inicio(Model model) {
		var lista = gs.listar();
		model.addAttribute("lista", lista);
		return "index";
	}
	
	@GetMapping("abrirGuardar")
	public String abrirGuardar(Gym gym) {
		return "guardar";
	}
	
	@PostMapping("GUARDAR")
	public String guardar(Gym gym) {
		gs.guardar(gym);
		return "redirect:/GYM/INICIO";
	}
	
	@GetMapping("/abrirEditar/{id}")
	public String abrirEditar(Gym gym, Model model) {
		gym = gs.buscar(gym);
		model.addAttribute("gym", gym);
		return "editar";
	}
	
	@PostMapping("EDITAR")
	public String editar(Gym gym) {
		gs.editar(gym);
		return "redirect:/GYM/INICIO";
	}
	
	@GetMapping("/abrirEliminar/{id}")
	public String abrirEliminar(Gym gym, Model model) {
		gym = gs.buscar(gym);
		model.addAttribute("gym", gym);
		return "eliminar";
	}
	
	@PostMapping("ELIMINAR")
	public String eliminar(Gym gym) {
		System.out.println("Entro");
		gs.eliminar(gym);
		return "redirect:/GYM/INICIO";
	}
}
