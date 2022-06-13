/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.service;

import java.util.List;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KeiesDev
 */
@Service
public class PersonaImplement implements PersonaService{
    @Autowired
    private PersonaDao pd;
    
    @Transactional
    @Override
    public void guardar(Persona p) {
        pd.save(p);
    }

    @Transactional
    @Override
    public void editar(Persona p) {
        pd.save(p);
    }

    @Transactional
    @Override
    public void eliminar(Persona p) {
        pd.delete(p);
    }

    @Transactional(readOnly = true)
    @Override
    public Persona buscar(Persona p) {
        return pd.findById(p.getId_persona()).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Persona> listar() {
        return pd.findAll();
    }
    
}
