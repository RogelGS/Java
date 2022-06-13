package com.mx.CRUDCine.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.CRUDCine.dominio.Pelicula;

public interface PeliculaDao extends CrudRepository<Pelicula, Integer>{

}
