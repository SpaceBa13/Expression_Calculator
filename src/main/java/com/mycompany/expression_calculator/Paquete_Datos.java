/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expression_calculator;


import java.io.Serializable;
import java.util.Date;

/**
 * Encargada de manejar el paquete de datos que se pasa de cliente-servidor
 * @author SpaceBa
 */
public class Paquete_Datos implements Serializable {
    /**
     * El puerto_propio representara el puerto del cliente
     * el nombre representara el nombre del usuario en sesion
     * la operacion representara tanto la operacion enviada como el resultado recibido
     * la fecha, representara la fecha de envio del paquete
     * tipo respresntara si la operacion que se esta llevando a cabo es booleana o aritmetica
     */
    int puerto_propio;
    String nombre;
    String operacion;
    Date fecha;
    Boolean tipo;

    /**
     * Obtiene el atributo puerto propio de la instancia
     * @return
     */
    public int getPuerto_propio() {
        return puerto_propio;
    }

    /**
     * Cambia el atributo puerto_propio de la instancia por el argumento dado
     * @param puerto_propio Dato para reemplazar en la clase
     */
    public void setPuerto_propio(int puerto_propio) {
        this.puerto_propio = puerto_propio;
    }

    /**
     * Obtiene el atributo puerto propio de la instancia
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el atributo nombre de la instancia por el argumento dado
     * @param nombre Dato para reemplazar en la clase
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el atributo operacion de la instancia
     * @return
     */
    public String getOperacion() {
        return operacion;
    }

    /**
     * Cambia el atributo operacion de la instancia por el argumento dado
     * @param operacion Dato para reemplazar en la clase
     */
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    /**
     * Obtiene el atributo fecha de la instancia
     * @return
     */
    public Date getFecha() {return fecha;}

    /**
     * Cambia el atributo fecha de la instancia por el argumento dado
     * @param fecha Dato para reemplazar en la clase
     */
    public void setFecha(Date fecha) {this.fecha = fecha;}

    /**
     * Obtiene el atributo tipo de la instancia
     * @return
     */
    public Boolean getTipo() {return tipo;}

    /**
     * Cambia el atributo tipo de la instancia por el argumento dado
     * @param tipo Dato para reemplazar en la clase
     */
    public void setTipo(Boolean tipo) {this.tipo = tipo;}
}

