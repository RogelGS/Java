package com.mx.CRUDTennis.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TENNI")
@Data
public class Tennis {
    @Id
    private int id;
    private String modelo;
    private String marca;
    private double precio;
    private int num_ini;
    private int num_fin;
}
