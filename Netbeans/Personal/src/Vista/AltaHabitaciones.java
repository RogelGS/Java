/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorCampos;
import Controlador.ControladorCategoria;
import Controlador.ControladorHabitacion;
import Controlador.ControladorPiso;
import Utileria.AltaCategorias;
import Utileria.AltaPisos;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author KSGAMER
 */
public class AltaHabitaciones extends javax.swing.JPanel {
    private DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
    private AltaPisos pisosModal = new AltaPisos(new JFrame(), true);
    private AltaCategorias categoriasModal = new AltaCategorias(new JFrame(), true);
    private ControladorCampos campos = new ControladorCampos();
    private ControladorPiso pisos;
    private ControladorCategoria categorias;
    private ControladorHabitacion habitaciones;
    private String habitacionID;

    /**
     * Creates new form AltaHotel
     */
    public AltaHabitaciones() {
        initComponents();
        this.setBounds(0, 0, 1100, 670);
        cargarPisos();
        cargarCategorias();
        cargarTabla("");
        configuracionInicial();
    }
    
    public void configuracionInicial() {
        estadoLB.setVisible(false);
        estado.setVisible(false);
        AutoCompleteDecorator.decorate(piso);
        AutoCompleteDecorator.decorate(categoria);
        caracteristicas.setLineWrap(true);
        caracteristicas.setWrapStyleWord(true);
        notificacion.setVisible(false);
        errorNombre.setVisible(false);
        errorPiso.setVisible(false);
        errorCategoria.setVisible(false);
    }
    
    public void cargarPisos() {
        piso.removeAllItems();
        piso.addItem("Seleccione un piso");
        this.pisos = new ControladorPiso();
        this.pisos.listaPisos().forEach((objetoPiso) -> {
            piso.addItem(objetoPiso.getPisoID());
        });
        piso.setSelectedIndex(0);
    }
    
    public void cargarCategorias() {
        categoria.removeAllItems();
        categoria.addItem("Seleccione una categoria");
        this.categorias = new ControladorCategoria();
        this.categorias.listaCategorias().forEach((objetoCategoria) -> {
            categoria.addItem(objetoCategoria.getCategoriaID());
        });
        categoria.setSelectedIndex(0);
    }
    
