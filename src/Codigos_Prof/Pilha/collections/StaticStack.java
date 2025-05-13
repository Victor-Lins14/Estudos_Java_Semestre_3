package Codigos_Prof.Pilha.collections;


import Codigos_Prof.Pilha.exceptions.FullStackException;

import java.util.EmptyStackException;


public class StaticStack<E> implements Stack<E> {

    private int height;
    private E[] stack;

    private final int MAX_HEIGHT = 5;

    public StaticStack(int maxHeight){
        stack = (E[]) new Object[maxHeight];
    }

    public StaticStack(){
        stack = (E[]) new Object[MAX_HEIGHT];
    }

    
    public boolean isFull(){
        return height == stack.length;
    }

    @Override
    public boolean isEmpty() {     
        return height == 0;   
        // if(height == 0){
        //     return true;
        // }
        // return false;        
    }

    @Override
    public E top() {
        if(isEmpty()) throw new EmptyStackException();
        return stack[height-1];
    }

    @Override
    public E pop() {        
        E value = top();
        height--;
        return value;
        // return stack[--height];
    }

    @Override
    public void push(E value) {
        if(isFull()) throw new FullStackException("Stack is full!");
        stack[height++] = value;
        // height++;        
    }

   

    @Override
    public int height() {
        
        return height;
    }


    public String toString(){
        String dataStack = "top -> ";
        for(int i = height-1; i>=0; i--){
            dataStack += stack[i];
            if(i>0){
                dataStack += "\n       ";
            }
        }
        return dataStack+" <- bottom";
    }
    
    

}
