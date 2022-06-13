/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
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
    
    @Value(value = "${index.saludo}")
    private String saludo;
    
    @GetMapping(name = "/")
    public String inicio(Model m) {
        var mensaje = "Hola Mundo con Thymeleaf";
        var persona = new Persona();
        persona.setNombre("JUAN");
        persona.setApellido("PEREZ");
        persona.setEmail("jperez@gmail.com");
        persona.setTelefono("55443322");
        
        var persona2 = new Persona();
        persona2.setNombre("KARLA");
        persona2.setApellido("GOMEZ");
        persona2.setEmail("kgomez@gmail.com");
        persona2.setTelefono("548245245");
        
//        var personas = Arrays.asList(persona, persona2);
        
        List<Persona> personas = new ArrayList<>();
//        personas.add(persona);
//        personas.add(persona2);
        
        log.info("ejecutando el controlador Spring MVC");
        m.addAttribute("mensaje", mensaje);
        m.addAttribute("saludo", saludo);
//        m.addAttribute("persona", persona);
        m.addAttribute("personas", personas);
        return "index";
    }
}
