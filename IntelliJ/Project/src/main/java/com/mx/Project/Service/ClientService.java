package com.mx.Project.Service;

import com.mx.Project.Entity.Client;

import java.util.List;

public interface ClientService {
    public void guardar(Client c);
    public void editar(Client c);
    public void eliminar(Client c);
    public Client buscar(Client c);
    public List<Client> listar();
}
