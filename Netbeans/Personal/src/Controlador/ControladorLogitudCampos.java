/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author KSGAMER
 */
public class ControladorLogitudCampos {

    private void notificacion() {
        Toolkit.getDefaultToolkit().beep();
    }

    public void limitarCaracteres(JTextField campo, java.awt.event.KeyEvent evt, int limitador) {
        if (campo.getText().length() >= limitador) {
            evt.consume();
            notificacion();
        }
    }

    public void limitarCaracteres(JPasswordField campo, java.awt.event.KeyEvent evt, int limitador) {
        if (String.valueOf(campo.getPassword()).length() >= limitador) {
            evt.consume();
            notificacion();
        }
    }

    public void limitarCaracteres(JTextArea campo, java.awt.event.KeyEvent evt, int limitador) {
        if (campo.getText().length() >= limitador) {
            evt.consume();
            notificacion();
        }
    }
}
