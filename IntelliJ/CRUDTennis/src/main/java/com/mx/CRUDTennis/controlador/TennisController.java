package com.mx.CRUDTennis.controlador;

import com.mx.CRUDTennis.entity.Tennis;
import com.mx.CRUDTennis.servicio.TennisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "tennis")
@CrossOrigin
public class TennisController {
    @Autowired
    TennisService ts;

    @GetMapping(value = "listar")
    public List<Tennis> listar() {
        return ts.listar();
    }

    @PostMapping(value = "buscar")
    public Tennis buscar(@RequestBody Tennis t) {
        return ts.buscar(t);
    }
}
