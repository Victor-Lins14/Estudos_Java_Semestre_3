package Codigos_Prof.Fila.collections.Queue_e_Deque;

import Codigos_Prof.Fila.exceptions.*;

public interface Queue<E>{
    void enqueue(E value);
    E dequeue() throws EmptyQueueException;
    E first() throws EmptyQueueException;
    int size(); // int length();
    boolean isEmpty();
}
