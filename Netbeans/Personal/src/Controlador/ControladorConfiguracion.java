/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Objeto.ObjetoConfiguracion;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author KSGAMER
 */
public class ControladorConfiguracion {

    private ControladorArchivo archivo = new ControladorArchivo();
    private ObjetoConfiguracion configuracion;

    public ControladorConfiguracion() {
        obtenerConfiguracion();
    }

    public void obtenerConfiguracion() {
        try {
            JSONParser formatear = new JSONParser();
            Object objeto = formatear.parse(new FileReader(archivo.rutaArchivo()));
            JSONObject atributos = (JSONObject) objeto;
            configuracion = new ObjetoConfiguracion((String) atributos.get("SERVER"), (String) atributos.get("INSTANCE"), Integer.parseInt(atributos.get("PORT").toString()), (String) atributos.get("DATABASE"), (String) atributos.get("USER"), (String) atributos.get("PASSWORD"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControladorConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(ControladorConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObjetoConfiguracion configuracion() {
        return configuracion;
    }
    
    public void actualizarConfiguracion(ObjetoConfiguracion nueva_Configuracion) {
        archivo.escribirArchivo(archivo.configuracionInicial(nueva_Configuracion.getServidor(), nueva_Configuracion.getInstancia(), nueva_Configuracion.getPuerto(), nueva_Configuracion.getBase_datos(), nueva_Configuracion.getUsuario(), nueva_Configuracion.getContraseña()).toJSONString());
        obtenerConfiguracion();
    }
}
