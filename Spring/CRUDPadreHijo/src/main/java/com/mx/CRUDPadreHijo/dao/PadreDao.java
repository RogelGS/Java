package com.mx.CRUDPadreHijo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.CRUDPadreHijo.dominio.Padre;

public interface PadreDao extends JpaRepository<Padre, Integer>{
	
}
