package Codigos_Prof.Fila.collections.Queue_e_Deque;


import Codigos_Prof.Fila.exceptions.*;

public class StaticQueue<E> implements Queue<E> {

    private int size;
    private E[] queue;

    private final int MAX_SIZE = 4;

    public StaticQueue(){
        queue =(E[]) new Object[MAX_SIZE];
    }

    public StaticQueue(int maxSize){
        queue =(E[]) new Object[maxSize];
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        E value = first();
        size--;
        for(int i = 0; i < size; i++){
            queue[i] = queue[i+1];
        }
        return value;
    }

    @Override
    public E first() throws EmptyQueueException {
        if(isEmpty()) throw new EmptyQueueException();
        return queue[0];
    }

    @Override
    public void enqueue(E value) throws FullQueueException {
        if(isFull()) throw new FullQueueException();
        queue[size] = value;        
        size++;
    }

    public boolean isFull(){
        return size == queue.length;
    }


    @Override
    public boolean isEmpty() {        
        return size == 0;
    }

    @Override
    public int size() {        
        return size;
    }

    @Override
    public String toString() {
        String queueData = "\\/First\n";
        String aux = "";
        for(int i = 0; i<size; i++){
            queueData += queue[i];
            if(i < size-1){
                String dado = queue[i].toString();
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
