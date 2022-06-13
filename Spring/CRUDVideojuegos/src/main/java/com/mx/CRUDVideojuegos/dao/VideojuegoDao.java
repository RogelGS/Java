package com.mx.CRUDVideojuegos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.CRUDVideojuegos.dominio.Videojuego;

@Repository
public interface VideojuegoDao extends JpaRepository<Videojuego, Integer> {
	
	public long count();
	
	@Query(value = "SELECT v FROM Videojuego v WHERE v.nombre like %:filtro%")
	public List<Videojuego> search(@Param("filtro") String filtro);
}
