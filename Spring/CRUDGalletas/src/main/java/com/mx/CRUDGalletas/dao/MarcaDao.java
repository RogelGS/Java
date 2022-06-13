package com.mx.CRUDGalletas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.CRUDGalletas.dominio.Marca;

public interface MarcaDao extends JpaRepository<Marca, Integer>{
	public List<Marca> findByNombreContaining(String nombre);
}
