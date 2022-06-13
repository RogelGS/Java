/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author KeiesDev
 */
@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private PersonaService ps;
    
    @GetMapping(value = "/")
    public String inicio(Model m, @AuthenticationPrincipal User u) {
        log.info("Ejecutando el Controlador Spring MVC");
        log.info("Usuario que hizo login " +u);
        var personas = ps.listar();
        m.addAttribute("personas", personas);
        var saldoTotal = 0D;
        for(var p: personas) {
            saldoTotal += p.getSaldo();
        }
        m.addAttribute("saldoTotal", saldoTotal);
        m.addAttribute("totalClientes", personas.size());
        return "index";
    }
    
    @GetMapping(value =  "/agregar")
    public String agregar(Persona p) {
        return "modificar";
    }
    
    @PostMapping(value = "/guardar")
    public String guardar(@Valid Persona p, Errors e) {
        if(e.hasErrors()) {
            return "modificar";
        }
        ps.guardar(p);
        return "redirect:/";
    }
    
    @GetMapping(value = "/editar/{id_persona}")
    public String editar(Persona p, Model m) {
        p = ps.buscar(p);
        m.addAttribute("persona", p);
        return "modificar";
    }
    
//    @GetMapping(value = "/eliminar/{id_persona}")
//    public String eliminar(Persona p) {
//        ps.eliminar(p);
//        return "redirect:/";
//    }
    
    @GetMapping(value = "/eliminar")
    public String eliminar(Persona p) {
        ps.eliminar(p);
        return "redirect:/";
    }
}

