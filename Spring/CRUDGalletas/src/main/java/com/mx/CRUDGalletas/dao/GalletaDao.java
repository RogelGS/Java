package com.mx.CRUDGalletas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.CRUDGalletas.dominio.Galleta;
import com.mx.CRUDGalletas.dominio.Marca;
import com.mx.CRUDGalletas.dominio.Pais;

@Repository
public interface GalletaDao extends JpaRepository<Galleta, Integer>{

	public List<Galleta> findByNombreContaining(String nombre);
	
	@Query(value = "SELECT g FROM Galleta g WHERE g.nombre LIKE %:filtro%")
	public List<Galleta> search(@Param("filtro") String filtro);
	
	public List<Galleta> findByMarca(Marca m);
	public List<Galleta> findByPais(Pais p);
}
