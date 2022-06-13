/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Controlador.ControladorConfiguracion;
import Utileria.Mensaje;
import Vista.Sesion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author KSGAMER
 */
public class BD {

    private Connection conexion = null;
    private ControladorConfiguracion configuracion = new ControladorConfiguracion();
    public static boolean verificarConexion = true;

    public BD() {
        conectar();
    }
    
    private void conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String cadenaConexion = "jdbc:sqlserver://"+configuracion.configuracion().getServidor()+"\\"+configuracion.configuracion().getInstancia()+":"+configuracion.configuracion().getPuerto()+";databaseName="+configuracion.configuracion().getBase_datos()+";user="+configuracion.configuracion().getUsuario()+";password="+configuracion.configuracion().getContraseña()+";";
            conexion = DriverManager.getConnection(cadenaConexion);
            verificarConexion = true;
        } catch (ClassNotFoundException | SQLException ex) {
            verificarConexion = false;
            if(configuracion.configuracion().getPuerto() == 0) {
                new Mensaje(new JFrame(), false).mensaje("Configure su conexión a Base de Datos e intentelo nuevamente.");
            } else {
                new Mensaje(new JFrame(), false).mensaje("Asegurese de que el servirdor se encuentre encendido o revise su configuración.");
            }
        }
    }

    public Connection getConexion() {
        return conexion;
    }
}
