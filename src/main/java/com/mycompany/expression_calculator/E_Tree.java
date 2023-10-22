package com.mycompany.expression_calculator;

import com.sun.source.tree.Tree;

public class E_Tree {
    Tree_Node root;

    public E_Tree(){
        this.root = null;
    }
    public E_Tree(String Expression){
        this.root = createTree(Expression);
    }
    public void reboot_Tree(){
        this.root = null;
    }

    public void create_Node(Object dato){

        this.root = new Tree_Node(dato);
    }

    public Tree_Node create_Subtree(Tree_Node dato2, Tree_Node dato1, Tree_Node operator){
        operator.izquierdo = dato1;
        operator.derecho = dato2;
        return operator;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public String getExpression(int a){
        String cadena = "";
        switch (a){
            case 0:
                cadena = preorder(this.root, cadena);
                break;
            case 1:
                cadena = inorder(this.root, cadena);
        }
        return cadena;
    }

    public String preorder(Tree_Node sub_tree, String c){
        String cadena;
        cadena = "";
        if(sub_tree != null){
            cadena = c + sub_tree.data.toString() + "\n" + preorder(sub_tree.izquierdo, c) + preorder(sub_tree.derecho, c);
        }
        return cadena;
    }

    public String inorder(Tree_Node sub_tree, String c){
        String cadena;
        cadena = "";
        if(sub_tree != null){
            cadena = c + inorder(sub_tree.izquierdo, c) + sub_tree.data.toString() + "\n" + inorder(sub_tree.derecho, c);
        }
        return cadena;
    }

    private int priority(char c){
        int p = 100;
        switch (c){
            case '*':
                p = 20;
                break;
            case '/':
                p = 20;
                break;
            case '+':
                p = 10;
                break;
            case '-':
                p = 10;
                break;
            default:
                p = 0;
        }
        return p;
    }

    public boolean isOperator(char c){
        boolean result;
        switch (c){
            case '(':
            case ')':
            case '*':
            case '/':
            case '+':
            case '-':
                result = true;
                break;
            default:
                result = false;
        }
        return result;
    }
    private Tree_Node createTree(String cadena){
        Tree_Stack StackOperators;
        Tree_Stack StackExpressions;
        Tree_Node token1;
        Tree_Node token2;
        Tree_Node op1;
        Tree_Node op2;
        Tree_Node op;
        StackOperators = new Tree_Stack();
        StackExpressions = new Tree_Stack();
        char caracter_evaludado;
        String valor = "";

        for(int i = 0; i < cadena.length(); i++){
            caracter_evaludado = cadena.charAt(i);
            token1 = new Tree_Node(valor);
            token2 = new Tree_Node(caracter_evaludado);
            if(!isOperator(caracter_evaludado)){
                valor += caracter_evaludado;
            }
            else{
                if(!valor.equals("")){
                    StackExpressions.insert(token1);
                }

                switch (caracter_evaludado){
                    case '(':
                        StackOperators.insert(token2);
                        break;
                    case ')':
                        while(!StackOperators.isEmpty() && !StackOperators.get_head().data.equals('(')){
                            op2 = StackExpressions.pop();
                            op1 = StackExpressions.pop();
                            op = StackOperators.pop();
                            op = create_Subtree(op2, op1, op);
                            StackExpressions.insert(op);
                        }
                        StackOperators.pop();
                        break;
                    default:
                        if (valor.equals("")){
                            token1 = new Tree_Node(0);
                            StackExpressions.insert(token1);
                        }
                        while(!StackOperators.isEmpty() && priority(caracter_evaludado) <= priority(StackOperators.get_head().data.toString().charAt(0))){
                            op2 = StackExpressions.pop();
                            op1 = StackExpressions.pop();
                            op = StackOperators.pop();
                            op = create_Subtree(op2, op1, op);
                            StackExpressions.insert(op);
                        }
                        StackOperators.insert(token2);
                }valor = "";
            }
        }
        while(!StackOperators.isEmpty()){
            op2 = StackExpressions.pop();
            op1 = StackExpressions.pop();
            op = StackOperators.pop();
            op = create_Subtree(op2, op1, op);
            StackExpressions.insert(op);
        }
        op = StackExpressions.pop();
        return op;

    }
    public double EvaluateExpression(){
        return evaluate(root);
    }

    public double evaluate(Tree_Node subtree){
        double acum = 0;
        if(!isOperator(subtree.data.toString().charAt(0))){
            return  Double.parseDouble(subtree.data.toString());
        }else{
            switch (subtree.data.toString().charAt(0)){
                case '*':
                    if (subtree.izquierdo == null) {
                        acum = acum + (1 * evaluate(subtree.derecho));
                    }else{
                        acum = acum + (evaluate(subtree.izquierdo) * evaluate(subtree.derecho));
                    }
                    break;
                case '/':
                    acum = acum + evaluate(subtree.izquierdo) / evaluate(subtree.derecho);
                    break;
                case '+':
                    if (subtree.izquierdo == null){
                        acum = acum + evaluate(subtree.derecho);
                    }else if (subtree.derecho == null){
                        acum = acum + evaluate(subtree.izquierdo);
                    }else{
                        acum = acum + evaluate(subtree.izquierdo) + evaluate(subtree.derecho);
                    }
                    break;
                case '-':
                    Tree_Node Neutro = new Tree_Node(0);
                    if (subtree.izquierdo == null){
                        acum = acum + evaluate(Neutro) - evaluate(subtree.derecho);
                    }else if (subtree.derecho == null){
                        acum = acum + evaluate(subtree.izquierdo) - evaluate(Neutro);
                    }else{
                        acum = acum + evaluate(subtree.izquierdo) - evaluate(subtree.derecho);
                    }
                    break;
            }
        }
        return acum;
    }

}
