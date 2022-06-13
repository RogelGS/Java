package com.mx.CRUDGalletas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.CRUDGalletas.dominio.Pais;

public interface PaisDao extends JpaRepository<Pais, Integer>{
	public List<Pais> findByNombreContaining(String nombre);
}
