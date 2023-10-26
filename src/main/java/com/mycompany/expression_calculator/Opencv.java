package com.mycompany.expression_calculator;
import org.opencv.core.Core;
public class Opencv {
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    public static void main(String[] args) {
        System.out.println(Core.VERSION);
    }
}
