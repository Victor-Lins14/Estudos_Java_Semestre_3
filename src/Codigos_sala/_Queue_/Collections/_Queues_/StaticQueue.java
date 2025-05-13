package Codigos_sala._Queue_.Collections._Queues_;

import Codigos_sala._Queue_.Exceptions.EmptyQueueException;
import Codigos_sala._Queue_.Exceptions.FullQueueException;

public class StaticQueue<E> extends AbstraticStaticQueue<E> {

    public StaticQueue() {
        super();
    }

    public StaticQueue(int maxSize) {
        super(maxSize);
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException("Fila está vazia");
        E element = queue[0];

        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        // Limpa a referência do último elemento e decrementa o tamanho
        queue[--size] = null;

        return element;
    }



    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E value) throws FullQueueException {
        if (isFull()) throw new FullQueueException("Fila está cheia");
        queue[size++] = value;
    }

    @Override
    public E first() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException("Fila está vazia");
        return queue[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder queueData = new StringBuilder("\\/First\n");
        StringBuilder aux = new StringBuilder();
        for(int i = 0; i<size; i++){
            queueData.append(queue[i]);
            if(i < size-1){
                String dado = queue[i].toString();
                aux.append(" ".repeat(dado.length()));
                aux.append("  ");
                queueData.append(", ");
            }
        }
        return queueData+"\n"+aux+"/\\Last";
    }
}
