package com.mx.Project.Controller;

import com.mx.Project.Entity.Client;
import com.mx.Project.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "apiclient")
@CrossOrigin
public class ClientWebService {
    @Autowired
    ClientService cs;

    @GetMapping(value = "list")
    public List<Client> listar() {
        return cs.listar();
    }

    @PostMapping(value = "add")
    public void guardar(@RequestBody Client c) {
        cs.guardar(c);
    }

    @PostMapping(value = "edith")
    public void editar(@RequestBody Client c) {
        cs.editar(c);
    }

    @PostMapping(value = "delete")
    public void eliminar(@RequestBody Client c) {
        cs.eliminar(c);
    }

    @PostMapping(value = "find")
    public Client buscar(@RequestBody Client c) {
        return cs.buscar(c);
    }
}
