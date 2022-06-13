package com.mx.CRUDJuegos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.CRUDJuegos.entity.Marca;

@Repository
public interface MarcaDao extends JpaRepository<Marca, Integer> {
	public long count();
	
	@Query(value = "SELECT m FROM Marca m WHERE m.nombre LIKE %:filtro%")
	public List<Marca> search(@Param("filtro") String filtro);
}
