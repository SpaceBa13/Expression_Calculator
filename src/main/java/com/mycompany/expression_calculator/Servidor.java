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

/**
 * @author SpaceBa
 * Esta clase sera el servidor que maneje la logica de la creacion de los arboles
 * tiene como atributo unicamente el puerto
 */
public class Servidor implements Runnable {
    int puerto;

    /**
     * Constructor
     * @param puerto
     */
    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    /**
     * Metodo encargado de crear una instancia del servidor y crear un hilo para mantenerlo activo
     * @param args
     */
    public static void main(String[] args) {
        Servidor server = new Servidor(10000);
        Thread hilo_servidor = new Thread(server);
        hilo_servidor.start();
        System.out.println("En espera.....");
    }

    /**
     * Metodo que se encarga de crear un arbol de expression aritmetico
     * @param expression repesenta la expresion que se creara
     * @return retorna el resultado de la operacion
     */
    public double crear_arbol_aritmetico(String expression){
        E_Tree arbol = new E_Tree(expression);
        Double result = arbol.EvaluateExpression();
        return result;
    }
    /**
     * Metodo que se encarga de crear un arbol de expression logico
     * @param expression repesenta la expresion que se creara
     * @return retorna el resultado de la operacion
     */
    public boolean crear_arbol_logico(String expression){
        L_Tree arboll = new L_Tree(expression);
        Boolean result = arboll.EvaluateExpression();
        return result;
    }

    public void writeCSV(String nombre, String operacion, Date fecha, String respuesta){
        CSV_Manage csv = new CSV_Manage();
        csv.writeCSV("file.csv", nombre, operacion, fecha, respuesta);
    }

    /**
     * Metodo encargada de enviar el paquete de datos al cliente
     * @param IP Sera la IP del cliente
     * @param entrada Sera el paquete de datos a enviar
     * @param puerto Sera el puerto del cliente
     */
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

    /**
     * Metodo que mantendra en ejeuccion el hilo
     * Encargado del recibimiento de paquetes
     */
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

                if(paquete_entrante.getTipo() == true){
                    Boolean result = crear_arbol_logico(paquete_entrante.getOperacion());
                    String show_result = result.toString();
                    paquete_entrante.setOperacion(show_result);
                    writeCSV(paquete_entrante.getNombre(), paquete_entrante.getOperacion(), paquete_entrante.getFecha(), show_result);
                    enviar("127.0.0.1", paquete_entrante, puerto_cliente);
                }else{
                    Double result = crear_arbol_aritmetico(paquete_entrante.getOperacion());
                    String show_result = result.toString();
                    paquete_entrante.setOperacion(show_result);
                    writeCSV(paquete_entrante.getNombre(), paquete_entrante.getOperacion(), paquete_entrante.getFecha(), String.valueOf(Integer.parseInt(show_result)));
                    enviar("127.0.0.1", paquete_entrante, puerto_cliente);
                }



                recibir_datos.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}