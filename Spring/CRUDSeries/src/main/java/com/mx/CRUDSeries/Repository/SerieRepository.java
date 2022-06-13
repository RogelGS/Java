package com.mx.CRUDSeries.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.CRUDSeries.Entity.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {
	
	@Query(value = "SELECT s FROM Serie s WHERE UPPER(s.nombre) LIKE %:filtro% OR UPPER(s.genero.nombre) LIKE %:filtro%")
	public List<Serie> buscarNombre(@Param(value = "filtro") String filtro);
	
	@Query(value = "SELECT s FROM Serie s WHERE UPPER(s.genero.nombre) LIKE %:filtro%")
	public List<Serie> buscarGenero(@Param(value = "filtro") String filto);
}
