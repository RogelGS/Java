package com.mx.CRUDTenni.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.CRUDTenni.entity.Tenni;

public interface TenniDao extends JpaRepository<Tenni, Integer> {
	@Query(value = "SELECT t FROM Tenni t WHERE UPPER(t.modelo) LIKE %:campo%")
	public List<Tenni> search(@Param("campo") String campo);
	
}
