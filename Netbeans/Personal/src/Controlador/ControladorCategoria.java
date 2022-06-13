/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloCategorias;
import Objeto.ObjetoCategoria;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KSGAMER
 */
public class ControladorCategoria {
    private ModeloCategorias categorias = new ModeloCategorias();
    
    public DefaultTableModel tablaCategorias(String filtro) {
        String[] columnas = {"Categoria"};
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        int i = 0;
        for (ObjetoCategoria categoria : this.categorias.getCategorias()) {
            if(categoria.getCategoriaID().contains(filtro)) {
                tabla.addRow((Object[]) null);
                tabla.setValueAt(categoria.getCategoriaID(), i, 0);
                i++;
            }
        }
        return tabla;
    }
    
    public ArrayList<ObjetoCategoria> listaCategorias() {
        return this.categorias.getCategorias();
    }
    
    public void insertarCategorias(String categoria, JPanel contenedor, JLabel notificacion) {
        this.categorias.insertCategorias(new ObjetoCategoria(categoria), contenedor, notificacion);
    }
    
    public void actualizarCategorias(String categoriaNueva, String categoriaVieja, JPanel contenedor, JLabel notificacion) {
        ObjetoCategoria[] categoria = {new ObjetoCategoria(categoriaNueva), new ObjetoCategoria(categoriaVieja)};
        this.categorias.updateCategorias(categoria, contenedor, notificacion);
    }
    
    public void eliminarCategorias(String categoria, JPanel contenedor, JLabel notificacion) {
        this.categorias.deleteCategorias(new ObjetoCategoria(categoria), contenedor, notificacion);
    }
}
