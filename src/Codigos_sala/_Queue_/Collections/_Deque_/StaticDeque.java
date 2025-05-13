package Codigos_sala._Queue_.Collections._Deque_;

import Codigos_Prof.Fila.exceptions.EmptyQueueException;
import Codigos_Prof.Fila.exceptions.FullQueueException;

public class StaticDeque<E> extends AbstraticDeque<E> {

    private E[] deque;
    private int first;

    private final int MAX_SIZE = 5;
    public StaticDeque() {
        deque = (E[]) new Object[MAX_SIZE];
    }
    public StaticDeque(int maxSize) {
        deque = (E[]) new Object[maxSize];
    }

    public boolean isFull(){
        return size == deque.length;
    }

    @Override
    public void add(E value) throws FullQueueException {
        if (isFull()) throw new FullQueueException();
        deque[(first+size++)%deque.length] = value;
    }

    @Override
    public void insert(E value) throws FullQueueException {
        if (isFull()) throw new FullQueueException();
        first--;
        if (first == 0) {
            deque[deque.length-1] = value;
        } else {
            deque[first] = value;
        }
        deque[(first+deque.length)%deque.length] = value;

    }

    @Override
    public E first() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        return deque[first];
    }

    @Override
    public E removeFirst() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        E value = first();
        first = (first + 1)%deque.length;
        size--;
        return value;
    }

    @Override
    public E last() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        return deque[(first+size-1)%deque.length];
    }

    @Override
    public E removeLast() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        E value = last();
        size--;
        return value;
    }

    @Override
    public String toString() {
        String queueData = "\\/First\n";
        String aux = "";
        for(int i = 0; i<size; i++){
            queueData += deque[(first+i)%deque.length];
            if(i < size-1){
                String dado = deque[(first+i)%deque.length].toString();
                for(int j = 0; j < dado.length(); j++){
                    aux += " ";
                }
                aux += "  ";
                queueData+=", ";
            }
        }
        return queueData+"\n"+aux+"/\\Last";
    }
}
