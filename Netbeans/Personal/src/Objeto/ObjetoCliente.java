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
public class ObjetoCliente {
    private int clienteID;
    private String nombre;
    private String rfc;
    private String telefono;
    private String correo;

    public ObjetoCliente(int clienteID, String nombre, String rfc, String telefono, String correo) {
        this.clienteID = clienteID;
        this.nombre = nombre;
        this.rfc = rfc;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getClienteID() {
        return clienteID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }
}
