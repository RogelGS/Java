/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import BD.BD;
import Objeto.ObjetoUsuario;
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
public class ModeloUsuarios {

    private BD bd = new BD();
    private ResultSet rs;
    private PreparedStatement ps;
    private ArrayList<ObjetoUsuario> lista = new ArrayList<>();

    public ModeloUsuarios() {
        try {
            this.ps = bd.getConexion().prepareStatement("SELECT * FROM Usuario");
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                this.lista.add(new ObjetoUsuario(rs.getString(1), rs.getString(2), rs.getBytes(3), rs.getString(4)));
            }
        } catch (SQLException | java.lang.NullPointerException ex) {
            
        }
    }

    public ArrayList<ObjetoUsuario> getUsuarios() {
        return lista;
    }
    
    public void insertUsuarios(ObjetoUsuario usuario, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = bd.getConexion().prepareStatement("INSERT INTO Usuario(Usuario, Contrasena, Foto, Estado) VALUES (?,?,?, 1)");
            this.ps.setString(1, usuario.getUsuario());
            this.ps.setString(2, usuario.getContrasena());
            this.ps.setBytes(3, usuario.getImagen());
            this.ps.execute();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha insertado con exito el usuario!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se puede crear el usuario debido a que ya existe.</center></html>");
        }
    }
    
    public void updateUsuarios(ObjetoUsuario usuario, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            if(usuario.getImagen() == null) {
                this.ps = bd.getConexion().prepareStatement("UPDATE Usuario SET Contrasena = ? WHERE Usuario = ?");
                this.ps.setString(1, usuario.getContrasena());
                this.ps.setString(2, usuario.getUsuario());
            } else {
                this.ps = bd.getConexion().prepareStatement("UPDATE Usuario SET Contrasena = ?, Foto = ? WHERE Usuario = ?");
                this.ps.setString(1, usuario.getContrasena());
                this.ps.setBytes(2, usuario.getImagen());
                this.ps.setString(3, usuario.getUsuario());
            }
            this.ps.executeUpdate();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha actualizado con exito el usuario!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se puede actualizar el usuario debido a un error, intentelo más tarde.</center></html>");
        }
    }
    
    public void updateEstadoUsuarios(String usuario, String estado, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = bd.getConexion().prepareStatement("UPDATE Usuario SET Estado = ? WHERE Usuario = ?");
            this.ps.setString(1, estado);
            this.ps.setString(2, usuario);
            this.ps.executeUpdate();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha actualizado el estado del usuario con exito!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se puede actualizar el estado del usuario debido a un error, intentelo más tarde.</center></html>");
        }
    }
    
    public void deleteUsuarios(ObjetoUsuario usuario, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = bd.getConexion().prepareStatement("DELETE FROM Usuario WHERE Usuario = ?");
            this.ps.setString(1, usuario.getUsuario());
            this.ps.execute();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha eliminado con exito el usuario!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se puede eliminar el usuario debido a que ya esta en uso.</center></html>");
        }
    }
}
