/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utileria;

import Vista.Principal;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author KSGAMER
 */
public class Habitacion extends javax.swing.JPanel {
    private Color disponible = new Color(35, 144, 35);
    private Color disponibleHabitacion = new Color(26, 128, 26);
    private Color reservado = new Color(234, 4, 4);
    private Color reservadoHabitacion = new Color(199, 9, 9);
    private Color limpieza = new Color(5, 140, 230);
    private Color limpiezaHabitacion = new Color(12, 108, 171);
    private Color mantenimiento = new Color(51, 51, 51);
    private Color mantenimientoHabitacion = new Color(16, 15, 15);
    private Principal principal;
    /**
     * Creates new form Habitacion
     * @param principal
     */
    public Habitacion(Principal principal) {
        initComponents();
        this.principal = principal;
    }

    public JPanel getPersonalizacion(String habitacion, String categoria, String precioHora, String precioDia, String estado) {
        lbHabitacion.setText(habitacion);
        lbCategoria.setText(categoria);
        if (Double.parseDouble(precioHora) == 0) {
            precioHora = "No Aplica";
        } else {
            precioHora = "$ " + precioHora + "0";
        }
        lbPrecioHora.setText(" Precio por Hora: " + precioHora);
        lbPrecioDia.setText(" Precio por Día: $ " + precioDia + "0");
        lbEstado.setText(estado);
        switch (estado) {
            case "Disponible": {
                setBackground(disponible);
                lbHabitacion.setBackground(disponibleHabitacion);
                break;
            }
            case "Reservado": {
                setBackground(reservado);
                lbHabitacion.setBackground(reservadoHabitacion);
                break;
            }
            case "Limpieza": {
                setBackground(limpieza);
                lbHabitacion.setBackground(limpiezaHabitacion);
                break;
            }
            case "Mantenimiento": {
                setBackground(mantenimiento);
                lbHabitacion.setBackground(mantenimientoHabitacion);
                break;
            }
        }
        return this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbImagen = new javax.swing.JLabel();
        lbHabitacion = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        lbEstado = new javax.swing.JLabel();
        lbPrecioHora = new javax.swing.JLabel();
        lbPrecioDia = new javax.swing.JLabel();

        setBackground(new java.awt.Color(35, 144, 35));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(340, 200));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        lbImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Principal/habitacion-128.png"))); // NOI18N
        jPanel1.add(lbImagen);
        lbImagen.setBounds(-40, 50, 150, 140);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 180));

        lbHabitacion.setBackground(new java.awt.Color(26, 128, 26));
        lbHabitacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbHabitacion.setForeground(new java.awt.Color(255, 255, 255));
        lbHabitacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHabitacion.setText("Habitación");
        lbHabitacion.setOpaque(true);
        add(lbHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 25));

        lbCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lbCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCategoria.setText("Categoria");
        add(lbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 230, 30));

        lbEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbEstado.setForeground(new java.awt.Color(255, 255, 255));
        lbEstado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbEstado.setText("Estado");
        add(lbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 150, -1));

        lbPrecioHora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbPrecioHora.setForeground(new java.awt.Color(255, 255, 255));
        lbPrecioHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPrecioHora.setText("Precio por hora");
        add(lbPrecioHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 230, -1));

        lbPrecioDia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbPrecioDia.setForeground(new java.awt.Color(255, 255, 255));
        lbPrecioDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPrecioDia.setText("Precio por día");
        add(lbPrecioDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 230, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        principal.reservaciones(lbHabitacion.getText());
        principal.habitacionReservada(lbHabitacion.getText());
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbHabitacion;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JLabel lbPrecioDia;
    private javax.swing.JLabel lbPrecioHora;
    // End of variables declaration//GEN-END:variables
}
