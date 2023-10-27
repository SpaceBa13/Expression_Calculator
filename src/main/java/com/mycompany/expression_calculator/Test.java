package com.mycompany.expression_calculator;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class Test {
    public static void main(String[] args) {
        Tesseract tesseract = new Tesseract();
        try {

            tesseract.setDatapath("E:\\Brayan\\Tareas TEC\\Java (Proyectos)\\Expression_Calculator\\Tess4J-3.4.8-src\\Tess4J\\tessdata");

            // the path of your tess data folder
            // inside the extracted file

            //Imagen que va a buscar para convetir en texto
            String text = tesseract.doOCR(new File("E:\\Brayan\\Tareas TEC\\Java (Proyectos)\\Expression_Calculator\\Images\\image2.png"));

            // path of your image file
            System.out.print(text);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}