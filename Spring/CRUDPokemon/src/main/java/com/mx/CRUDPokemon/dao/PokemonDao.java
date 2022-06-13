package com.mx.CRUDPokemon.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.CRUDPokemon.entidad.Pokemon;

public interface PokemonDao extends CrudRepository<Pokemon, Integer> {
	
}
