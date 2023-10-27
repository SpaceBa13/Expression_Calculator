package com.mycompany.expression_calculator;

/**
 * La clase Tree_Stack funcionara para guardar los operadores y los operandos segun se necesite
 */
public class Tree_Stack {
    /**
     * head sera el primer elemento de la pila
     */
    private Stack_Node head;

    /**
     * Constructor
     */
    public Tree_Stack(){
        head = null;
    }

    /**
     * Metodo que inserta elementos en la pila
     * @param element Elemento a insertar
     */
     public void insert(Tree_Node element){
        Stack_Node nuevo;
        nuevo = new Stack_Node(element);
        nuevo.next = head;
        head = nuevo;
     }

    /**
     * Metodo que indica si la pila esta vacia
     * @return booleano que indica si estaba vacia o no
     */
     public boolean isEmpty(){
        return head == null;
     }

    /**
     * Obtiene el dato del primer elemento de la pila
     * @return retorna ese dato
     */
     public Tree_Node get_head(){
        return this.head.dato;
     }

    /**
     * Resetea la pila para dejarla vacia
     */
     public void reset(){
        this.head = null;
     }

    /**
     * Retorna el dato de la primera posicion de la pila y lo elimina
     * @return
     */
     public Tree_Node pop(){
        Tree_Node aux = null;
        if(!isEmpty()){
            aux = this.head.dato;
            this.head = this.head.next;
        }
        return aux;
     }
}
