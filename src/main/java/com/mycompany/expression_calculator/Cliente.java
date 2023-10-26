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
 * @author SpaceBa
 */

public class Cliente extends Observable implements Runnable{

    int puerto_propio;
    String nombre;

    String operacion;

    Date fecha;

    Boolean respuesta;


    public Cliente(int puerto_propio, String nombre){
        this.puerto_propio = puerto_propio;
        this.nombre = nombre;
    }

    public Cliente(int puerto_propio){
        this.puerto_propio = puerto_propio;
    }

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

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
    public void writeCSV(String nombre, String operacion, Date fecha, int respuesta){
        CSV_Manage csv = new CSV_Manage();
        csv.writeCSV("file.csv", nombre, operacion, fecha, respuesta);
    }

    @Override
    public void run() {
        String IP = "127.0.0.1";
        String nombre_recibido, resultado_recibido;

        Paquete_Datos paquete_datose = new Paquete_Datos();
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