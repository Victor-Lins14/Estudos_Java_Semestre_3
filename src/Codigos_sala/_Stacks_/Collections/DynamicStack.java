package Codigos_sala._Stacks_.Collections;

import java.util.EmptyStackException;

public class DynamicStack<E> implements Stack<E> {

    class Node{
        E value;
        Node next;
        public Node(E value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + value + "]";
        }
    }

    private Node top;
    private int height;

    @Override
    public int height() {
        return height;
    }

    @Override
    public boolean isEmpty() {
        return height == 0;
        // return top == null;
    }

    @Override
    public void push(E value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        height++;
    }

    @Override
    public E top() {
        if (isEmpty()) throw new EmptyStackException();
        return top.value;
    }

    @Override
    public E pop() {
        E value = top();
        top = top.next;
        height--;
        return value;
    }

    @Override
    public String toString() {
        String dataString = "top -> ";

        Node auxNode = top;
        while (auxNode != null) {
            dataString += auxNode;
            auxNode = auxNode.next;
            if (auxNode != null) {
                dataString += "\n       ";
            }
        }
        return isEmpty()? "" : dataString + " <- bottom" ;
    }
}
