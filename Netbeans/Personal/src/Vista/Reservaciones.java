/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorCampos;
import Controlador.ControladorCliente;
import Controlador.ControladorHabitacion;
import Controlador.ControladorReservacion;
import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author KSGAMER
 */
public class Reservaciones extends javax.swing.JPanel {

    private DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
    private ControladorCampos campos = new ControladorCampos();
    private Calendar fechaActual = Calendar.getInstance();
    private SimpleDateFormat estandar = new SimpleDateFormat("yyyy-MM-dd");
    private Principal principal;
    private ControladorReservacion reservacion;
    private ControladorCliente cliente;
    private ControladorHabitacion habitaciones;
    private int reservacionID;
    private boolean botones = false;

    /**
     * Creates new form Reservaciones
     *
     * @param principal
     */
    public Reservaciones(Principal principal) {
        initComponents();
        this.principal = principal;
        this.setBounds(0, 0, 1100, 670);
        cargarClientes();
        cargarTabla("");
        configuracionInicial();
    }

    public void configuracionInicial() {
        AutoCompleteDecorator.decorate(cbCliente);
        notificacion.setVisible(false);
        errorCliente.setVisible(false);
        errorHabitacion.setVisible(false);
        cargarFechas();
    }

    public void cargarFechas() {
        dcFechaIngreso.setDate(fechaActual.getTime());
        dcFechaSalida.setDate(fechaActual.getTime());
    }

    public void cargarClientes() {
        cbCliente.removeAllItems();
        cbCliente.addItem("Seleccione un cliente");
        this.cliente = new ControladorCliente();
        this.cliente.listaClientes().forEach((objetoCliente) -> {
            cbCliente.addItem(objetoCliente.getNombre());
        });
        cbCliente.setSelectedIndex(0);
    }

