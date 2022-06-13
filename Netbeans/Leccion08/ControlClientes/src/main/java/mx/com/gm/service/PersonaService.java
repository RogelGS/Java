/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.service;

import java.util.List;
import mx.com.gm.domain.Persona;

/**
 *
 * @author KeiesDev
 */
public interface PersonaService {
    public void guardar(Persona p);
    public void editar(Persona p);
    public void eliminar(Persona p);
    public Persona buscar(Persona p);
    public List<Persona> listar();
}
