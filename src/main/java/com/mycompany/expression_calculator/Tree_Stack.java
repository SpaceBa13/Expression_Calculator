package com.mycompany.expression_calculator;

public class Tree_Stack {
    private Stack_Node head;

    public Tree_Stack(){
        head = null;
    }
     public void insert(Tree_Node element){
        Stack_Node nuevo;
        nuevo = new Stack_Node(element);
        nuevo.next = head;
        head = nuevo;
     }
     public boolean isEmpty(){
        return head == null;
     }

     public Tree_Node get_head(){
        return this.head.dato;
     }

     public void reset(){
        this.head = null;
     }

     public Tree_Node pop(){
        Tree_Node aux = null;
        if(!isEmpty()){
            aux = this.head.dato;
            this.head = this.head.next;
        }
        return aux;
     }
}
