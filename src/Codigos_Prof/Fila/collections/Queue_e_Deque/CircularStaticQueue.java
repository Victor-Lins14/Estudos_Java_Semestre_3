package Codigos_Prof.Fila.collections.Queue_e_Deque;

import Codigos_Prof.Fila.exceptions.EmptyQueueException;
import Codigos_Prof.Fila.exceptions.FullQueueException;

public class CircularStaticQueue<E> extends AbstractStaticQueue<E> {

    private int first;
    public CircularStaticQueue(){
        super();
    }
    public CircularStaticQueue(int maxSize){
        super(maxSize);
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        E value = first();
        first = (first+1)%queue.length;
        size--;
        return value;
    }

    @Override
    public void enqueue(E value) throws FullQueueException {
        if(isFull()) throw new FullQueueException();
        queue[(first + size)%queue.length] = value;
        size++;

    }

    @Override
    public E first() throws EmptyQueueException {
        if(isEmpty()) throw new EmptyQueueException();
        return queue[first];
    }
    @Override
    public String toString() {
        String queueData = "\\/First\n";
        String aux = "";
        for(int i = 0; i<size; i++){
            queueData += queue[(first+i)%queue.length];
            if(i < size-1){
                String dado = queue[(first+i)%queue.length].toString();
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
