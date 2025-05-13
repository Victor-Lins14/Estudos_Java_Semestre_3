package Codigos_Prof.Fila.collections.Queue_e_Deque;


import Codigos_Prof.Fila.exceptions.EmptyQueueException;
import Codigos_Prof.Fila.exceptions.FullQueueException;

public class StaticDeque<E> extends AbstractDeque<E> {

    private E[] deque;    
    private int first;

    private final int MAX_SIZE = 5;
    public StaticDeque(){
        deque = (E[]) new Object[MAX_SIZE];
    }
    
    public StaticDeque(int maxSize){
        deque = (E[]) new Object[maxSize];
    }

    public boolean isFull(){
        return size == deque.length;
    }

    @Override
    public void add(E value) throws FullQueueException {
        if(isFull()) throw new FullQueueException();
        deque[(first+size)%deque.length] = value;
        size++;
        
    }
    
    @Override
    public E first() throws EmptyQueueException {
        if(isEmpty()) throw new EmptyQueueException();
        return deque[first];
    }
    
    @Override
    public void insert(E value) {
        if(isFull()) throw new FullQueueException();
        first = (first-1+deque.length)%deque.length;
        deque[first] = value;
        
    }
    
    @Override
    public E last() throws EmptyQueueException {
        if(isEmpty()) throw new EmptyQueueException();        
        return deque[(first+size-1)%deque.length];
    }

    @Override
    public E removeFirst() throws EmptyQueueException {
        E value = first();
        first = (first + 1)%deque.length; 
        size--;
        return value;
    }

    @Override
    public E removeLast() throws EmptyQueueException {
        E value = last();
        size--;
        return value;
    }

    @Override
    public String toString() {
        String dequeData = "";
        for(int i = 0; i < size; i++){
            dequeData += deque[(first+i)%deque.length];
            if(i<size-1){
                dequeData+=", ";
            }
        }
        return dequeData;
    }


    




    

}
