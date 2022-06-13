/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author KSGAMER
 */
public class ControladorArchivo {

    private File archivo = new File("configuracion.json");

    public ControladorArchivo() {
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribirArchivo(configuracionInicial("", "", 0, "", "", "").toJSONString());
            } catch (IOException ex) {
                Logger.getLogger(ControladorArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void escribirArchivo(String datos) {
        FileWriter escribir = null;
        try {
            escribir = new FileWriter(archivo);
            BufferedWriter buffer = new BufferedWriter(escribir);
            buffer.write(datos);
            buffer.flush();
            buffer.close();
        } catch (IOException ex) {
            Logger.getLogger(ControladorArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(ControladorArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public JSONObject configuracionInicial(String servidor, String instancia, int puerto, String base_datos, String usuario, String contrasenia) {
        JSONObject objeto = new JSONObject();
        objeto.put("SERVER", servidor);
        objeto.put("INSTANCE", instancia);
        objeto.put("PORT", puerto);
        objeto.put("DATABASE", base_datos);
        objeto.put("USER", usuario);
        objeto.put("PASSWORD", contrasenia);
        return objeto;
    }

    public File rutaArchivo() {
        return archivo;
    }
}
