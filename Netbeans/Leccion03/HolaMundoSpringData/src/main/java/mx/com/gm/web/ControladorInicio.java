/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private PersonaDao pd;
    
    @GetMapping(name = "/")
    public String inicio(Model m) {
        log.info("Ejecutando el Controlador Spring MVC");
        var personas = pd.findAll();
        m.addAttribute("personas", personas);
        return "index";
    }
}
