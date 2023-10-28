package com.mycompany.expression_calculator;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


/**
 * @author darig
 * Encargada de analizar una imagen por medio de la librería tesseract.
 */
public class Test {
    private String text;

    /**
     * @return Returna el texto procesado de la imagen.
     */
    public String image_processed() {
        Tesseract tesseract = new Tesseract();
        try {
            tesseract.setDatapath("C:\\Users\\darig\\OneDrive\\Documentos\\TEC\\Semestre 2\\Algoritmos y Estructuras de Datos I\\Proyecto II\\Expression_Calculator\\Tess4J-3.4.8-src\\Tess4J\\tessdata");

            text = tesseract.doOCR(new File("C:\\Users\\darig\\OneDrive\\Documentos\\TEC\\Semestre 2\\Algoritmos y Estructuras de Datos I\\Proyecto II\\Expression_Calculator\\Images\\photo.jpg"));
            text = text.replaceAll("—", "-");

            System.out.println(text);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return el texto obtenido.
     */
    public String getText() {
        return text;
    }
}