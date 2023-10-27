package com.mycompany.expression_calculator;

/**
 * Representaran los nodos de la pila
 */
public class Stack_Node {
    /**
     * dato representara el dato presente en el nodo
     * next representara el siguiente nodo de la pila
     */
    Tree_Node dato;
    Stack_Node next;

    /**
     * Constructor
     * @param dato Asigna el dato segun el argumento dado
     */
    public Stack_Node(Tree_Node dato){
        this.dato = dato;
        this.next = null;
    }

}
