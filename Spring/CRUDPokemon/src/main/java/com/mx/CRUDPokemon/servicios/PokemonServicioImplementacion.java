package com.mx.CRUDPokemon.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CRUDPokemon.dao.PokemonDao;
import com.mx.CRUDPokemon.entidad.Pokemon;

@Service
public class PokemonServicioImplementacion implements PokemonServicio {
	
	@Autowired
	PokemonDao p;

	@Override
	public void guardar(Pokemon pokemon) {
		p.save(pokemon);
	}

	@Override
	public void editar(Pokemon pokemon) {
		p.save(pokemon);
	}

	@Override
	public void eliminar(Pokemon pokemon) {
		p.delete(pokemon);
	}

	@Override
	public Pokemon buscar(Pokemon pokemon) {
		return p.findById(pokemon.getId()).orElse(null);
	}

	@Override
	public List<Pokemon> listar() {
		return (List<Pokemon>) p.findAll();
	}

}
