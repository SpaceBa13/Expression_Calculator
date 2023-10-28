package com.mycompany.expression_calculator;

import java.util.Date;


/**
 * Clase de prueba
 * @author SpaceBa
 */
public class Prueba {

    public static void main(String[] args) {
        boolean f = false;
        boolean v = true;
        boolean cadena = f&v^v|(v^v^f)&f|v;
        System.out.println("f&v^v|((~f)^v^f)&f|v" + " , resultado: " + cadena);
        boolean cadena2 = (f&f)^v|((v^f)&v)&f|v;
        System.out.println("(f&f)^v|((v^f)&v)&f|v" + " , resultado: " + cadena2);
        boolean cadena3 = (f^f)|(v&v);
        System.out.println("(f^f)|((~f)&v)" + " , resultado: " + cadena3);
        boolean cadena4 = f&v^v&(v^v^f)&f&v;
        System.out.println("f&(~f)^v&(v^v^f)&f&v" + " , resultado: " + cadena4);

        double result = 3*((5+3)*1+(-3/3+5));
        System.out.println("3*((5+3)*1+(-3/3+5))" + " , resultado: " + result);
        double result2 = (Math.pow(3, 5)-(10/5)+(20*(-2)));
        System.out.println("(3^5)-(10/5)+(20*(-2))" + " , resultado: " + result2);
        double result3 = (-7*Math.pow(3, 2))+(-2*10/10)+4;
        System.out.println("(-7*3^2)+(-2*10/10)+4" + " , resultado: " + result3);
        double result4 = (5%6)+(10/5+(5*9)-3)*10;
        System.out.println("(5%6)+(10/5+(5*9)-3)*10" + " , resultado: " + result4);

        /**Banco de prubas:
         f&v^v|(v^v^f)&f|v , resultado: true
         (f&f)^v|((v^f)&v)&f|v , resultado: true
         (f^f)|(v&v) , resultado: true
         f&v^v&(v^v^f)&f&v , resultado: false

         3*((5+3)*1+(-3/3+5)) , resultado: 36.0
         (3^5)-(10/5)+(20*(-2)) , resultado: 201.0
         (-7*3^2)+(-2*10/10)+4 , resultado: -61.0
         (5%6)+(10/5+(5*9)-3)*10 , resultado: 445.0
         */
    }
}
