package com.mx.Project.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "CLIENTE")
@Data
public class Client {
    @Id
    private int id;
    private String nombre, app, apm, celular, correo;
    private Date fecha_Nacimiento;
}
