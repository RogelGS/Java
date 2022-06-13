/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import BD.BD;
import Objeto.ObjetoHabitacion;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author KSGAMER
 */
public class ModeloHabitaciones {
    private BD bd = new BD();
    private ResultSet rs;
    private PreparedStatement ps;
    private ArrayList<ObjetoHabitacion> lista = new ArrayList<>();

    public ModeloHabitaciones() {
        try {
            this.ps = this.bd.getConexion().prepareStatement("SELECT * FROM Habitacion");
            this.rs = this.ps.executeQuery();
            while(this.rs.next()) {
                this.lista.add(new ObjetoHabitacion(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            
        }
    }
    
    public ArrayList<ObjetoHabitacion> getHabitaciones() {
        return lista;
    }
    
    public void insertHabitaciones(ObjetoHabitacion habitacion, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = this.bd.getConexion().prepareStatement("INSERT INTO Habitacion (HabitacionID, PisoID, CategoriaID, PrecioHora, PrecioDia, Caracteristicas, Estado) VALUES (?,?,?,?,?,?,?)");
            this.ps.setString(1, habitacion.getHabitacionID());
            this.ps.setString(2, habitacion.getPisoID());
            this.ps.setString(3, habitacion.getCategoriaID());
            this.ps.setDouble(4, habitacion.getPrecioHora());
            this.ps.setDouble(5, habitacion.getPrecioDia());
            this.ps.setString(6, habitacion.getCaracteristicas());
            this.ps.setString(7, habitacion.getEstado());
            this.ps.execute();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha insertado con exito la habitación!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se pueden agregar habitaciones que ya han sido agregadas.</center></html>");
        }
    }
    
    public void updateHabitaciones(ObjetoHabitacion[] habitacion, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = this.bd.getConexion().prepareStatement("UPDATE Habitacion SET HabitacionID = ?, PisoID = ?, CategoriaID = ?, PrecioHora = ?, PrecioDia = ?, Caracteristicas = ?, Estado = ? WHERE HabitacionID = ?");
            this.ps.setString(1, habitacion[0].getHabitacionID());
            this.ps.setString(2, habitacion[0].getPisoID());
            this.ps.setString(3, habitacion[0].getCategoriaID());
            this.ps.setDouble(4, habitacion[0].getPrecioHora());
            this.ps.setDouble(5, habitacion[0].getPrecioDia());
            this.ps.setString(6, habitacion[0].getCaracteristicas());
            this.ps.setString(7, habitacion[0].getEstado());
            this.ps.setString(8, habitacion[1].getHabitacionID());
            this.ps.executeUpdate();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha actualizado con exito la habitación!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se puede actualizar la habitación por una ya existente.</center></html>");
        }
    }
    
    public void updateHabitacionesEstado(ObjetoHabitacion habitacion) {
        try {
            this.ps = this.bd.getConexion().prepareStatement("UPDATE Habitacion SET Estado = ?  WHERE HabitacionID = ?");
            this.ps.setString(1, habitacion.getEstado());
            this.ps.setString(2, habitacion.getHabitacionID());
            this.ps.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
    public void deleteHabitaciones(ObjetoHabitacion habitacion, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = this.bd.getConexion().prepareStatement("DELETE FROM Habitacion WHERE HabitacionID = ?");
            this.ps.setString(1, habitacion.getHabitacionID());
            this.ps.execute();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha eliminado con exitó la habitación!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se puede eliminar la habitación debido a que ya esta en uso!.</center></html>");
        }
    }
}
