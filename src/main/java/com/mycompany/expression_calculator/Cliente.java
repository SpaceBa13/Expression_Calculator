/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expression_calculator;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Observable;

/**
 *
 * La clase cliente sera por la cual la interfaz grafica se comunicara con el servidor
 * enviandole las expresiones para ser evaluadas, y este recibira la respuesta
 * del servidor
 * @author SpaceBa
 */

public class Cliente extends Observable implements Runnable{
    /**
     * El puerto_propio representara el puerto del cliente
     * el nombre representara el nombre del usuario en sesion
     * la operacion representara tanto la operacion enviada como el resultado recibido
     * la fecha, representara la fecha de envio del paquete
     * respuesta representara si el resultado de la peticion ya fue recibido
     */
    int puerto_propio;
    String nombre;

    String operacion;

    Date fecha;

    Boolean respuesta;

    /**
     * Constructor
     * @param puerto_propio
     * @param nombre
     */
    public Cliente(int puerto_propio, String nombre){
        this.puerto_propio = puerto_propio;
        this.nombre = nombre;
    }

    /**
     * Constructor
     * @param puerto_propio
     */
    public Cliente(int puerto_propio){
        this.puerto_propio = puerto_propio;
    }

    /**
     * Asigna el nombre segun la informacion dada
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Asigna la operacion segun el argumento dado
     * @param operacion
     */
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    /**
     * Asigna la fecha segun el argumento dado
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Metodo encargado del envio de los datos al servidor, este gestiona la creacion de una instacia de la calse Paquete de Datos
     * para convetir la infomacion que se desea enviar en formato Json
     * @param expresion Representa la expresion que se desea evaluar
     * @param nombre Representa el nombre del usuario en sesion
     * @param fecha Representara la fecha de envio del paquete
     * @param tipo Representa si la operacion es booleana o aritmetica
     */
    public void enviar(String expresion, String nombre, Date fecha, Boolean tipo){
        String IP = "127.0.0.1";
        try {
            Socket socket = new Socket(IP, 11111);
            /*Crea una instancia del objeto Paquete de Datos para setear los datos a enviar*/
            Paquete_Datos envio = new Paquete_Datos();
            envio.setNombre(nombre);
            envio.setOperacion(expresion);
            envio.setPuerto_propio(puerto_propio);
            envio.setFecha(fecha);
            envio.setTipo(tipo);

            /*Json*/
            ObjectMapper envio_json = new ObjectMapper();
            String Envio_json = envio_json.writeValueAsString(envio);

            /*Envia el String en formato jason a traves del socket*/
            DataOutputStream paquete_enviar = new DataOutputStream(socket.getOutputStream());
            paquete_enviar.writeUTF(Envio_json);
            socket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Metodo que mantendra en ejeuccion el hilo
     * Encargado del recibimiento de paquetes
     */
    @Override
    public void run() {
        String nombre_recibido, resultado_recibido;

        try {
            ServerSocket servidor_cliente = new ServerSocket(puerto_propio);
            Socket recibir_datos;
            Paquete_Datos paquete_entrante;
            String lectura_json;
            while(true){
                recibir_datos = servidor_cliente.accept();
                DataInputStream paquete_entrada = new DataInputStream(recibir_datos.getInputStream());
                /*Json*/
                ObjectMapper recibido_json = new ObjectMapper();
                lectura_json = (String) paquete_entrada.readUTF();
                paquete_entrante = recibido_json.readValue(lectura_json, Paquete_Datos.class);
                /*Obtiene los datos del Objeto que entro por el socket*/
                nombre_recibido = (String) paquete_entrante.getNombre();
                resultado_recibido = paquete_entrante.getOperacion();

                this.operacion = resultado_recibido;
                this.respuesta = true;

                recibir_datos.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}