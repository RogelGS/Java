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
public class ObjetoHabitacion {
    private String habitacionID;
    private String pisoID;
    private String categoriaID;
    private double precioHora;
    private double precioDia;
    private String caracteristicas;
    private String estado;

    public ObjetoHabitacion(String habitacionID, String pisoID, String categoriaID, double precioHora, double precioDia, String caracteristicas, String estado) {
        this.habitacionID = habitacionID;
        this.pisoID = pisoID;
        this.categoriaID = categoriaID;
        this.precioHora = precioHora;
        this.precioDia = precioDia;
        this.caracteristicas = caracteristicas;
        this.estado = estado;
    }

    public String getHabitacionID() {
        return habitacionID;
    }

    public String getPisoID() {
        return pisoID;
    }

    public String getCategoriaID() {
        return categoriaID;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public String getEstado() {
        return estado;
    }
}
