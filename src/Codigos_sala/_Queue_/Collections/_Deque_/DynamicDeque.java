package Codigos_sala._Queue_.Collections._Deque_;

import Codigos_Prof.Fila.exceptions.EmptyQueueException;

public class DynamicDeque<E> extends AbstraticDeque<E> {

    class Node{
        Node next;
        Node prev;
        E value;
        public Node(E value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Node last;
    private Node first;

    @Override
    public void add(E value) {
        Node newNode = new Node(value);
        if (size == 1) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;
        size++;
    }

    @Override
    public void insert(E value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    @Override
    public E removeFirst() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        E value = first();
        first = first.next;
        if(size==1){
            last = first;
        }else{
            // first.prev.next = null;
            first.prev = null;
        }
        size--;
        return value;
    }

    @Override
    public E removeLast() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        E value = last();
        last = last.prev;
        if(size==1){
            first = last;
        }else{
            // last.next.prev = null;
            last.next = null;
        }
        size--;
        return value;
    }

    @Override
    public E first() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        return first.value;
    }

    @Override
    public E last() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        return last.value;
    }

    public String printReverse() {
        String dequeData = "";
        Node auxNode = last;
        while(auxNode!=null){
            dequeData += auxNode;
            auxNode = auxNode.prev;
            if(auxNode!=null){
                dequeData += ", ";
            }
        }
        return dequeData;
    }

    @Override
    public String toString() {
        String dequeData = "";
        Node auxNode = first;
        while(auxNode!=null){
            dequeData += auxNode;
            auxNode = auxNode.next;
            if(auxNode!=null){
                dequeData += ", ";
            }
        }
        return dequeData;
    }
}
