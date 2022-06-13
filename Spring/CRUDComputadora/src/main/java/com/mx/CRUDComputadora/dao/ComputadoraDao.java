package com.mx.CRUDComputadora.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.CRUDComputadora.dominio.Computadora;

public interface ComputadoraDao extends CrudRepository<Computadora, Integer>{

}
