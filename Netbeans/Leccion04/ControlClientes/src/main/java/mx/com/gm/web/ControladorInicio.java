/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author KeiesDev
 */
@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private PersonaService ps;
    
    @GetMapping(name = "/")
    public String inicio(Model m) {
        log.info("Ejecutando el Controlador Spring MVC");
        var personas = ps.listar();
        m.addAttribute("personas", personas);
        return "index";
    }
}
