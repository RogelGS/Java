/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorCampos;
import Controlador.ControladorCliente;
import Objeto.ObjetoCliente;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author KSGAMER
 */
public class AltaClientes extends javax.swing.JPanel {
    private DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
    private Principal principal;
    private ControladorCliente clientes;
    private ControladorCampos campos = new ControladorCampos();
    private int clienteID;
    private String habitacionID;

    /**
     * Creates new form AltaClientes
     * @param principal
     */
    public AltaClientes(Principal principal) {
        initComponents();
        this.principal = principal;
        this.setBounds(0, 0, 1100, 670);
        cargarTabla("");
        configuracionInicial();
    }

    public void configuracionInicial() {
        Notificacion.setVisible(false);
        ErrorNombre.setVisible(false);
        mostarRegresar(false);
    }
    
    public void habitacionSeleccionada(String habitacion) {
        habitacionID = habitacion;
    }
    
    public void mostarRegresar(boolean decision) {
        regresar.setVisible(decision);
    }

    public void cargarTabla(String busqueda) {
        tbClientes.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
        tbClientes.getTableHeader().setOpaque(false);
        tbClientes.getTableHeader().setBackground(new Color(32, 136, 203));
        tbClientes.getTableHeader().setForeground(new Color(255, 255, 255));
        ((DefaultTableCellHeaderRenderer)tbClientes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        clientes = new ControladorCliente();
        tbClientes.setModel(this.clientes.tablaClientes(busqueda));
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbClientes.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbClientes.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        tbClientes.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbClientes.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        tbClientes.getColumnModel().getColumn(2).setPreferredWidth(75);
        tbClientes.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        tbClientes.getColumnModel().getColumn(3).setPreferredWidth(50);
        tbClientes.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        tbClientes.getColumnModel().getColumn(4).setPreferredWidth(200);
        tbClientes.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
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

    public void insertarClientes() {
        cargar(20);
        this.clientes.insertarClientes(Nombre.getText(), RFC.getText(), Telefono.getText(), Correo.getText(), Notificacion, Mensaje);
    }
    
    public void actualizarClientes() {
        cargar(20);
        this.clientes.actualizarClientes(Nombre.getText(), RFC.getText(), Telefono.getText(), Correo.getText(), clienteID, Notificacion, Mensaje);
    }
    
    public void eliminarClientes() {
        cargar(20);
        this.clientes.eliminarClientes(clienteID, Notificacion, Mensaje);
    }

    public boolean verificar() {
        boolean campos = true;
        if (Nombre.getText().contains("Ingrese") || Nombre.getText().equals("")) {
            campos = false;
            ErrorNombre.setVisible(true);
        } else {
            ErrorNombre.setVisible(false);
        }
        return campos;
    }

    public void mensaje() {
        Notificacion.setVisible(true);
        Notificacion.setBackground(new Color(220, 24, 24));
        Mensaje.setText("Verifique que los campos estan llenados");
    }

    public void habilitarBotones() {
        AgregarModificar.setToolTipText("Modificar");
        AgregarModificar.setIcon(new ImageIcon("src/Imagen/Principal/modificar-24.png"));
        AgregarModificar.setBackground(new Color(255, 181, 62));
        Eliminar.setEnabled(true);
    }

    public void cerrarNotificacion() {
        Notificacion.setVisible(false);
    }

    public void cancelar() {
        AgregarModificar.setToolTipText("Agregar");
        AgregarModificar.setIcon(new ImageIcon("src/Imagen/Principal/agregar-24.png"));
        AgregarModificar.setBackground(new Color(35, 144, 35));
        Eliminar.setEnabled(false);
        Nombre.setText("Ingrese el nombre del cliente");
        RFC.setText("Ingrese el rfc del cliente");
        Telefono.setText("Ingrese el telefono del cliente");
        Correo.setText("Ingrese el correo del cliente");
        Buscar.setText("Buscar un cliente");
        ErrorNombre.setVisible(false);
        cargarTabla("");
    }

    public void seleccionar(int seleccion) {
        habilitarBotones();
        this.clientes.listaClientes().stream().filter((listaCliente) -> (Integer.parseInt(tbClientes.getValueAt(seleccion, 0).toString()) == listaCliente.getClienteID())).forEachOrdered((ObjetoCliente listaCliente) -> {
            clienteID = listaCliente.getClienteID();
            Nombre.setText(listaCliente.getNombre());
            RFC.setText(listaCliente.getRfc());
            Telefono.setText(listaCliente.getTelefono());
            Correo.setText(listaCliente.getCorreo());
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
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ErrorNombre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Telefono = new javax.swing.JTextField();
        Nombre = new javax.swing.JTextField();
        RFC = new javax.swing.JTextField();
        Correo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        Buscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        AgregarModificar = new javax.swing.JLabel();
        Eliminar = new javax.swing.JLabel();
        Cancelar = new javax.swing.JLabel();
        Notificacion = new javax.swing.JPanel();
        Mensaje = new javax.swing.JLabel();
        CerrarNotificacion = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 670));
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
        jLabel1.setText(" Módulo Alta de Clientes");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, 0, 1060, 40);

        regresar.setBackground(new java.awt.Color(0, 153, 255));
        regresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Principal/regresar-20.png"))); // NOI18N
        regresar.setToolTipText("Regresar a reservaciones");
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

        jPanel5.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(30, 30, 110, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("RFC:");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(30, 90, 110, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Correo:");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(30, 210, 110, 15);

        ErrorNombre.setBackground(new java.awt.Color(220, 24, 24));
        ErrorNombre.setOpaque(true);
        jPanel5.add(ErrorNombre);
        ErrorNombre.setBounds(30, 70, 300, 2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Telefono:");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(30, 150, 110, 15);

        Telefono.setText("Ingrese el telefono del cliente");
        Telefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TelefonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TelefonoFocusLost(evt);
            }
        });
        Telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TelefonoMouseClicked(evt);
            }
        });
        jPanel5.add(Telefono);
        Telefono.setBounds(30, 165, 300, 25);

        Nombre.setText("Ingrese el nombre del cliente");
        Nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NombreFocusLost(evt);
            }
        });
        Nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NombreMouseClicked(evt);
            }
        });
        jPanel5.add(Nombre);
        Nombre.setBounds(30, 45, 300, 25);

        RFC.setText("Ingrese el rfc del cliente");
        RFC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                RFCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                RFCFocusLost(evt);
            }
        });
        RFC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RFCMouseClicked(evt);
            }
        });
        jPanel5.add(RFC);
        RFC.setBounds(30, 105, 300, 25);

        Correo.setText("Ingrese el correo del cliente");
        Correo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CorreoFocusLost(evt);
            }
        });
        Correo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CorreoMouseClicked(evt);
            }
        });
        jPanel5.add(Correo);
        Correo.setBounds(30, 225, 300, 25);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(670, 40, 360, 280);

        tbClientes = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbClientes.setSelectionBackground(new java.awt.Color(77, 167, 238));
        tbClientes.setShowVerticalLines(false);
        tbClientes.getTableHeader().setResizingAllowed(false);
        tbClientes.getTableHeader().setReorderingAllowed(false);
        tbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbClientes);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 590, 490);

        Buscar.setText("Buscar un cliente");
        Buscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BuscarFocusLost(evt);
            }
        });
        Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarMouseClicked(evt);
            }
        });
        Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscarKeyTyped(evt);
            }
        });
        jPanel4.add(Buscar);
        Buscar.setBounds(30, 45, 590, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Buscar:");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(30, 30, 44, 15);

        AgregarModificar.setBackground(new java.awt.Color(35, 144, 35));
        AgregarModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AgregarModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Principal/agregar-24.png"))); // NOI18N
        AgregarModificar.setToolTipText("Agregar");
        AgregarModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AgregarModificar.setOpaque(true);
        AgregarModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AgregarModificarMouseClicked(evt);
            }
        });
        jPanel4.add(AgregarModificar);
        AgregarModificar.setBounds(790, 350, 32, 32);

        Eliminar.setBackground(new java.awt.Color(220, 24, 24));
        Eliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Principal/eliminar-20.png"))); // NOI18N
        Eliminar.setToolTipText("Eliminar");
        Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Eliminar.setEnabled(false);
        Eliminar.setOpaque(true);
        Eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarMouseClicked(evt);
            }
        });
        jPanel4.add(Eliminar);
        Eliminar.setBounds(840, 350, 32, 32);

        Cancelar.setBackground(new java.awt.Color(48, 165, 255));
        Cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Principal/cancelar-24.png"))); // NOI18N
        Cancelar.setToolTipText("Cancelar");
        Cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancelar.setOpaque(true);
        Cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelarMouseClicked(evt);
            }
        });
        jPanel4.add(Cancelar);
        Cancelar.setBounds(890, 350, 32, 32);

        Notificacion.setBackground(new java.awt.Color(220, 24, 24));
        Notificacion.setLayout(null);

        Mensaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Mensaje.setForeground(new java.awt.Color(255, 255, 255));
        Mensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mensaje.setText("jLabel7");
        Notificacion.add(Mensaje);
        Mensaje.setBounds(0, 0, 1075, 20);

        CerrarNotificacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CerrarNotificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Principal/cerrarNotificacion-16.png"))); // NOI18N
        CerrarNotificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CerrarNotificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarNotificacionMouseClicked(evt);
            }
        });
        Notificacion.add(CerrarNotificacion);
        CerrarNotificacion.setBounds(1080, 0, 20, 20);

        jPanel4.add(Notificacion);
        Notificacion.setBounds(0, 606, 1100, 20);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(0, 40, 1100, 630);

        add(jPanel2);
        jPanel2.setBounds(0, 4, 1100, 666);
    }// </editor-fold>//GEN-END:initComponents

    private void tbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientesMouseClicked
        seleccionar(tbClientes.rowAtPoint(evt.getPoint()));
    }//GEN-LAST:event_tbClientesMouseClicked

    private void BuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarFocusGained
        campos.limpiarCamposFocus(Buscar);
    }//GEN-LAST:event_BuscarFocusGained

    private void BuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarFocusLost
        campos.configurarCampoFocus(Buscar, "Buscar un cliente");
    }//GEN-LAST:event_BuscarFocusLost

    private void BuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarKeyTyped
        cargarTabla(Buscar.getText());
    }//GEN-LAST:event_BuscarKeyTyped

    private void AgregarModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgregarModificarMouseClicked
        if (verificar() == true) {
            if (AgregarModificar.getIcon().toString().contains("agregar")) {
                insertarClientes();
            } else {
                actualizarClientes();
            }
            cancelar();
        } else {
            mensaje();
        }
    }//GEN-LAST:event_AgregarModificarMouseClicked

    private void EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarMouseClicked
        eliminarClientes();
        cancelar();
    }//GEN-LAST:event_EliminarMouseClicked

    private void CancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarMouseClicked
        cancelar();
    }//GEN-LAST:event_CancelarMouseClicked

    private void CerrarNotificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarNotificacionMouseClicked
        cerrarNotificacion();
    }//GEN-LAST:event_CerrarNotificacionMouseClicked

    private void NombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NombreFocusGained
        campos.limpiarCamposFocus(Nombre);
    }//GEN-LAST:event_NombreFocusGained

    private void NombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NombreFocusLost
        campos.configurarCampoFocus(Nombre, "Ingrese el nombre del cliente");
    }//GEN-LAST:event_NombreFocusLost

    private void RFCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RFCFocusGained
        campos.limpiarCamposFocus(RFC);
    }//GEN-LAST:event_RFCFocusGained

    private void RFCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RFCFocusLost
        campos.configurarCampoFocus(RFC, "Ingrese el rfc del cliente");
    }//GEN-LAST:event_RFCFocusLost

    private void TelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TelefonoFocusGained
        campos.limpiarCamposFocus(Telefono);
    }//GEN-LAST:event_TelefonoFocusGained

    private void TelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TelefonoFocusLost
        campos.configurarCampoFocus(Telefono, "Ingrese el telefono del cliente");
    }//GEN-LAST:event_TelefonoFocusLost

    private void CorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CorreoFocusGained
        campos.limpiarCamposFocus(Correo);
    }//GEN-LAST:event_CorreoFocusGained

    private void CorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CorreoFocusLost
        campos.configurarCampoFocus(Correo, "Ingrese el correo del cliente");
    }//GEN-LAST:event_CorreoFocusLost

    private void NombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreMouseClicked
        campos.limpiarCamposFocus(Nombre);
    }//GEN-LAST:event_NombreMouseClicked

    private void RFCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RFCMouseClicked
        campos.limpiarCamposFocus(RFC);
    }//GEN-LAST:event_RFCMouseClicked

    private void TelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelefonoMouseClicked
        campos.limpiarCamposFocus(Telefono);
    }//GEN-LAST:event_TelefonoMouseClicked

    private void CorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CorreoMouseClicked
        campos.limpiarCamposFocus(Correo);
    }//GEN-LAST:event_CorreoMouseClicked

    private void BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseClicked
        campos.limpiarCamposFocus(Buscar);
    }//GEN-LAST:event_BuscarMouseClicked

    private void regresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarMouseClicked
        cancelar();
        principal.reservaciones(habitacionID);
        principal.habitacionReservada(habitacionID);
    }//GEN-LAST:event_regresarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AgregarModificar;
    private javax.swing.JTextField Buscar;
    private javax.swing.JLabel Cancelar;
    private javax.swing.JLabel CerrarNotificacion;
    private javax.swing.JTextField Correo;
    private javax.swing.JLabel Eliminar;
    private javax.swing.JLabel ErrorNombre;
    private javax.swing.JLabel Mensaje;
    private javax.swing.JTextField Nombre;
    private javax.swing.JPanel Notificacion;
    private javax.swing.JTextField RFC;
    private javax.swing.JTextField Telefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCargar;
    private javax.swing.JLabel regresar;
    private javax.swing.JTable tbClientes;
    // End of variables declaration//GEN-END:variables
}
