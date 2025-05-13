package Codigos_Prof.Fila.collections.Queue_e_Deque;

import Codigos_Prof.Fila.exceptions.EmptyQueueException;

public interface Deque<E> {
    void add(E value);
    void insert(E value);
    E removeFirst() throws EmptyQueueException;
    E removeLast() throws EmptyQueueException;
    E first() throws EmptyQueueException;
    E last() throws EmptyQueueException;
    int size();
    boolean isEmpty();
}
