package Codigos_sala._Stacks_.Collections;

import Codigos_sala._Stacks_.Exceptions.FullStackException;

import java.util.EmptyStackException;

public class StaticStack2<E> implements Stack<E> {

    private int height;
    private E[] stack;
    private final int MAX_HEIGHT = 2000;

    public StaticStack2(int maxHeight) {
        stack = (E[]) new Object[maxHeight];
    }

    public StaticStack2() {
        stack = (E[]) new Object[MAX_HEIGHT];
    }

    public boolean isFull() {
        return height == stack.length;
    }

    @Override
    public void push(E value) throws FullStackException {
        if (isFull()) throw new FullStackException("Stack is Full!");
        stack[height++] = value;
    }

    @Override
    public boolean isEmpty() {
        return height == 0;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        /*E value = top();
        height--;
        return value;*/
        return stack[--height];
    }

    @Override
    public E top() {
        if(isEmpty()) throw new EmptyStackException();

        return stack[height-1];
    }

    @Override
    public int height() {
        return height;
    }

    public String toString() {
        String dataStack = "top -> ";

        for (int i = height-1; i >= 0; i--) {
            dataStack += stack[i];
            if (i>0) {
                dataStack += "\n       ";
            }
        }
        return dataStack + " <- bottom";
    }
}
