package com.mx.CRUDTennis.servicio;

import com.mx.CRUDTennis.dao.TennisDao;
import com.mx.CRUDTennis.entity.Tennis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TennisImplementacion implements TennisService {
    @Autowired
    TennisDao td;
    @Override
    public Tennis buscar(Tennis t) {
        return td.findById(t.getId()).orElse(null);
    }

    @Override
    public List<Tennis> listar() {
        return td.findAll();
    }
}
