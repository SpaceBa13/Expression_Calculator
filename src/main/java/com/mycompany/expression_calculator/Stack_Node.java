package com.mycompany.expression_calculator;


public class Stack_Node {
    Tree_Node dato;
    Stack_Node next;

    public Stack_Node(Tree_Node dato){
        this.dato = dato;
        this.next = null;
    }

}
