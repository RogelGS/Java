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
public class ObjetoUsuario {
    private String usuario;
    private String contrasena;
    private byte[] imagen;
    private String estado;

    public ObjetoUsuario(String usuario, String contrasena, byte[] imagen, String estado) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.imagen = imagen;
        this.estado = estado;
    }

    public ObjetoUsuario(String usuario, String contrasena, byte[] imagen) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.imagen = imagen;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public String getEstado() {
        return estado;
    }
}