    public void cargar(int contador) {
        new Thread() {
            public void run() {
                for (int i = contador; i < 702; i+=4) {
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
    
    public void cargarTabla(String busqueda) {
        tbHabitaciones.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
        tbHabitaciones.getTableHeader().setOpaque(false);
        tbHabitaciones.getTableHeader().setBackground(new Color(32, 136, 203));
        tbHabitaciones.getTableHeader().setForeground(new Color(255, 255, 255));
        ((DefaultTableCellHeaderRenderer) tbHabitaciones.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        habitaciones = new ControladorHabitacion();
        tbHabitaciones.setModel(this.habitaciones.tablaHabitaciones(busqueda));
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        tbHabitaciones.getColumnModel().getColumn(0).setCellRenderer(cellRender);
        tbHabitaciones.getColumnModel().getColumn(1).setCellRenderer(cellRender);
        tbHabitaciones.getColumnModel().getColumn(2).setCellRenderer(cellRender);
        tbHabitaciones.getColumnModel().getColumn(3).setCellRenderer(cellRender);
        tbHabitaciones.getColumnModel().getColumn(4).setCellRenderer(cellRender);
        tbHabitaciones.getColumnModel().getColumn(5).setCellRenderer(cellRender);
    }
    
    public void insertarHabitaciones() {
        cargar(20);
        this.habitaciones.insertarHabitaciones(habitacion.getText(), piso.getSelectedItem().toString(), categoria.getSelectedItem().toString(), precio_hora.getText(), precio_dia.getText(), caracteristicas.getText(), "1", notificacion, mensaje);
    }
    
    public void actualizarHabitaciones() {
        cargar(20);
        this.habitaciones.actualizarHabitaciones(habitacion.getText(), piso.getSelectedItem().toString(), categoria.getSelectedItem().toString(), precio_hora.getText(), precio_dia.getText(), caracteristicas.getText(), String.valueOf(estado.getSelectedIndex()+1), habitacionID, notificacion, mensaje);
    }
    
    public void eliminarHabitaciones() {
        cargar(20);
        this.habitaciones.eliminarHabitacion(habitacionID, notificacion, mensaje);
    }
    
    public boolean verificar() {
        boolean campo = true;
        if(habitacion.getText().contains("Ingrese") || habitacion.getText().equals("")) {
            campo = false;
            errorNombre.setVisible(true);
        }
        if(piso.getSelectedItem().toString().contains("Seleccione")) {
            campo = false;
            errorPiso.setVisible(true);
        }
        if(categoria.getSelectedItem().toString().contains("Seleccione")) {
            campo = false;
            errorCategoria.setVisible(true);
        }
        return campo;
    }
    
    public void mensaje() {
        notificacion.setVisible(true);
        notificacion.setBackground(new Color(220, 24, 24));
        mensaje.setText("Verifique que los campos estan llenados.");
    }
    
    public void habilitarBotones() {
        AgregarModificar.setToolTipText("Modificar");
        AgregarModificar.setIcon(new ImageIcon("src/Imagen/Principal/modificar-24.png"));
        AgregarModificar.setBackground(new Color(255, 181, 62));
        Eliminar.setEnabled(true);
        estadoLB.setVisible(true);
        estado.setVisible(true);
    }
    
    public void cerrarNotificacion() {
        notificacion.setVisible(false);
    }
    
    public void cancelar() {
        estadoLB.setVisible(false);
        estado.setVisible(false);
        AgregarModificar.setToolTipText("Agregar");
        AgregarModificar.setIcon(new ImageIcon("src/Imagen/Principal/agregar-24.png"));
        AgregarModificar.setBackground(new Color(35, 144, 35));
        Eliminar.setEnabled(false);
        habitacion.setText("Ingrese el nombre de la habitación");
        piso.setSelectedIndex(0);
        categoria.setSelectedIndex(0);
        precio_hora.setText("Ingrese la cantidad");
        precio_dia.setText("Ingrese la cantidad");
        caracteristicas.setText("Ingrese las caracteristicas");
        buscar.setText("Buscar una habitación");
        errorNombre.setVisible(false);
        errorPiso.setVisible(false);
        errorCategoria.setVisible(false);
        cargarTabla("");
    }
    
    public void seleccionar(int seleccion) {
        habilitarBotones();
        this.habitaciones.listaHabitaciones().stream().filter((objetoHabitacion) -> (objetoHabitacion.getHabitacionID().equals(tbHabitaciones.getValueAt(seleccion, 0)))).forEachOrdered((objetoHabitacion) -> {
            habitacionID = objetoHabitacion.getHabitacionID();
            habitacion.setText(objetoHabitacion.getHabitacionID());
            piso.setSelectedItem(objetoHabitacion.getPisoID());
            categoria.setSelectedItem(objetoHabitacion.getCategoriaID());
            precio_hora.setText(String.valueOf(objetoHabitacion.getPrecioHora()));
            precio_dia.setText(String.valueOf(objetoHabitacion.getPrecioDia()));
            caracteristicas.setText(objetoHabitacion.getCaracteristicas());
            estado.setSelectedIndex(Integer.parseInt(objetoHabitacion.getEstado())-1);
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
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHabitaciones = new javax.swing.JTable();
        buscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        AgregarModificar = new javax.swing.JLabel();
        Eliminar = new javax.swing.JLabel();
        Cancelar = new javax.swing.JLabel();
        notificacion = new javax.swing.JPanel();
        mensaje = new javax.swing.JLabel();
        cerrarNotificacion = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        caracteristicas = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        habitacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        piso = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        categoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        precio_hora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        precio_dia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        errorNombre = new javax.swing.JLabel();
        errorPiso = new javax.swing.JLabel();
        errorCategoria = new javax.swing.JLabel();
        estadoLB = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox<>();

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
        jLabel1.setText(" Módulo Alta de Habitaciones");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, 0, 1100, 40);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 1100, 40);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        tbHabitaciones = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        tbHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        tbHabitaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbHabitaciones.setSelectionBackground(new java.awt.Color(77, 167, 238));
        tbHabitaciones.setShowVerticalLines(false);
        tbHabitaciones.getTableHeader().setResizingAllowed(false);
        tbHabitaciones.getTableHeader().setReorderingAllowed(false);
        tbHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHabitacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHabitaciones);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 590, 490);

        buscar.setText("Buscar una habitación");
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
        AgregarModificar.setBounds(790, 560, 30, 32);

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
        Eliminar.setBounds(840, 560, 30, 32);

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
        Cancelar.setBounds(890, 560, 30, 32);

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

        caracteristicas.setColumns(20);
        caracteristicas.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        caracteristicas.setRows(5);
        caracteristicas.setText("Ingrese las caracteristicas");
        caracteristicas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                caracteristicasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                caracteristicasFocusLost(evt);
            }
        });
        caracteristicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                caracteristicasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(caracteristicas);

        jPanel5.add(jScrollPane2);
        jScrollPane2.setBounds(30, 335, 300, 76);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(30, 20, 60, 15);

        habitacion.setText("Ingrese el nombre de la habitación");
        habitacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                habitacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                habitacionFocusLost(evt);
            }
        });
        habitacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                habitacionMouseClicked(evt);
            }
        });
        jPanel5.add(habitacion);
        habitacion.setBounds(30, 35, 300, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Piso:");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(30, 80, 50, 15);

        piso.setEditable(true);
        piso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un piso", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(piso);
        piso.setBounds(30, 95, 270, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Categoria:");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(30, 140, 80, 15);

        categoria.setEditable(true);
        categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una categoria", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(categoria);
        categoria.setBounds(30, 155, 270, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Precio por hora:");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(30, 200, 110, 15);

        precio_hora.setText("Ingrese la cantidad");
        precio_hora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                precio_horaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                precio_horaFocusLost(evt);
            }
        });
        precio_hora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                precio_horaMouseClicked(evt);
            }
        });
        jPanel5.add(precio_hora);
        precio_hora.setBounds(30, 215, 300, 25);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Precio por día:");
        jPanel5.add(jLabel7);
        jLabel7.setBounds(30, 260, 110, 15);

        precio_dia.setText("Ingrese la cantidad");
        precio_dia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                precio_diaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                precio_diaFocusLost(evt);
            }
        });
        precio_dia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                precio_diaMouseClicked(evt);
            }
        });
        jPanel5.add(precio_dia);
        precio_dia.setBounds(30, 275, 300, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Caracteristicas:");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(30, 320, 100, 15);

        jLabel9.setBackground(new java.awt.Color(0, 153, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("+");
        jLabel9.setToolTipText("Agregar una categoria");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.setOpaque(true);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel9);
        jLabel9.setBounds(305, 155, 25, 25);

        jLabel10.setBackground(new java.awt.Color(0, 153, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("+");
        jLabel10.setToolTipText("Agregar un piso");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.setOpaque(true);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel10);
        jLabel10.setBounds(305, 95, 25, 25);

        errorNombre.setBackground(new java.awt.Color(220, 24, 24));
        errorNombre.setOpaque(true);
        jPanel5.add(errorNombre);
        errorNombre.setBounds(30, 60, 300, 2);

        errorPiso.setBackground(new java.awt.Color(220, 24, 24));
        errorPiso.setOpaque(true);
        jPanel5.add(errorPiso);
        errorPiso.setBounds(30, 120, 270, 2);

        errorCategoria.setBackground(new java.awt.Color(220, 24, 24));
        errorCategoria.setOpaque(true);
        jPanel5.add(errorCategoria);
        errorCategoria.setBounds(30, 180, 270, 2);

        estadoLB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        estadoLB.setText("Estado:");
        jPanel5.add(estadoLB);
        estadoLB.setBounds(30, 430, 60, 15);

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Reservado", "Limpieza", "Mantenimiento" }));
        jPanel5.add(estado);
        estado.setBounds(30, 445, 300, 25);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(670, 45, 360, 500);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(0, 40, 1100, 630);

        add(jPanel2);
        jPanel2.setBounds(0, 4, 1100, 666);
    }// </editor-fold>//GEN-END:initComponents

    private void tbHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHabitacionesMouseClicked
        seleccionar(tbHabitaciones.rowAtPoint(evt.getPoint()));
    }//GEN-LAST:event_tbHabitacionesMouseClicked

    private void buscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarFocusGained
        campos.limpiarCamposFocus(buscar);
    }//GEN-LAST:event_buscarFocusGained

    private void buscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarFocusLost
        campos.configurarCampoFocus(buscar, "Buscar una habitación");
    }//GEN-LAST:event_buscarFocusLost

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
        campos.limpiarCamposFocus(buscar);
    }//GEN-LAST:event_buscarMouseClicked

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        cargarTabla(buscar.getText());
    }//GEN-LAST:event_buscarKeyTyped

    private void AgregarModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgregarModificarMouseClicked
        if (verificar() == true) {
            if (AgregarModificar.getIcon().toString().contains("agregar")) {
                insertarHabitaciones();
            } else {
                actualizarHabitaciones();
            }
            cancelar();
        } else {
            mensaje();
        }
    }//GEN-LAST:event_AgregarModificarMouseClicked

    private void EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarMouseClicked
        eliminarHabitaciones();
        cancelar();
    }//GEN-LAST:event_EliminarMouseClicked

    private void CancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarMouseClicked
        cancelar();
    }//GEN-LAST:event_CancelarMouseClicked

    private void cerrarNotificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarNotificacionMouseClicked
        cerrarNotificacion();
    }//GEN-LAST:event_cerrarNotificacionMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        pisosModal.setVisible(true);
        cargarPisos();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        categoriasModal.setVisible(true);
        cargarCategorias();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void habitacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_habitacionFocusGained
        campos.limpiarCamposFocus(habitacion);
    }//GEN-LAST:event_habitacionFocusGained

    private void habitacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_habitacionFocusLost
        campos.configurarCampoFocus(habitacion, "Ingrese el nombre de la habitación");
    }//GEN-LAST:event_habitacionFocusLost

    private void habitacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_habitacionMouseClicked
        campos.limpiarCamposFocus(habitacion);
    }//GEN-LAST:event_habitacionMouseClicked

    private void precio_horaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precio_horaFocusGained
        campos.limpiarCamposFocus(precio_hora);
    }//GEN-LAST:event_precio_horaFocusGained

    private void precio_horaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precio_horaFocusLost
        campos.configurarCampoFocus(precio_hora, "Ingrese la cantidad");
    }//GEN-LAST:event_precio_horaFocusLost

    private void precio_horaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_precio_horaMouseClicked
        campos.limpiarCamposFocus(precio_hora);
    }//GEN-LAST:event_precio_horaMouseClicked

    private void precio_diaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precio_diaFocusGained
        campos.limpiarCamposFocus(precio_dia);
    }//GEN-LAST:event_precio_diaFocusGained

    private void precio_diaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precio_diaFocusLost
        campos.configurarCampoFocus(precio_dia, "Ingrese la cantidad");
    }//GEN-LAST:event_precio_diaFocusLost

    private void precio_diaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_precio_diaMouseClicked
        campos.limpiarCamposFocus(precio_dia);
    }//GEN-LAST:event_precio_diaMouseClicked

    private void caracteristicasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_caracteristicasFocusGained
        campos.limpiarCamposFocus(caracteristicas);
    }//GEN-LAST:event_caracteristicasFocusGained

    private void caracteristicasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_caracteristicasFocusLost
        campos.configurarCampoFocus(caracteristicas, "Ingrese las caracteristicas");
    }//GEN-LAST:event_caracteristicasFocusLost

    private void caracteristicasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caracteristicasMouseClicked
        campos.limpiarCamposFocus(caracteristicas);
    }//GEN-LAST:event_caracteristicasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AgregarModificar;
    private javax.swing.JLabel Cancelar;
    private javax.swing.JLabel Eliminar;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextArea caracteristicas;
    private javax.swing.JComboBox<String> categoria;
    private javax.swing.JLabel cerrarNotificacion;
    private javax.swing.JLabel errorCategoria;
    private javax.swing.JLabel errorNombre;
    private javax.swing.JLabel errorPiso;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JLabel estadoLB;
    private javax.swing.JTextField habitacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCargar;
    private javax.swing.JLabel mensaje;
    private javax.swing.JPanel notificacion;
    private javax.swing.JComboBox<String> piso;
    private javax.swing.JTextField precio_dia;
    private javax.swing.JTextField precio_hora;
    private javax.swing.JTable tbHabitaciones;
    // End of variables declaration//GEN-END:variables
}
