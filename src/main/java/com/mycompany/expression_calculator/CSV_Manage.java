package com.mycompany.expression_calculator;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author darig
 * Esta clase sera la encargada de manejar el uso del csv, escribir en el y leer el archivo
 */
public class CSV_Manage {

    private BufferedReader lector;
    private String linea;
    private String partes[];

    /**
     * @param file El archivo de guardado
     * @param nombre El nombre del usuario
     * @param operacion La operacion a calcular
     * @param fecha La fecha en la que se hizo
     * @param respuesta La operacion resuelta
     */
    void writeCSV(String file, String nombre, String operacion, Date fecha, String respuesta) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println("Nombre: "+ nombre + ", " + "Operacion: " + operacion + ", " + "Fecha: " + fecha + ", " + "Resultado: " + respuesta);
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * @param file El archivo en el que se escribe
     * @param nombre El nombre del usuario
     * @return
     */
    public String readCSV(String file, String nombre) {
        try {
            lector = new BufferedReader(new FileReader(file));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(" , ");

                if (nombre.isEmpty() || linea.contains("Nombre: " + nombre)) {
                    imprimirLinea();
                    System.out.println();
                }
            }
            lector.close();
            linea = null;
            partes = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return file;
    }

    /**
     * Funcion auxiliar para iprimir una línea del csv
     */
    public void imprimirLinea() {
        for (int i = 0; i < partes.length; i++) {
            System.out.println(partes[i] + "");
        }
    }
}