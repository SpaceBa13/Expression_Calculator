/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expression_calculator;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author SpaceBa
 */
public class Servidor implements Runnable {
    int puerto;

    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    public static void main(String[] args) {
        Servidor server = new Servidor(10000);
        Thread hilo_servidor = new Thread(server);
        hilo_servidor.start();
        System.out.println("En espera.....");
    }

    public void enviar(String IP, Paquete_Datos entrada, int puerto){
        try {
            Socket reenvio = new Socket(IP, puerto);
            /*Json*/
            ObjectMapper envio_json = new ObjectMapper();
            String Envio_json = envio_json.writeValueAsString(entrada);
            /*Envia el String en formato jason a traves del socket*/
            DataOutputStream paquete_enviar = new DataOutputStream(reenvio.getOutputStream());
            paquete_enviar.writeUTF(Envio_json);
            reenvio.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        String IP = "127.0.0.1";
        String nombre_recibido, resultado_recibido;
        Paquete_Datos paquete_datos = new Paquete_Datos();
        try {
            ServerSocket servidor = new ServerSocket(11111);
            Socket recibir_datos;
            Paquete_Datos paquete_entrante;
            String lectura_json;
            while(true){
                recibir_datos = servidor.accept();
                DataInputStream paquete_entrada = new DataInputStream(recibir_datos.getInputStream());
                /*Json*/
                ObjectMapper recibido_json = new ObjectMapper();
                lectura_json = (String) paquete_entrada.readUTF();
                paquete_entrante = recibido_json.readValue(lectura_json, Paquete_Datos.class);

                System.out.println("Mensaje recibido del cliente:" + paquete_entrante);

                int puerto_cliente = paquete_entrante.getPuerto_propio();

                enviar("127.0.0.1", paquete_entrante, puerto_cliente);

                recibir_datos.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}