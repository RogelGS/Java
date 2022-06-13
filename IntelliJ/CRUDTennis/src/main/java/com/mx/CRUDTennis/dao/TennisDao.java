package com.mx.CRUDTennis.dao;

import com.mx.CRUDTennis.entity.Tennis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TennisDao extends JpaRepository<Tennis, Integer> {
}
