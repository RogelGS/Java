package com.mx.CRUDPelicula.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.CRUDPelicula.entity.Pelicula;

public interface PeliculaDao extends CrudRepository<Pelicula, Integer>{

}
