/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author KSGAMER
 */
public class ControladorCampos {
    
    public void limpiarCamposFocus(JTextField campo) {
        if(campo.getText().contains("Ingresa") || campo.getText().contains("Buscar") || campo.getText().contains("Ingrese")) {
            campo.setText("");
        }
    }
    
    public void limpiarCamposFocus(JTextArea campo) {
        if(campo.getText().contains("Ingresa") || campo.getText().contains("Buscar") || campo.getText().contains("Ingrese")) {
            campo.setText("");
        }
    }
    
    public void limpiarCamposFocus(JPasswordField campo) {
        if(String.valueOf(campo.getPassword()).contains("Ingresa") || String.valueOf(campo.getPassword()).contains("Buscar") || String.valueOf(campo.getPassword()).contains("Ingrese")) {
            campo.setText("");
        }
    }
    
    public void configurarCampoFocus(JTextField campo, String texto) {
        if(campo.getText().equals("")) {
            campo.setText(texto);
        }
    }
    
    public void configurarCampoFocus(JTextArea campo, String texto) {
        if(campo.getText().equals("")) {
            campo.setText(texto);
        }
    }
    
    public void configurarCampoFocus(JPasswordField campo, String texto) {
        if(String.valueOf(campo.getPassword()).equals("")) {
            campo.setText(texto);
        }
    }
}
