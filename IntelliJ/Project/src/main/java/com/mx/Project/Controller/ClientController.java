package com.mx.Project.Controller;

import com.mx.Project.Entity.Client;
import com.mx.Project.Service.ClientService;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "client")
public class ClientController {
    @Autowired
    ClientService cs;
    
    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    Integer i;
    
    @GetMapping(value = "index")
    public String index(Model m) {
    	m.addAttribute("list", cs.listar());
    	m.addAttribute("format", format);
    	m.addAttribute("now", now);
    	m.addAttribute("i", i);
        return "index";
    }
    
    @GetMapping(value = "openAdd")
    public String openAdd(Client c, Model m) {
    	return "agregar";
    }
    
    @PostMapping(value = "guardar")
    public String guardar(Client c) {
    	cs.guardar(c);
    	return "redirect:/client/index";
    }
}
