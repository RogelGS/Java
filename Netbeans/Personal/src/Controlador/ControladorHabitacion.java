/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloHabitaciones;
import Objeto.ObjetoHabitacion;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KSGAMER
 */
public class ControladorHabitacion {

    private ModeloHabitaciones habitaciones = new ModeloHabitaciones();

    public DefaultTableModel tablaHabitaciones(String filtro) {
        String[] columnas = {"Habitación", "Piso", "Categoria", "Precio Hora", "Precio Día", "Estado"};
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        int i = 0;
        for (ObjetoHabitacion habitacion : this.habitaciones.getHabitaciones()) {
            if (habitacion.getHabitacionID().contains(filtro) || habitacion.getPisoID().contains(filtro) || habitacion.getCategoriaID().contains(filtro) || habitacion.getCaracteristicas().contains(filtro)) {
                tabla.addRow((Object[]) null);
                tabla.setValueAt(habitacion.getHabitacionID(), i, 0);
                tabla.setValueAt(habitacion.getPisoID(), i, 1);
                tabla.setValueAt(habitacion.getCategoriaID(), i, 2);
                tabla.setValueAt(habitacion.getPrecioHora(), i, 3);
                tabla.setValueAt(habitacion.getPrecioDia(), i, 4);
                switch(habitacion.getEstado()) {
                    case "1" : {
                        tabla.setValueAt("Disponible", i, 5);
                        break;
                    }
                    case "2": {
                        tabla.setValueAt("Reservado", i, 5);
                        break;
                    }
                    case "3": {
                        tabla.setValueAt("Limpieza", i, 5);
                        break;
                    }
                    case "4": {
                        tabla.setValueAt("Mantenimiento", i, 5);
                        break;
                    }
                }
                i++;
            }
        }
        return tabla;
    }
    
    public ArrayList<ObjetoHabitacion> listaHabitaciones() {
        return this.habitaciones.getHabitaciones();
    }
    
    public void insertarHabitaciones(String habitacion, String piso, String categoria, String precioHora, String precioDia, String caracteristicas, String estado, JPanel contenedor, JLabel notificacion) {
        if(precioHora.contains("Ingrese")) {
            precioHora = "0";
        }
        if(precioDia.contains("Ingrese")) {
            precioDia = "0";
        }if(caracteristicas.contains("Ingrese")) {
            caracteristicas = "";
        }
        this.habitaciones.insertHabitaciones(new ObjetoHabitacion(habitacion, piso, categoria, Double.parseDouble(precioHora), Double.parseDouble(precioDia), caracteristicas, estado), contenedor, notificacion);
    }
    
    public void actualizarHabitaciones(String habitacionNueva, String piso, String categoria, String precioHora, String precioDia, String caracteristicas, String estado, String habitacionVieja, JPanel contenedor, JLabel notificacion) {
        if(precioHora.contains("Ingrese")) {
            precioHora = "0";
        }
        if(precioDia.contains("Ingrese")) {
            precioDia = "0";
        }if(caracteristicas.contains("Ingrese")) {
            caracteristicas = "";
        }
        ObjetoHabitacion[] habitacion = {new ObjetoHabitacion(habitacionNueva, piso, categoria, Double.parseDouble(precioHora), Double.parseDouble(precioDia), caracteristicas, estado), new ObjetoHabitacion(habitacionVieja, null, null, 0, 0, null, null)};
        this.habitaciones.updateHabitaciones(habitacion, contenedor, notificacion);
    }
    
    public void actualizarHabitacionesEstado(String habitacion, String estado) {
        this.habitaciones.updateHabitacionesEstado(new ObjetoHabitacion(habitacion, null, null, 0, 0, null, estado));
    }
    
    public void eliminarHabitacion(String habitacion, JPanel contenedor, JLabel notificacion) {
        this.habitaciones.deleteHabitaciones(new ObjetoHabitacion(habitacion, null, null, 0, 0, null, null), contenedor, notificacion);
    }
}
