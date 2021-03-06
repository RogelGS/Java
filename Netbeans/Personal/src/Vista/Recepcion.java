/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorCategoria;
import Controlador.ControladorPiso;
import Controlador.ControladorRecepcion;
import java.awt.Dimension;
import java.awt.event.ItemEvent;

/**
 *
 * @author KSGAMER
 */
public class Recepcion extends javax.swing.JPanel {
    private ControladorRecepcion recepcion;
    private ControladorPiso pisos;
    private ControladorCategoria categorias;
    private Principal principal;
    /**
     * Creates new form Recepcion
     * @param principal
     */
    public Recepcion(Principal principal) {
        initComponents();
        this.principal = principal;
        this.setBounds(0, 0, 1100, 670);
        cargarPisos();
        cargarCategorias();
        configuracionInicial();
        cargarPaneles("", "", 0);
    }
    
    public void cargarPisos() {
        cbPiso.removeAllItems();
        cbPiso.addItem("Seleccione un piso");
        this.pisos = new ControladorPiso();
        this.pisos.listaPisos().forEach((objetoPiso) -> {
            cbPiso.addItem(objetoPiso.getPisoID());
        });
        cbPiso.setSelectedIndex(0);
    }
    
    public void cargarCategorias() {
        cbCategoria.removeAllItems();
        cbCategoria.addItem("Seleccione una categoria");
        this.categorias = new ControladorCategoria();
        this.categorias.listaCategorias().forEach((objetoCategoria) -> {
            cbCategoria.addItem(objetoCategoria.getCategoriaID());
        });
        cbCategoria.setSelectedIndex(0);
    }
    
    public void configuracionInicial() {
        scroll.getVerticalScrollBar().setUnitIncrement(20);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
    }
    
    public void cargarPaneles(String piso, String categoria, int estado) {
        recepcion = new ControladorRecepcion();
        recepcion.cargarHabitaciones(principal, contenedor, piso, categoria, String.valueOf(estado));
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
        lbCargar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        contenedor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbPiso = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setLayout(null);

        lbCargar.setBackground(new java.awt.Color(45, 144, 54));
        lbCargar.setOpaque(true);
        jPanel1.add(lbCargar);
        lbCargar.setBounds(0, 0, 0, 4);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1100, 4);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(106, 150, 176));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" M??dulo de Recepci??n");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, 0, 1100, 40);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 1100, 40);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scroll.setBorder(null);

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setLayout(new java.awt.GridLayout(0, 3, 10, 10));
        scroll.setViewportView(contenedor);

        jPanel5.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1040, 510));

        jPanel4.add(jPanel5);
        jPanel5.setBounds(20, 70, 1060, 540);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Estado:");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(510, 25, 100, 15);

        cbPiso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un piso" }));
        cbPiso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPisoItemStateChanged(evt);
            }
        });
        jPanel4.add(cbPiso);
        cbPiso.setBounds(30, 40, 200, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Piso:");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(30, 25, 100, 15);

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una categoria" }));
        cbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCategoriaItemStateChanged(evt);
            }
        });
        jPanel4.add(cbCategoria);
        cbCategoria.setBounds(270, 40, 200, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Categoria:");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(270, 25, 100, 15);

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un estado", "Disponible", "Reservado", "Limpieza", "Mantenimiento" }));
        cbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEstadoItemStateChanged(evt);
            }
        });
        jPanel4.add(cbEstado);
        cbEstado.setBounds(510, 40, 200, 25);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(0, 40, 1100, 630);

        add(jPanel2);
        jPanel2.setBounds(0, 4, 1100, 666);
    }// </editor-fold>//GEN-END:initComponents

    private void cbPisoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPisoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cargarPaneles(cbPiso.getSelectedItem().toString(), cbCategoria.getSelectedItem().toString(), cbEstado.getSelectedIndex());
        }
    }//GEN-LAST:event_cbPisoItemStateChanged

    private void cbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCategoriaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cargarPaneles(cbPiso.getSelectedItem().toString(), cbCategoria.getSelectedItem().toString(), cbEstado.getSelectedIndex());
        }
    }//GEN-LAST:event_cbCategoriaItemStateChanged

    private void cbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEstadoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cargarPaneles(cbPiso.getSelectedItem().toString(), cbCategoria.getSelectedItem().toString(), cbEstado.getSelectedIndex());
        }
    }//GEN-LAST:event_cbEstadoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbPiso;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbCargar;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
