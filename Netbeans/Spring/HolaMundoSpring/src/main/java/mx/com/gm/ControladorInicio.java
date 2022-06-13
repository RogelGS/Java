/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KeiesDev
 */
@RestController
@Slf4j
public class ControladorInicio {
    @GetMapping(name = "/")
    public String inicio() {
        log.info("ejecutando el controlador rest");
        log.debug("Mas detalle del controlador");
        return "Hola Mundo con Spring 2";
    }
}
