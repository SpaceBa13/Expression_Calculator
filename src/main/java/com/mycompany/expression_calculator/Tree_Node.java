package com.mycompany.expression_calculator;

/**
 * Esta clase funcionara como parte de los arboles de expresion, seran los nodos
 */
public class Tree_Node {
    /**
     * data representara el dato presente en el nodo
     * izquierdo representara el hijo izquierdo del nodo raiz
     * derecho representara el hijo derecho del nodo raiz
     */
    Object data;
    Tree_Node izquierdo;
    Tree_Node derecho;

    /**
     * Constructor
     * @param data Asignara el dato al nodo segun el argumento indicado
     */
    public Tree_Node(Object data){
        this.data = data;
        this.izquierdo = null;
        this.derecho = null;
    }

    /**
     * Obtiene el hijo izquierdo del nodo
     * @return
     */
    public Tree_Node getIzquierdo() {
        return izquierdo;
    }
    /**
     * Obtiene el hijo derecho del nodo
     * @return
     */
    public Tree_Node getDerecho() {
        return derecho;
    }
}
