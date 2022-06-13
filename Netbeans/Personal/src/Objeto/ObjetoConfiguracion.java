/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

/**
 *
 * @author KSGAMER
 */
public class ObjetoConfiguracion {

    private String servidor;
    private String instancia;
    private int puerto;
    private String base_datos;
    private String usuario;
    private String contraseña;

    public ObjetoConfiguracion(String servidor, String instancia, int puerto, String base_datos, String usuario, String contraseña) {
        this.servidor = servidor;
        this.instancia = instancia;
        this.puerto = puerto;
        this.base_datos = base_datos;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getServidor() {
        return servidor;
    }

    public String getInstancia() {
        return instancia;
    }

    public int getPuerto() {
        return puerto;
    }

    public String getBase_datos() {
        return base_datos;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public void setBase_datos(String base_datos) {
        this.base_datos = base_datos;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
