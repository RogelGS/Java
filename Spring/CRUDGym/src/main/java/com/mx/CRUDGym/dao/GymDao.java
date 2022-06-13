package com.mx.CRUDGym.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.CRUDGym.dominio.Gym;

public interface GymDao extends JpaRepository<Gym, Integer>{
	
}
