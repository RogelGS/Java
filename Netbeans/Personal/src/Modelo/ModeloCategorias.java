/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import BD.BD;
import Objeto.ObjetoCategoria;
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
public class ModeloCategorias {
    private BD bd = new BD();
    private ResultSet rs;
    private PreparedStatement ps;
    private ArrayList<ObjetoCategoria> lista = new ArrayList<>();

    public ModeloCategorias() {
        try {
            this.ps = this.bd.getConexion().prepareStatement("SELECT * FROM Categoria");
            this.rs = this.ps.executeQuery();
            while(this.rs.next()) {
                this.lista.add(new ObjetoCategoria(rs.getString(1)));
            }
        } catch (SQLException ex) {
            
        }
    }
    
    public ArrayList<ObjetoCategoria> getCategorias() {
        return lista;
    }
    
    public void insertCategorias(ObjetoCategoria categoria, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = this.bd.getConexion().prepareStatement("INSERT INTO Categoria (categoriaID) VALUES (?)");
            this.ps.setString(1, categoria.getCategoriaID());
            this.ps.execute();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha insertado con exito la categoria!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se pueden agregar categorias que ya han sido agregadas.</center></html>");
        }
    }
    
    public void updateCategorias(ObjetoCategoria[] categoria, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = this.bd.getConexion().prepareStatement("UPDATE Categoria SET CategoriaID = ? WHERE CategoriaID = ?");
            this.ps.setString(1, categoria[0].getCategoriaID());
            this.ps.setString(2, categoria[1].getCategoriaID());
            this.ps.executeUpdate();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha actualizado con exito la categoria!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se puede actualizar la categoria por una ya existente.</center></html>");
        }
    }
    
    public void deleteCategorias(ObjetoCategoria categoria, JPanel contenedor, JLabel notificacion) {
        contenedor.setVisible(true);
        try {
            this.ps = this.bd.getConexion().prepareStatement("DELETE FROM Categoria WHERE CategoriaID = ?");
            this.ps.setString(1, categoria.getCategoriaID());
            this.ps.execute();
            contenedor.setBackground(new Color(45,144,54));
            notificacion.setText("<html><center>Se ha eliminado con exito la categoria!</center></html>");
        } catch (SQLException ex) {
            contenedor.setBackground(new Color(220,24,24));
            notificacion.setText("<html><center>No se puede eliminar la categoria debido a que ya esta en uso!.</center></html>");
        }
    }
}
