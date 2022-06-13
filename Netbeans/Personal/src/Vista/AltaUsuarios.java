/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorCampos;
import Controlador.ControladorEncriptacion;
import Controlador.ControladorUsuario;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author KSGAMER
 */
public class AltaUsuarios extends javax.swing.JPanel {
    private DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
    private ControladorUsuario usuarios;

    /**
     * Creates new form AltaUsuarios
     */
    public AltaUsuarios() {
        initComponents();
        this.setBounds(0, 0, 1100, 670);
        cargarTabla("");
        configuracionInicial();
    }

    public void configuracionInicial() {
        Notificacion.setVisible(false);
        ErrorUsuario.setVisible(false);
        ErrorContraseña.setVisible(false);
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

    public void cargarTabla(String busqueda) {
        tbUsuarios.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
        tbUsuarios.getTableHeader().setOpaque(false);
        tbUsuarios.getTableHeader().setBackground(new Color(32, 136, 203));
        tbUsuarios.getTableHeader().setForeground(new Color(255, 255, 255));
        ((DefaultTableCellHeaderRenderer)tbUsuarios.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        usuarios = new ControladorUsuario();
        tbUsuarios.setModel(usuarios.tablaUsuarios(busqueda));
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbUsuarios.getColumnModel().getColumn(0).setPreferredWidth(70);
        tbUsuarios.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        tbUsuarios.getColumnModel().getColumn(1).setPreferredWidth(380);
        tbUsuarios.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        tbUsuarios.getColumnModel().getColumn(2).setPreferredWidth(20);
        tbUsuarios.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
    }

    public void insertarUsuarios() {
        cargar(20);
        usuarios.insertarUsuarios(Usuario.getText(), new ControladorEncriptacion().encriptar(String.valueOf(Contraseña.getPassword())), UrlImagen.getText(), Notificacion, Mensaje);
    }

    public void actualizarUsuarios() {
        cargar(20);
        usuarios.actualizarUsuarios(Usuario.getText(), new ControladorEncriptacion().encriptar(String.valueOf(Contraseña.getPassword())), UrlImagen.getText(), Notificacion, Mensaje);
    }

    public void actualizarEstadoUsuario() {
        cargar(20);
        if (ActivoInactivo.getIcon().toString().contains("desactivar")) {
            usuarios.actualizarEstadoUsuarios(Usuario.getText(), "0", Notificacion, Mensaje);
        } else {
            usuarios.actualizarEstadoUsuarios(Usuario.getText(), "1", Notificacion, Mensaje);
        }
    }

    public void eliminarUsuarios() {
        cargar(20);
        usuarios.eliminarUsuarios(Usuario.getText(), Notificacion, Mensaje);
    }

    public void seleccionarImagen() {
        JFileChooser ruta = new JFileChooser();
        ruta.removeChoosableFileFilter(ruta.getFileFilter());
        ruta.setFileFilter(new FileNameExtensionFilter("*.png", "png"));
        ruta.setFileFilter(new FileNameExtensionFilter("*.jpg", "jpg"));
        if (ruta.showOpenDialog(jPanel1) == JFileChooser.APPROVE_OPTION) {
            UrlImagen.setText(ruta.getSelectedFile().getAbsolutePath());
            Previsualizacion.setIcon((Icon) new ImageIcon(new ImageIcon(UrlImagen.getText()).getImage().getScaledInstance(Previsualizacion.getWidth(), Previsualizacion.getHeight(), Image.SCALE_SMOOTH)));
        }
    }

    public void habilitarBotones(String estado) {
        AgregarModificar.setToolTipText("Modificar");
        AgregarModificar.setIcon(new ImageIcon("src/Imagen/Principal/modificar-24.png"));
        AgregarModificar.setBackground(new Color(255, 181, 62));
        ActivoInactivo.setEnabled(true);
        if (estado.equals("Activo")) {
            ActivoInactivo.setToolTipText("Desactivar");
            ActivoInactivo.setIcon(new ImageIcon("src/Imagen/Principal/desactivar-24.png"));
        } else {
            ActivoInactivo.setToolTipText("Activar");
            ActivoInactivo.setIcon(new ImageIcon("src/Imagen/Principal/activar-24.png"));
        }
        Eliminar.setEnabled(true);
        Usuario.setEnabled(false);
    }

    public void cerrarNotificacion() {
        Notificacion.setVisible(false);
    }

    public void cancelar() {
        AgregarModificar.setToolTipText("Agregar");
        AgregarModificar.setIcon(new ImageIcon("src/Imagen/Principal/agregar-24.png"));
        AgregarModificar.setBackground(new Color(35, 144, 35));
        ActivoInactivo.setToolTipText("Activar");
        ActivoInactivo.setEnabled(false);
        ActivoInactivo.setIcon(new ImageIcon("src/Imagen/Principal/activar-24.png"));
        Eliminar.setEnabled(false);
        Usuario.setEnabled(true);
        Usuario.setText("Ingrese un usuario");
        Contraseña.setText("Ingrese una contraseña");
        Buscar.setText("Buscar un usuario");
        Previsualizacion.setIcon(null);
        ErrorUsuario.setVisible(false);
        ErrorContraseña.setVisible(false);
        cargarTabla("");
    }

    public boolean verificar() {
        boolean campos = true;
        if (Usuario.getText().contains("Ingrese") || Usuario.getText().equals("")) {
            campos = false;
            ErrorUsuario.setVisible(true);
        } else {
            ErrorUsuario.setVisible(false);
        }
        if (String.valueOf(Contraseña.getPassword()).contains("Ingrese") || String.valueOf(Contraseña.getPassword()).equals("")) {
            campos = false;
            ErrorContraseña.setVisible(true);
        } else {
            ErrorContraseña.setVisible(false);
        }
        return campos;
    }

    public void mensaje() {
        Notificacion.setVisible(true);
        Notificacion.setBackground(new Color(220, 24, 24));
        Mensaje.setText("Verifique que los campos estan llenados");
    }

    public void mostarContraseña() {
        if (Mostrar_contraseña.getIcon().toString().contains("no_mostrar")) {
            Mostrar_contraseña.setIcon(new ImageIcon("src/Imagen/Principal/mostrar-20.png"));
            Contraseña.setEchoChar((char) 0);
        } else {
            Mostrar_contraseña.setIcon(new ImageIcon("src/Imagen/Principal/no_mostrar-20.png"));
            Contraseña.setEchoChar('\u25cf');
        }
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
        jLabel3 = new javax.swing.JLabel();
        Usuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UrlImagen = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Contraseña = new javax.swing.JPasswordField();
        ErrorUsuario = new javax.swing.JLabel();
        ErrorContraseña = new javax.swing.JLabel();
        Mostrar_contraseña = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        Previsualizacion = new javax.swing.JLabel();
        Buscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        AgregarModificar = new javax.swing.JLabel();
        ActivoInactivo = new javax.swing.JLabel();
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
        jLabel1.setText(" Módulo Alta de Usuarios");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, 0, 1060, 40);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 1100, 40);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jPanel5.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Usuario:");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(30, 30, 110, 15);

        Usuario.setText("Ingrese un usuario");
        Usuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UsuarioFocusLost(evt);
            }
        });
        Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsuarioMouseClicked(evt);
            }
        });
        jPanel5.add(Usuario);
        Usuario.setBounds(30, 45, 340, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Contraseña:");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(30, 90, 110, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Archivo:");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(30, 150, 110, 15);

        UrlImagen.setText("Seleccione una ruta");
        UrlImagen.setEnabled(false);
        jPanel5.add(UrlImagen);
        UrlImagen.setBounds(30, 165, 340, 25);

        jButton1.setText("...");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);
        jButton1.setBounds(380, 165, 30, 25);

        Contraseña.setText("Ingrese una contraseña");
        Contraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ContraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ContraseñaFocusLost(evt);
            }
        });
        Contraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ContraseñaMouseClicked(evt);
            }
        });
        jPanel5.add(Contraseña);
        Contraseña.setBounds(30, 105, 340, 25);

        ErrorUsuario.setBackground(new java.awt.Color(220, 24, 24));
        ErrorUsuario.setOpaque(true);
        jPanel5.add(ErrorUsuario);
        ErrorUsuario.setBounds(30, 70, 340, 2);

        ErrorContraseña.setBackground(new java.awt.Color(220, 24, 24));
        ErrorContraseña.setOpaque(true);
        jPanel5.add(ErrorContraseña);
        ErrorContraseña.setBounds(30, 130, 340, 2);

        Mostrar_contraseña.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mostrar_contraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Principal/no_mostrar-20.png"))); // NOI18N
        Mostrar_contraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Mostrar_contraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Mostrar_contraseñaMouseClicked(evt);
            }
        });
        jPanel5.add(Mostrar_contraseña);
        Mostrar_contraseña.setBounds(385, 105, 25, 25);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(650, 40, 420, 220);

        tbUsuarios = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tbUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbUsuarios.setSelectionBackground(new java.awt.Color(77, 167, 238));
        tbUsuarios.setShowVerticalLines(false);
        tbUsuarios.getTableHeader().setResizingAllowed(false);
        tbUsuarios.getTableHeader().setReorderingAllowed(false);
        tbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuarios);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 590, 490);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Previsualización");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(680, 280, 350, 20);

        Previsualizacion.setOpaque(true);
        jPanel4.add(Previsualizacion);
        Previsualizacion.setBounds(750, 310, 200, 200);

        Buscar.setText("Buscar un usuario");
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
        AgregarModificar.setBounds(780, 530, 32, 32);

        ActivoInactivo.setBackground(new java.awt.Color(30, 191, 174));
        ActivoInactivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ActivoInactivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Principal/activar-24.png"))); // NOI18N
        ActivoInactivo.setToolTipText("Activar");
        ActivoInactivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ActivoInactivo.setEnabled(false);
        ActivoInactivo.setOpaque(true);
        ActivoInactivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActivoInactivoMouseClicked(evt);
            }
        });
        jPanel4.add(ActivoInactivo);
        ActivoInactivo.setBounds(820, 530, 32, 32);

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
        Eliminar.setBounds(860, 530, 32, 32);

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
        Cancelar.setBounds(900, 530, 32, 32);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        seleccionarImagen();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarFocusGained
        new ControladorCampos().limpiarCamposFocus(Buscar);
    }//GEN-LAST:event_BuscarFocusGained

    private void UsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UsuarioFocusGained
        new ControladorCampos().limpiarCamposFocus(Usuario);
    }//GEN-LAST:event_UsuarioFocusGained

    private void BuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BuscarFocusLost
        new ControladorCampos().configurarCampoFocus(Buscar, "Buscar un usuario");
    }//GEN-LAST:event_BuscarFocusLost

    private void UsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UsuarioFocusLost
        new ControladorCampos().configurarCampoFocus(Usuario, "Ingrese un usuario");
    }//GEN-LAST:event_UsuarioFocusLost

    private void ContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ContraseñaFocusGained
        new ControladorCampos().limpiarCamposFocus(Contraseña);
    }//GEN-LAST:event_ContraseñaFocusGained

    private void ContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ContraseñaFocusLost
        new ControladorCampos().configurarCampoFocus(Contraseña, "Ingrese una contraseña");
    }//GEN-LAST:event_ContraseñaFocusLost

    private void tbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuariosMouseClicked
        Previsualizacion.setIcon(null);
        int seleccion = tbUsuarios.rowAtPoint(evt.getPoint());
        habilitarBotones(tbUsuarios.getValueAt(seleccion, 2).toString());
        Usuario.setText(tbUsuarios.getValueAt(seleccion, 0).toString());
        Contraseña.setText(new ControladorEncriptacion().desencriptar(tbUsuarios.getValueAt(seleccion, 1).toString()));
        usuarios.listaUsuarios().forEach((usuario) -> {
            if (usuario.getImagen() != null) {
                if (tbUsuarios.getValueAt(seleccion, 0).toString().equals(usuario.getUsuario())) {
                    try {
                        BufferedImage imagenRenderizada = ImageIO.read(new ByteArrayInputStream(usuario.getImagen()));
                        Previsualizacion.setIcon(new ImageIcon(new ImageIcon(imagenRenderizada).getImage().getScaledInstance(Previsualizacion.getWidth(), Previsualizacion.getHeight(), Image.SCALE_SMOOTH)));
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
            }
        });
    }//GEN-LAST:event_tbUsuariosMouseClicked

    private void CancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarMouseClicked
        cancelar();
    }//GEN-LAST:event_CancelarMouseClicked

    private void AgregarModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgregarModificarMouseClicked
        if (verificar() == true) {
            if (AgregarModificar.getIcon().toString().contains("agregar")) {
                insertarUsuarios();
            } else {
                actualizarUsuarios();
            }
            cancelar();
        } else {
            mensaje();
        }
    }//GEN-LAST:event_AgregarModificarMouseClicked

    private void CerrarNotificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarNotificacionMouseClicked
        cerrarNotificacion();
    }//GEN-LAST:event_CerrarNotificacionMouseClicked

    private void EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarMouseClicked
        eliminarUsuarios();
        cancelar();
    }//GEN-LAST:event_EliminarMouseClicked

    private void ActivoInactivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActivoInactivoMouseClicked
        actualizarEstadoUsuario();
        cancelar();
    }//GEN-LAST:event_ActivoInactivoMouseClicked

    private void BuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarKeyTyped
        cargarTabla(Buscar.getText());
    }//GEN-LAST:event_BuscarKeyTyped

    private void Mostrar_contraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Mostrar_contraseñaMouseClicked
        mostarContraseña();
    }//GEN-LAST:event_Mostrar_contraseñaMouseClicked

    private void UsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsuarioMouseClicked
        new ControladorCampos().limpiarCamposFocus(Usuario);
    }//GEN-LAST:event_UsuarioMouseClicked

    private void ContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContraseñaMouseClicked
        new ControladorCampos().limpiarCamposFocus(Contraseña);
    }//GEN-LAST:event_ContraseñaMouseClicked

    private void BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseClicked
        new ControladorCampos().limpiarCamposFocus(Buscar);
    }//GEN-LAST:event_BuscarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ActivoInactivo;
    private javax.swing.JLabel AgregarModificar;
    private javax.swing.JTextField Buscar;
    private javax.swing.JLabel Cancelar;
    private javax.swing.JLabel CerrarNotificacion;
    private javax.swing.JPasswordField Contraseña;
    private javax.swing.JLabel Eliminar;
    private javax.swing.JLabel ErrorContraseña;
    private javax.swing.JLabel ErrorUsuario;
    private javax.swing.JLabel Mensaje;
    private javax.swing.JLabel Mostrar_contraseña;
    private javax.swing.JPanel Notificacion;
    private javax.swing.JLabel Previsualizacion;
    private javax.swing.JTextField UrlImagen;
    private javax.swing.JTextField Usuario;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JTable tbUsuarios;
    // End of variables declaration//GEN-END:variables
}
