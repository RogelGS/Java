/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import BD.BD;
import Objeto.ObjetoPiso;
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
public class ModeloPisos {
    private BD bd = new BD();
    private ResultSet rs;
    private PreparedStatement ps;
    private ArrayList<ObjetoPiso> lista = new ArrayList<>();

    public ModeloPisos() {
        try {
            this.ps = this.bd.getConexion().prepareStatement("SELECT * FROM Piso");
            this.rs = this.ps.executeQuery();
            while(this.rs.next()) {
                this.lista.add(new ObjetoPiso(rs.getString(1)));
            }
        } catch (SQLException ex) {
            
        }
    }
    
    public ArrayList<ObjetoPiso> getPisos() {
        return lista;
    }
    
    public void insertPisos(ObjetoPiso piso, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = this.bd.getConexion().prepareStatement("INSERT INTO Piso (PisoID) VALUES (?)");
            this.ps.setString(1, piso.getPisoID());
            this.ps.execute();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha insertado con exito el piso!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se pueden agregar pisos que ya han sido agregados.</center></html>");
        }
    }
    
    public void updatePisos(ObjetoPiso[] piso, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = this.bd.getConexion().prepareStatement("UPDATE Piso SET PisoID = ? WHERE PisoID = ?");
            this.ps.setString(1, piso[0].getPisoID());
            this.ps.setString(2, piso[1].getPisoID());
            this.ps.executeUpdate();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha actualizado con exito el piso!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se puede actualizar el piso por uno ya existente.</center></html>");
        }
    }
    
    public void deletePisos(ObjetoPiso piso, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = this.bd.getConexion().prepareStatement("DELETE FROM Piso WHERE PisoID = ?");
            this.ps.setString(1, piso.getPisoID());
            this.ps.execute();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha eliminado con exito el piso!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se puede eliminar el piso debido a que ya esta en uso!.</center></html>");
        }
    }
}
