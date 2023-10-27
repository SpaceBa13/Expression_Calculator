package com.mycompany.expression_calculator;

import java.util.Date;

public class Prueba {

    public static void main(String[] args) {
        boolean f = false;
        boolean v = true;
        boolean cadena = f&v^v|(v^v^f)&f|v;
        System.out.println(cadena);

        double result = 3*((5+3)*1+(-3/3+5));
        System.out.println(result);
    }
}
