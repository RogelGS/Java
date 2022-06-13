package com.mx.CRUDSeries.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.CRUDSeries.Entity.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {
	
	@Query(value = "SELECT g FROM Genero g WHERE UPPER(g.nombre) LIKE %:filtro%")
	public List<Genero> buscarNombre(@Param(value = "filtro") String filtro);
}
