package com.mx.CRUDSeries.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.CRUDSeries.Entity.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
	
	@Query(value = "SELECT p FROM Pais p WHERE UPPER(p.nombre) LIKE %:filtro%")
	public List<Pais> buscarNombre(@Param(value = "filtro") String filtro);
}
