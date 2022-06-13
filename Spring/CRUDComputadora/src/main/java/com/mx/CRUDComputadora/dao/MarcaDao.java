package com.mx.CRUDComputadora.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.CRUDComputadora.dominio.Marca;

public interface MarcaDao extends CrudRepository<Marca, Integer>{
	
}
