/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import BD.BD;
import Objeto.ObjetoReservacion;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author KSGAMER
 */
public class ModeloReservaciones {
    private BD bd = new BD();
    private ResultSet rs;
    private PreparedStatement ps;
    private ArrayList<ObjetoReservacion> lista = new ArrayList<>();

    public ModeloReservaciones() {
        try {
            this.ps = this.bd.getConexion().prepareStatement("SELECT * FROM Reservacion");
            this.rs = this.ps.executeQuery();
            while(this.rs.next()) {
                this.lista.add(new ObjetoReservacion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
            
        }
    }
    
    public ArrayList<ObjetoReservacion> getReservaciones() {
        return this.lista;
    }
    
    public void insertReservaciones(ObjetoReservacion reservacion, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = this.bd.getConexion().prepareStatement("INSERT INTO Reservacion (HabitacionID, ClienteID, FechaIngreso, FechaSalida, Estado) VALUES (?,?,?,?,?)");
            this.ps.setString(1, reservacion.getHabitacionID());
            this.ps.setString(2, reservacion.getClienteID());
            this.ps.setDate(3, reservacion.getFechaIngreso());
            this.ps.setDate(4, reservacion.getFechaSalida());
            this.ps.setString(5, reservacion.getEstado());
            this.ps.execute();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha insertado con exito la reservación!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>Ocurrio un error inesperado asegurese de tener una conexión a internet o que este encendido el servidor.</center></html>");
        }
    }
    
    public void updateReservaciones(ObjetoReservacion reservacion, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = this.bd.getConexion().prepareStatement("UPDATE Reservacion SET HabitacionID = ?, ClienteID = ?, FechaIngreso = ?, FechaSalida = ?, Estado = ? WHERE ReservacionID = ?");
            this.ps.setString(1, reservacion.getHabitacionID());
            this.ps.setString(2, reservacion.getClienteID());
            this.ps.setDate(3, reservacion.getFechaIngreso());
            this.ps.setDate(4, reservacion.getFechaSalida());
            this.ps.setString(5, reservacion.getEstado());
            this.ps.setInt(6, reservacion.getReservacionID());
            this.ps.executeUpdate();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha actualizado con exito la reservación!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se puede actualizar la reservación debido a un error, intentelo más tarde.</center></html>");
        }
    }
    
    public void deleteReservaciones(ObjetoReservacion reservacion, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = this.bd.getConexion().prepareStatement("DELETE FROM Reservacion WHERE ReservacionID = ?");
            this.ps.setInt(1, reservacion.getReservacionID());
            this.ps.execute();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha eliminado con exito la reservación!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se puede eliminar la reservación debido a que ya esta en uso!</center></html>");
        }
    }
}