    public void cargarTabla(String busqueda) {
        tbReservaciones.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
        tbReservaciones.getTableHeader().setOpaque(false);
        tbReservaciones.getTableHeader().setBackground(new Color(32, 136, 203));
        tbReservaciones.getTableHeader().setForeground(new Color(255, 255, 255));
        ((DefaultTableCellHeaderRenderer) tbReservaciones.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        habitaciones = new ControladorHabitacion();
        reservacion = new ControladorReservacion();
        tbReservaciones.setModel(reservacion.tablaReservaciones(busqueda));
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        tbReservaciones.getColumnModel().getColumn(0).setCellRenderer(cellRender);
        tbReservaciones.getColumnModel().getColumn(1).setCellRenderer(cellRender);
        tbReservaciones.getColumnModel().getColumn(2).setCellRenderer(cellRender);
        tbReservaciones.getColumnModel().getColumn(3).setCellRenderer(cellRender);
        tbReservaciones.getColumnModel().getColumn(4).setCellRenderer(cellRender);
        tbReservaciones.getColumnModel().getColumn(5).setCellRenderer(cellRender);
        tbReservaciones.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbReservaciones.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbReservaciones.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbReservaciones.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbReservaciones.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbReservaciones.getColumnModel().getColumn(5).setPreferredWidth(50);
    }

    public void cargar(int contador) {
        lbCargar.setVisible(true);
        new Thread() {
            public void run() {
                for (int i = contador; i <= 1100; i += 4) {
                    try {
                        lbCargar.setBounds(0, 0, i, 4);
                        this.sleep(0, 2);
                    } catch (InterruptedException ex) {

                    }
                }
                lbCargar.setBounds(0, 0, 0, 4);
            }
        }.start();
    }

    public void insertarReservaciones() {
        cargar(20);
        this.habitaciones.actualizarHabitacionesEstado(txtHabitacion.getText(), "2");
        this.reservacion.insertarReservaciones(txtHabitacion.getText(), cbCliente.getSelectedItem().toString(), Date.valueOf(estandar.format(dcFechaIngreso.getDate())), Date.valueOf(estandar.format(dcFechaSalida.getDate())), "1", notificacion, mensaje);
    }

    public void actualizarReservaciones() {
        cargar(20);
        this.reservacion.actualizarReservaciones(txtHabitacion.getText(), cbCliente.getSelectedItem().toString(), Date.valueOf(estandar.format(dcFechaIngreso.getDate())), Date.valueOf(estandar.format(dcFechaSalida.getDate())), "1", reservacionID, notificacion, mensaje);
    }

    public void eliminarReservaciones() {
        cargar(20);
        this.habitaciones.actualizarHabitacionesEstado(txtHabitacion.getText(), "1");
        this.reservacion.eliminarReservaciones(reservacionID, notificacion, mensaje);
        botones = false;
    }

    public void cargarHabitacion(String habitacion) {
        txtHabitacion.setText(habitacion);
        botones = false;
        btnEliminar.setEnabled(false);
        btnCobrar.setVisible(false);
        cargarClientes();
        cargarFechas();
    }

    public void cargaHabitacionDatos(String habitacion) {
        this.reservacion.listaReservaciones().stream().filter((objetoReservacion) -> (objetoReservacion.getHabitacionID().equals(habitacion)) && objetoReservacion.getEstado().equals("1")).forEachOrdered((objetoReservacion) -> {
            btnAgregarModificar.setToolTipText("Modificar");
            btnAgregarModificar.setIcon(new ImageIcon("src/Imagen/Principal/modificar-24.png"));
            btnCobrar.setVisible(true);
            btnAgregarModificar.setBackground(new Color(255, 181, 62));
            botones = true;
            btnEliminar.setEnabled(true);
            reservacionID = objetoReservacion.getReservacionID();
            cbCliente.setSelectedItem(objetoReservacion.getClienteID());
            dcFechaIngreso.setDate(objetoReservacion.getFechaIngreso());
            dcFechaSalida.setDate(objetoReservacion.getFechaSalida());
        });
    }

    public boolean verificar() {
        boolean campo = true;
        if (txtHabitacion.getText().contains("Seleccione")) {
            campo = false;
            errorHabitacion.setVisible(true);
        }
        if (cbCliente.getSelectedItem().toString().contains("Seleccione")) {
            campo = false;
            errorCliente.setVisible(true);
        }
        return campo;
    }

    public void mensaje() {
        notificacion.setVisible(true);
        notificacion.setBackground(new Color(220, 24, 24));
        mensaje.setText("Verifique que los campos estan llenados");
    }

    public void habilitarBotones() {
        botones = true;
        cbCliente.setEnabled(true);
        dcFechaIngreso.setEnabled(true);
        dcFechaSalida.setEnabled(true);
        btnAgregarModificar.setToolTipText("Modificar");
        btnAgregarModificar.setIcon(new ImageIcon("src/Imagen/Principal/modificar-24.png"));
        btnAgregarModificar.setBackground(new Color(255, 181, 62));
        btnEliminar.setEnabled(true);
    }

    public void cerrarNotificacion() {
        notificacion.setVisible(false);
    }

    public void cancelar() {
        botones = false;
        btnAgregarModificar.setToolTipText("Agregar");
        btnAgregarModificar.setIcon(new ImageIcon("src/Imagen/Principal/agregar-24.png"));
        btnAgregarModificar.setBackground(new Color(35, 144, 35));
        btnEliminar.setEnabled(false);
        errorCliente.setVisible(false);
        errorHabitacion.setVisible(false);
        txtHabitacion.setText("Seleccione la habitación");
        buscar.setText("Buscar una reservación");
        cargarTabla("");
        cargarFechas();
        cargarClientes();
    }

    public void seleccionar(int seleccion) {
        habilitarBotones();
        this.reservacion.listaReservaciones().stream().filter((listaReservaciones) -> (Integer.parseInt(tbReservaciones.getValueAt(seleccion, 0).toString()) == listaReservaciones.getReservacionID())).forEachOrdered((listaReservaciones) -> {
            reservacionID = listaReservaciones.getReservacionID();
            txtHabitacion.setText(listaReservaciones.getHabitacionID());
            cbCliente.setSelectedItem(listaReservaciones.getClienteID());
            dcFechaIngreso.setDate(listaReservaciones.getFechaIngreso());
            dcFechaSalida.setDate(listaReservaciones.getFechaSalida());
        });
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
        regresar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbReservaciones = new javax.swing.JTable();
        buscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAgregarModificar = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JLabel();
        notificacion = new javax.swing.JPanel();
        mensaje = new javax.swing.JLabel();
        cerrarNotificacion = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHabitacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        dcFechaSalida = new com.toedter.calendar.JDateChooser();
        dcFechaIngreso = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        errorCliente = new javax.swing.JLabel();
        errorHabitacion = new javax.swing.JLabel();
        clientes = new javax.swing.JLabel();
        btnCobrar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setLayout(null);

        lbCargar.setBackground(new java.awt.Color(45, 144, 54));
        lbCargar.setOpaque(true);
        jPanel1.add(lbCargar);
        lbCargar.setBounds(0, 0, 0, 4);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(106, 150, 176));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Módulo de Reservaciones");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, 0, 1060, 40);

        regresar.setBackground(new java.awt.Color(0, 153, 255));
        regresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Principal/regresar-20.png"))); // NOI18N
        regresar.setToolTipText("Regresar a recepción");
        regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regresar.setOpaque(true);
        regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regresarMouseClicked(evt);
            }
        });
        jPanel3.add(regresar);
        regresar.setBounds(1060, 0, 40, 40);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 1100, 40);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        tbReservaciones = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        tbReservaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbReservaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbReservaciones.setSelectionBackground(new java.awt.Color(77, 167, 238));
        tbReservaciones.setShowVerticalLines(false);
        tbReservaciones.getTableHeader().setResizingAllowed(false);
        tbReservaciones.getTableHeader().setReorderingAllowed(false);
        tbReservaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbReservacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbReservaciones);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 590, 490);

        buscar.setText("Buscar una reservación");
        buscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                buscarFocusLost(evt);
            }
        });
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarKeyTyped(evt);
            }
        });
        jPanel4.add(buscar);
        buscar.setBounds(30, 45, 590, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Buscar:");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(30, 30, 44, 15);

        btnAgregarModificar.setBackground(new java.awt.Color(35, 144, 35));
        btnAgregarModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregarModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Principal/agregar-24.png"))); // NOI18N
        btnAgregarModificar.setToolTipText("Agregar");
        btnAgregarModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarModificar.setOpaque(true);
        btnAgregarModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarModificarMouseClicked(evt);
            }
        });
        jPanel4.add(btnAgregarModificar);
        btnAgregarModificar.setBounds(790, 340, 30, 32);

        btnEliminar.setBackground(new java.awt.Color(220, 24, 24));
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Principal/eliminar-20.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setEnabled(false);
        btnEliminar.setOpaque(true);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        jPanel4.add(btnEliminar);
        btnEliminar.setBounds(840, 340, 30, 32);

        btnCancelar.setBackground(new java.awt.Color(48, 165, 255));
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Principal/cancelar-24.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setOpaque(true);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        jPanel4.add(btnCancelar);
        btnCancelar.setBounds(890, 340, 30, 32);

        notificacion.setBackground(new java.awt.Color(220, 24, 24));
        notificacion.setLayout(null);

        mensaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mensaje.setForeground(new java.awt.Color(255, 255, 255));
        mensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensaje.setText("jLabel7");
        notificacion.add(mensaje);
        mensaje.setBounds(0, 0, 1075, 20);

        cerrarNotificacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cerrarNotificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Principal/cerrarNotificacion-16.png"))); // NOI18N
        cerrarNotificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarNotificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarNotificacionMouseClicked(evt);
            }
        });
        notificacion.add(cerrarNotificacion);
        cerrarNotificacion.setBounds(1080, 0, 20, 20);

        jPanel4.add(notificacion);
        notificacion.setBounds(0, 606, 1100, 20);

        jPanel5.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Habitación:");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(20, 25, 80, 15);

        jLabel3.setBackground(new java.awt.Color(220, 24, 24));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Principal/reportar-20.png"))); // NOI18N
        jLabel3.setToolTipText("Reportar incidencia");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setOpaque(true);
        jPanel5.add(jLabel3);
        jLabel3.setBounds(315, 40, 25, 25);

        txtHabitacion.setText("Seleccione una habitación");
        txtHabitacion.setEnabled(false);
        jPanel5.add(txtHabitacion);
        txtHabitacion.setBounds(20, 40, 280, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Cliente:");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(20, 85, 60, 15);

        cbCliente.setEditable(true);
        cbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un cliente" }));
        jPanel5.add(cbCliente);
        cbCliente.setBounds(20, 100, 280, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Fecha de ingreso:");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(20, 145, 130, 15);
        jPanel5.add(dcFechaSalida);
        dcFechaSalida.setBounds(20, 220, 320, 25);
        jPanel5.add(dcFechaIngreso);
        dcFechaIngreso.setBounds(20, 160, 320, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Fecha de salida:");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(20, 205, 150, 15);

        errorCliente.setBackground(new java.awt.Color(220, 24, 24));
        errorCliente.setOpaque(true);
        jPanel5.add(errorCliente);
        errorCliente.setBounds(20, 125, 280, 2);

        errorHabitacion.setBackground(new java.awt.Color(220, 24, 24));
        errorHabitacion.setOpaque(true);
        jPanel5.add(errorHabitacion);
        errorHabitacion.setBounds(20, 65, 280, 2);

        clientes.setBackground(new java.awt.Color(35, 144, 35));
        clientes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clientes.setForeground(new java.awt.Color(255, 255, 255));
        clientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clientes.setText("+");
        clientes.setToolTipText("Agregar clientes");
        clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clientes.setOpaque(true);
        clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientesMouseClicked(evt);
            }
        });
        jPanel5.add(clientes);
        clientes.setBounds(315, 100, 25, 25);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(670, 45, 360, 270);

        btnCobrar.setBackground(new java.awt.Color(30, 191, 174));
        btnCobrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Principal/cobrar-24.png"))); // NOI18N
        btnCobrar.setToolTipText("Cobrar reservación");
        btnCobrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCobrar.setOpaque(true);
        btnCobrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCobrarMouseClicked(evt);
            }
        });
        jPanel4.add(btnCobrar);
        btnCobrar.setBounds(940, 340, 30, 32);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(0, 40, 1100, 630);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbReservacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbReservacionesMouseClicked
        seleccionar(tbReservaciones.rowAtPoint(evt.getPoint()));
    }//GEN-LAST:event_tbReservacionesMouseClicked

    private void buscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarFocusGained
        campos.limpiarCamposFocus(buscar);
    }//GEN-LAST:event_buscarFocusGained

    private void buscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarFocusLost
        campos.configurarCampoFocus(buscar, "Buscar una reservación");
    }//GEN-LAST:event_buscarFocusLost

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
        campos.limpiarCamposFocus(buscar);
    }//GEN-LAST:event_buscarMouseClicked

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        cargarTabla(buscar.getText());
    }//GEN-LAST:event_buscarKeyTyped

    private void btnAgregarModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarModificarMouseClicked
        if (verificar() == true) {
            if (btnAgregarModificar.getIcon().toString().contains("agregar")) {
                insertarReservaciones();
                cancelar();
            } else {
                actualizarReservaciones();
                cargarTabla("");
            }
        } else {
            mensaje();
        }
    }//GEN-LAST:event_btnAgregarModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        if (botones == true) {
            eliminarReservaciones();
            cancelar();
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        cancelar();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void cerrarNotificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarNotificacionMouseClicked
        cerrarNotificacion();
    }//GEN-LAST:event_cerrarNotificacionMouseClicked

    private void regresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarMouseClicked
        cancelar();
        principal.recepcion();
    }//GEN-LAST:event_regresarMouseClicked

    private void clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesMouseClicked
        principal.clientes(txtHabitacion.getText());
    }//GEN-LAST:event_clientesMouseClicked

    private void btnCobrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCobrarMouseClicked
        principal.cobros(txtHabitacion.getText(), reservacionID);
    }//GEN-LAST:event_btnCobrarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregarModificar;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnCobrar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JTextField buscar;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JLabel cerrarNotificacion;
    private javax.swing.JLabel clientes;
    private com.toedter.calendar.JDateChooser dcFechaIngreso;
    private com.toedter.calendar.JDateChooser dcFechaSalida;
    private javax.swing.JLabel errorCliente;
    private javax.swing.JLabel errorHabitacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCargar;
    private javax.swing.JLabel mensaje;
    private javax.swing.JPanel notificacion;
    private javax.swing.JLabel regresar;
    private javax.swing.JTable tbReservaciones;
    private javax.swing.JTextField txtHabitacion;
    // End of variables declaration//GEN-END:variables
}
