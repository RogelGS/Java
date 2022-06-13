package com.mx.Project.Service;

import com.mx.Project.Entity.Client;
import com.mx.Project.Repositoy.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientImplement implements ClientService {
    @Autowired
    ClientRepository cr;

    @Transactional
    @Override
    public void guardar(Client c) {
        cr.save(c);
    }

    @Transactional
    @Override
    public void editar(Client c) {
        cr.save(c);
    }

    @Transactional
    @Override
    public void eliminar(Client c) {
        cr.delete(c);
    }

    @Transactional(readOnly = true)
    @Override
    public Client buscar(Client c) {
        return cr.findById(c.getId()).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> listar() {
        return cr.findAll();
    }
}
