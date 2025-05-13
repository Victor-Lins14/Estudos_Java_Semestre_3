package Codigos_sala._Lists_.Collections;

import Codigos_sala._Lists_.Exceptions.EmptyListException;

public interface List<E> {

    void add(E value); //Inserir no final da lista
    void insert(E value); //Inserir no começo da lista
    void insert(int index, E value); //Inserir em um lugar qualquer na lista

    E removeLast() throws EmptyListException;
    E removeFirst() throws EmptyListException;
    E removeByIndex(int index) throws EmptyListException;

    boolean set(int index, E value) throws EmptyListException;
    E get(int index) throws EmptyListException;

    int size();
    boolean isEmpty();

}
