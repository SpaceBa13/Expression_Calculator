/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expression_calculator;


import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author SpaceBa
 */
public class Paquete_Datos implements Serializable {
    int puerto_propio;
    String nombre;
    String operacion;
    Date fecha;

    Boolean tipo;



    public int getPuerto_propio() {
        return puerto_propio;
    }

    public void setPuerto_propio(int puerto_propio) {
        this.puerto_propio = puerto_propio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Date getFecha() {return fecha;}

    public void setFecha(Date fecha) {this.fecha = fecha;}

    public Boolean getTipo() {return tipo;}

    public void setTipo(Boolean tipo) {this.tipo = tipo;}
}

