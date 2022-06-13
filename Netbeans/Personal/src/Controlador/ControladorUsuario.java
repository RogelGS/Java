/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloUsuarios;
import Objeto.ObjetoUsuario;
import Vista.Principal;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KSGAMER
 */
public class ControladorUsuario {

    private ModeloUsuarios usuarios = new ModeloUsuarios();

    public DefaultTableModel tablaUsuarios(String filtro) {
        String[] columnas = {"Usuario", "Contraseña", "Estado"};
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        int i = 0;
        for (ObjetoUsuario usuario : this.usuarios.getUsuarios()) {
            if (usuario.getUsuario().contains(filtro)) {
                tabla.addRow((Object[]) null);
                tabla.setValueAt(usuario.getUsuario(), i, 0);
                tabla.setValueAt(usuario.getContrasena(), i, 1);
                if (usuario.getEstado().equals("1")) {
                    tabla.setValueAt("Activo", i, 2);
                } else {
                    tabla.setValueAt("Inactivo", i, 2);
                }
                i++;
            }
        }
        return tabla;
    }

    public ArrayList<ObjetoUsuario> listaUsuarios() {
        return this.usuarios.getUsuarios();
    }

    public void insertarUsuarios(String usuario, String contraseña, String ruta, JPanel contenedor, JLabel notificacion) {
        if (ruta.equals("Seleccione una ruta")) {
            this.usuarios.insertUsuarios(new ObjetoUsuario(usuario, contraseña, null), contenedor, notificacion);
        } else {
            this.usuarios.insertUsuarios(new ObjetoUsuario(usuario, contraseña, conversor(ruta)), contenedor, notificacion);
        }
    }

    public void actualizarUsuarios(String usuario, String contraseña, String ruta, JPanel contenedor, JLabel notificacion) {
        if (ruta.equals("Seleccione una ruta")) {
            this.usuarios.updateUsuarios(new ObjetoUsuario(usuario, contraseña, null), contenedor, notificacion);
        } else {
            this.usuarios.updateUsuarios(new ObjetoUsuario(usuario, contraseña, conversor(ruta)), contenedor, notificacion);
        }
    }

    public void actualizarEstadoUsuarios(String usuario, String estado, JPanel contenedor, JLabel notificacion) {
        this.usuarios.updateEstadoUsuarios(usuario, estado, contenedor, notificacion);
    }

    public void eliminarUsuarios(String usuario, JPanel contenedor, JLabel notificacion) {
        this.usuarios.deleteUsuarios(new ObjetoUsuario(usuario, null, null), contenedor, notificacion);
    }

    public byte[] conversor(String ruta) {
        File imagen = new File(ruta);
        byte[] imagenDesrenderizada = new byte[(int) imagen.length()];
        try {
            InputStream conversion = new FileInputStream(imagen);
            conversion.read(imagenDesrenderizada);
        } catch (IOException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagenDesrenderizada;
    }

    public boolean autentificacion(String usuario, String contrasena, JLabel notificacion, JFrame sesion) {
        boolean no_Usuario = true;
        for (ObjetoUsuario objetoUsuario : this.usuarios.getUsuarios()) {
            if (usuario.equals(objetoUsuario.getUsuario())) {
                no_Usuario = false;
            }
        }
        if (no_Usuario == true) {
            notificacion.setText("No se ha encontrado el usuario, verifiquelo nuevamente");
            return true;
        }
        boolean no_Contraseña = true;
        for (ObjetoUsuario objetoUsuario : this.usuarios.getUsuarios()) {
            if (contrasena.equals(objetoUsuario.getContrasena())) {
                no_Contraseña = false;
            }
        }
        if (no_Contraseña == true) {
            notificacion.setText("La contraseña es incorrenta");
            return true;
        }
        boolean no_Coincide = true;
        for (ObjetoUsuario objetoUsuario : this.usuarios.getUsuarios()) {
            if (usuario.equals(objetoUsuario.getUsuario()) && contrasena.equals(objetoUsuario.getContrasena())) {
                no_Coincide = false;
                if (Vista.Sesion.sesion == false) {
                        Principal.usuario = objetoUsuario.getUsuario();
                        Principal.imagenBites = objetoUsuario.getImagen();
                        Principal principal = new Principal();
                        principal.setLocationRelativeTo(null);
                        principal.setVisible(true);
                        for (double i = 1; i >= 0; i -= 0.01) {
                            sesion.setOpacity((float) i);
                            try {
                                Thread.sleep(2);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        sesion.setVisible(false);
                        sesion.dispose();
                        return true;
                }
            }
        }
        if(no_Coincide == true) {
            notificacion.setText("No coinciden las credenciales, verifique su contraseña");
            return true;
        }
        return true;
    }
}
