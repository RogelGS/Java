/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloClientes;
import Objeto.ObjetoCliente;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KSGAMER
 */
public class ControladorCliente {

    private ModeloClientes clientes = new ModeloClientes();

    public DefaultTableModel tablaClientes(String filtro) {
        String[] columnas = {"No.", "Nombre", "RFC", "Telefono", "Correo"};
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        int indice = 0;
        for (ObjetoCliente cliente : this.clientes.getClientes()) {
            if (cliente.getNombre().contains(filtro) || String.valueOf(cliente.getClienteID()).contains(filtro) || cliente.getCorreo().contains(filtro) || cliente.getRfc().contains(filtro) || cliente.getTelefono().contains(filtro)) {
                tabla.addRow((Object[]) null);
                tabla.setValueAt(cliente.getClienteID(), indice, 0);
                tabla.setValueAt(cliente.getNombre(), indice, 1);
                tabla.setValueAt(cliente.getRfc(), indice, 2);
                tabla.setValueAt(cliente.getTelefono(), indice, 3);
                tabla.setValueAt(cliente.getCorreo(), indice, 4);
                indice++;
            }
        }
        return tabla;
    }

    public ArrayList<ObjetoCliente> listaClientes() {
        return this.clientes.getClientes();
    }

    @SuppressWarnings("UnusedAssignment")
    public void insertarClientes(String nombre, String rfc, String telefono, String correo, JPanel contenedor, JLabel notificacion) {
        if (rfc.contains("Ingrese")) {
            rfc = "";
        }
        if (telefono.contains("Ingrese")) {
            telefono = "";
        }
        if (correo.contains("Ingrese")) {
            correo = "";
        }
        this.clientes.insertClientes(new ObjetoCliente(0, nombre, rfc, telefono, correo), contenedor, notificacion);
    }

    public void actualizarClientes(String nombre, String rfc, String telefono, String correo, int clienteID, JPanel contenedor, JLabel notificacion) {
        if (rfc.contains("Ingrese")) {
            rfc = "";
        }
        if (telefono.contains("Ingrese")) {
            telefono = "";
        }
        if (correo.contains("Ingrese")) {
            correo = "";
        }
        this.clientes.updateClientes(new ObjetoCliente(clienteID, nombre, rfc, telefono, correo), contenedor, notificacion);
    }

    public void eliminarClientes(int clienteID, JPanel contenedor, JLabel notificacion) {
        this.clientes.deleteClientes(new ObjetoCliente(clienteID, null, null, null, null), contenedor, notificacion);
    }
}
