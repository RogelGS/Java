/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloPisos;
import Objeto.ObjetoPiso;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KSGAMER
 */
public class ControladorPiso {
    private ModeloPisos pisos = new ModeloPisos();
    
    public DefaultTableModel tablaPisos(String filtro) {
        String[] columnas = {"Piso"};
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        int i = 0;
        for (ObjetoPiso piso : this.pisos.getPisos()) {
            if(piso.getPisoID().contains(filtro)) {
                tabla.addRow((Object[]) null);
                tabla.setValueAt(piso.getPisoID(), i, 0);
                i++;
            }
        }
        return tabla;
    }
    
    public ArrayList<ObjetoPiso> listaPisos() {
        return this.pisos.getPisos();
    }
    
    public void insertarPisos(String piso, JPanel contenedor, JLabel notificacion) {
        this.pisos.insertPisos(new ObjetoPiso(piso), contenedor, notificacion);
    }
    
    public void actualizarPisos(String pisoNuevo, String pisoViejo, JPanel contenedor, JLabel notificacion) {
        ObjetoPiso[] piso = {new ObjetoPiso(pisoNuevo), new ObjetoPiso(pisoViejo)};
        this.pisos.updatePisos(piso, contenedor, notificacion);
    }
    
    public void eliminarPisos(String piso, JPanel contenedor, JLabel notificacion) {
        this.pisos.deletePisos(new ObjetoPiso(piso), contenedor, notificacion);
    }
}
