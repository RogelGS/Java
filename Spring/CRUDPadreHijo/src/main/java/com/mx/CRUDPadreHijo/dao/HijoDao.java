package com.mx.CRUDPadreHijo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.CRUDPadreHijo.dominio.Hijo;
import com.mx.CRUDPadreHijo.dominio.Padre;

public interface HijoDao extends JpaRepository<Hijo, Integer>{
	
	public List<Hijo> findByApp(String app);
	public List<Hijo> findByPadre(Padre padre);
	
	public List<Hijo> findByNombreContaining(String nombre);
	
	public List<Hijo> findByNombreLike(String nombre);
}
