package Codigos_sala._Queue_.Collections._Queues_;

import Codigos_sala._Queue_.Exceptions.EmptyQueueException;
import Codigos_sala._Queue_.Exceptions.FullQueueException;

public class CircularStaticQueue<E> extends AbstraticStaticQueue<E> {


    public CircularStaticQueue() {
        super();
    }

    public CircularStaticQueue(int maxSize) {
        super(maxSize);
    }

    protected int first = 0;


    @Override
    public void enqueue(E value) throws FullQueueException {
        if (isFull()) throw new FullQueueException("A Fila está cheia");
        queue[(first + size)% queue.length] = value;
        size++;
    }



    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException("A Fila está vazia");
        E value = first();
        first = (first+1)% queue.length;
        size--;

        return value;
    }

    @Override
    public E first() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException("A fila está vazia");
        return queue[first];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
