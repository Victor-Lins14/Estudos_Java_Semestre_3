package Codigos_sala._Queue_.Collections._Queues_;

import Codigos_sala._Queue_.Exceptions.EmptyQueueException;

public interface Queue<E> {
    void enqueue(E value);
    E dequeue() throws EmptyQueueException;
    E first();
    int size(); // int length();
    boolean isEmpty();
}
