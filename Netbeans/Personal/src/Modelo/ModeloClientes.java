/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import BD.BD;
import Objeto.ObjetoCliente;
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
public class ModeloClientes {
    private BD bd = new BD();
    private ResultSet rs;
    private PreparedStatement ps;
    private ArrayList<ObjetoCliente> lista = new ArrayList<>();

    public ModeloClientes() {
        try {
            this.ps = bd.getConexion().prepareStatement("SELECT * FROM Cliente");
            this.rs = this.ps.executeQuery();
            while(this.rs.next()) {
                this.lista.add(new ObjetoCliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            
        }
    }
    
    public ArrayList<ObjetoCliente> getClientes() {
        return lista;
    }
    
    public void insertClientes(ObjetoCliente cliente, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = bd.getConexion().prepareStatement("INSERT INTO Cliente (Nombre, RFC, Telefono, Correo) VALUES (?,?,?,?)");
            this.ps.setString(1, cliente.getNombre());
            this.ps.setString(2, cliente.getRfc());
            this.ps.setString(3, cliente.getTelefono());
            this.ps.setString(4, cliente.getCorreo());
            this.ps.execute();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha insertado con exito el cliente!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>Ocurrio un error inesperado asegurese de tener una conexión a internet o que este encendido el servidor.</center></html>");
        }
    }
    
    public void updateClientes(ObjetoCliente cliente, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = bd.getConexion().prepareStatement("UPDATE Cliente SET Nombre = ?, RFC = ?, Telefono = ?, Correo = ? WHERE ClienteID = ?");
            this.ps.setString(1, cliente.getNombre());
            this.ps.setString(2, cliente.getRfc());
            this.ps.setString(3, cliente.getTelefono());
            this.ps.setString(4, cliente.getCorreo());
            this.ps.setInt(5, cliente.getClienteID());
            this.ps.executeUpdate();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha actualizado con exito el cliente!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se puede actualizar el cliente debido a un error, intentelo más tarde.</center></html>");
        }
    }
    
    public void deleteClientes(ObjetoCliente cliente, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = bd.getConexion().prepareStatement("DELETE FROM Cliente WHERE ClienteID = ?");
            this.ps.setInt(1, cliente.getClienteID());
            this.ps.execute();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha eliminado con exito el cliente!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se puede eliminar el cliente debido a que ya esta en uso!</center></html>");
        }
    }
}
