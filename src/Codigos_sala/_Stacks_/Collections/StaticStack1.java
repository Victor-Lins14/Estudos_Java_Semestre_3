package Codigos_sala._Stacks_.Collections;

import Codigos_sala._Stacks_.Exceptions.FullStackException;
import Codigos_sala._Lists_.Collections.StaticList;

import java.util.EmptyStackException;

public class StaticStack1<E> implements Stack<E> {

    private StaticList<E> stack;

    public StaticStack1() {
        stack = new StaticList<>();
    }

    public StaticStack1(int maxSize) {
        stack = new StaticList<>(maxSize);
    }

    @Override
    public int height() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        return stack.removeLast();
    }

    public boolean isFull(){
        return stack.isFull();
    }

    @Override
    public void push(E value) {
        if (isFull()) throw new FullStackException("Stack esta cheia");
        stack.add(value);
    }

    @Override
    public E top() {
        if (isFull()) throw new FullStackException("Stack esta cheia");
        return stack.get(stack.size()-1);
    }

    public String toString() {
        String dataStack = "top -> ";

        for (int i = stack.size()-1; i >= 0; i--) {
            dataStack += stack.get(i);
            if (i>0) {
                dataStack += "\n       ";
            }
        }

        return dataStack + " <- bottom";
    }
}
