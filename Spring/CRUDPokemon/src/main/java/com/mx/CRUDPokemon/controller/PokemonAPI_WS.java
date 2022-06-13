package com.mx.CRUDPokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDPokemon.entidad.Pokemon;
import com.mx.CRUDPokemon.servicios.PokemonServicio;

@RestController
@RequestMapping("APIPOKEMON")
@CrossOrigin
public class PokemonAPI_WS {
	@Autowired
	PokemonServicio p;

	// http://localhost:7500/APIPOKEMON/listar
	@GetMapping("listar")
	public List<Pokemon> listar() {
		List<Pokemon> lista = p.listar();
		System.out.println("Lista->" + lista);
		return lista;
	}

	// http://localhost:7500/APIPOKEMON/guardar
	@PostMapping("guardar")
	public void guardar(@RequestBody Pokemon pokemon) {
		p.guardar(pokemon);
	}

	// http://localhost:7500/APIPOKEMON/guardar
	@PostMapping("editar")
	public void editar(@RequestBody Pokemon pokemon) {
		p.editar(pokemon);
	}

	// http://localhost:7500/APIPOKEMON/buscar
	@PostMapping("buscar")
	public Pokemon buscar(@RequestBody Pokemon pokemon) {
		return p.buscar(pokemon);
	}

	// http://localhost:7500/APIPOKEMON/eliminar
	@PostMapping("eliminar")
	public void eliminar(@RequestBody Pokemon pokemon) {
		p.eliminar(pokemon);
	}
}
