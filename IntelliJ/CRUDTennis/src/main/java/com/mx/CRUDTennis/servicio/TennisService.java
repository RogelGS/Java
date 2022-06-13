package com.mx.CRUDTennis.servicio;

import com.mx.CRUDTennis.entity.Tennis;

import java.util.List;

public interface TennisService {
    public Tennis buscar(Tennis t);
    public List<Tennis> listar();
}
