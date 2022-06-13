/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Objeto.ObjetoHabitacion;
import Utileria.Habitacion;
import Vista.Principal;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author KSGAMER
 */
public class ControladorRecepcion {

    private ControladorHabitacion habitaciones = new ControladorHabitacion();
    private Habitacion panelHabitacion;

    public void cargarHabitaciones(Principal principal, JPanel contenedor, String piso, String categoria, String status) {
        String estado = "";
        if (piso.contains("Seleccione")) {
            piso = "";
        }
        if (categoria.contains("Seleccione")) {
            categoria = "";
        }
        if (status.equals("0")) {
            status = "";
        }
        contenedor.removeAll();
        for (ObjetoHabitacion objetoHabitacion : habitaciones.listaHabitaciones()) {
            panelHabitacion = new Habitacion(principal);
            switch (objetoHabitacion.getEstado()) {
                case "1": {
                    estado = "Disponible";
                    break;
                }
                case "2": {
                    estado = "Reservado";
                    break;
                }
                case "3": {
                    estado = "Limpieza";
                    break;
                }
                case "4": {
                    estado = "Mantenimiento";
                    break;
                }
            }
            if (objetoHabitacion.getCategoriaID().contains(categoria) && objetoHabitacion.getPisoID().contains(piso) && objetoHabitacion.getEstado().contains(status)) {
                contenedor.add(panelHabitacion.getPersonalizacion(objetoHabitacion.getHabitacionID(), objetoHabitacion.getCategoriaID(), String.valueOf(objetoHabitacion.getPrecioHora()), String.valueOf(objetoHabitacion.getPrecioDia()), estado));
            }
        }
        if (contenedor.getComponentCount() <= 8) {
            for (int i = contenedor.getComponentCount(); i < 9; i++) {
                JPanel panel = new JPanel();
                panel.setBackground(Color.WHITE);
                contenedor.add(panel);
            }
        }
        contenedor.updateUI();
    }
}
