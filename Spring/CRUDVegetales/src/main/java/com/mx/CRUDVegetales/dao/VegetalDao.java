package com.mx.CRUDVegetales.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.CRUDVegetales.dominio.Vegetal;

@Repository
public interface VegetalDao extends JpaRepository<Vegetal, Integer>{
	public long count();
	
	@Query(value = "SELECT v FROM Vegetal v WHERE v.nombre like %:filtro%")
	public List<Vegetal> search(@Param("filtro") String filtro);
}
