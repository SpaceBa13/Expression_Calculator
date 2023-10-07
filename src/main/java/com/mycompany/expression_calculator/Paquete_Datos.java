/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expression_calculator;


import java.io.Serializable;

/**
 *
 * @author SpaceBa
 */
public class Paquete_Datos implements Serializable {
    int puerto_propio;
    String nombre;
    String operacion;

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
}
