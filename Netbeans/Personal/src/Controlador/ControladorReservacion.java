/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloReservaciones;
import Objeto.ObjetoReservacion;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KSGAMER
 */
public class ControladorReservacion {
    private ModeloReservaciones reservaciones = new ModeloReservaciones();
    
    public DefaultTableModel tablaReservaciones(String filtro) {
        String[] columnas = {"No.", "Habitación", "Cliente", "Fecha de Ingreso", "Fecha de Salida", "Estado"};
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        int i = 0;
        for (ObjetoReservacion reservacion : this.reservaciones.getReservaciones()) {
            if(reservacion.getHabitacionID().contains(filtro) || reservacion.getClienteID().contains(filtro)) {
                tabla.addRow((Object[]) null);
                tabla.setValueAt(reservacion.getReservacionID(), i, 0);
                tabla.setValueAt(reservacion.getHabitacionID(), i, 1);
                tabla.setValueAt(reservacion.getClienteID(), i, 2);
                tabla.setValueAt(reservacion.getFechaIngreso(), i, 3);
                tabla.setValueAt(reservacion.getFechaSalida(), i, 4);
                if(reservacion.getEstado().equals("1")) {
                    tabla.setValueAt("No Pagado", i, 5);
                } else {
                    tabla.setValueAt("Pagado", i, 5);
                }
                i++;
            }
        }
        return tabla;
    }
    
    public ArrayList<ObjetoReservacion> listaReservaciones() {
        return this.reservaciones.getReservaciones();
    }
    
    public void insertarReservaciones(String habitacion, String cliente, Date fechaIngreso, Date fechaSalida, String estado, JPanel contenedor, JLabel notificacion) {
        this.reservaciones.insertReservaciones(new ObjetoReservacion(0, habitacion, cliente, fechaIngreso, fechaSalida, estado), contenedor, notificacion);
    }
    
    public void actualizarReservaciones(String habitacion, String cliente, Date fechaIngreso, Date fechaSalida, String estado, int reservacion, JPanel contenedor, JLabel notificacion) {
        this.reservaciones.updateReservaciones(new ObjetoReservacion(reservacion, habitacion, cliente, fechaIngreso, fechaSalida, estado), contenedor, notificacion);
    }
    
    public void eliminarReservaciones(int reservacion, JPanel contenedor, JLabel notificacion) {
        this.reservaciones.deleteReservaciones(new ObjetoReservacion(reservacion, null, null, null, null, null), contenedor, notificacion);
    }
}
