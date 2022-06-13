/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

import java.sql.Date;

/**
 *
 * @author KSGAMER
 */
public class ObjetoReservacion {
    private int reservacionID;
    private String habitacionID;
    private String clienteID;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String estado;

    public ObjetoReservacion(int reservacionID, String habitacionID, String clienteID, Date fechaIngreso, Date fechaSalida, String estado) {
        this.reservacionID = reservacionID;
        this.habitacionID = habitacionID;
        this.clienteID = clienteID;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
    }

    public int getReservacionID() {
        return reservacionID;
    }

    public String getHabitacionID() {
        return habitacionID;
    }

    public String getClienteID() {
        return clienteID;
    }
    
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public String getEstado() {
        return estado;
    }
}
