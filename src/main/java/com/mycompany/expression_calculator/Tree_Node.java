package com.mycompany.expression_calculator;

public class Tree_Node {
    Object data;
    Tree_Node izquierdo;
    Tree_Node derecho;

    public Tree_Node(Object data){
        this.data = data;
        this.izquierdo = null;
        this.derecho = null;
    }

    public Tree_Node getIzquierdo() {
        return izquierdo;
    }

    public Tree_Node getDerecho() {
        return derecho;
    }
}
