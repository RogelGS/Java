package com.mx.CRUDPokemon.servicios;

import java.util.List;

import com.mx.CRUDPokemon.entidad.Pokemon;

public interface PokemonServicio {
	public void guardar(Pokemon pokemon);
	public void editar(Pokemon pokemon);
	public void eliminar(Pokemon pokemon);
	
	public Pokemon buscar(Pokemon pokemon);
	public List<Pokemon> listar();
}
