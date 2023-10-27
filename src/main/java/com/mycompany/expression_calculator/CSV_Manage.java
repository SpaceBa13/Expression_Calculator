package com.mycompany.expression_calculator;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class CSV_Manage {

    private BufferedReader lector;
    private String linea;
    private String partes[];

    void writeCSV(String file, String nombre, String operacion, Date fecha, String respuesta) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println("Nombre: "+ nombre + ", " + "Expresión: " + operacion + ", " + "Fecha: " + fecha + ", " + "Resultado: " + respuesta);
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e);

        }
    }

    public void readCSV(String file, String nombre) {
        try {
            if (linea.contains("Nombre: " + nombre)) {
                lector = new BufferedReader(new FileReader(file));
                while ((linea = lector.readLine()) != null) {
                    partes = linea.split(" , ");
                    System.out.println(linea);
                    // Verifica si la línea contiene el nombre buscado

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
    }

    public void imprimirLinea() {
        for (int i = 0; i < partes.length; i++) {
            System.out.println(partes[i] + "");
        }
    }
    //public void get_column{
    //}
}
//    String generateRandomName() {
//        String[] names = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Hannah"};
//        Random random = new Random();
//        int index = random.nextInt(names.length);
//        return names[index];
//    }
//
//    String generateRandomDate() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        long startDate = new Date().getTime();
//        long randomDate = (long) (Math.random() * (365 * 24 * 60 * 60 * 1000));
//        Date date = new Date(startDate - randomDate);
//        return dateFormat.format(date);
//    }
//
//    public static void main(String[] args) throws IOException {
//        CSV_Manage prueba = new CSV_Manage();
//
//        String nombre = prueba.generateRandomName();
//        String operacion = "4 + 3 + 4";
//        String fecha = prueba.generateRandomDate();
//        int respuesta = 234;
//        prueba.writeCSV("file.csv", nombre, operacion, fecha, respuesta);
//        prueba.readCSV("file.csv");
//    }
//}
