package Codigos_sala._Lists_.Collections;

import Codigos_sala._Lists_.Exceptions.EmptyListException;
import Codigos_sala._Lists_.Exceptions.FullListException;

public class StaticList<E> implements List<E> {


    protected int size;
    protected E[] list;
    protected final int MAX_SIZE = 1000;

    @SuppressWarnings("unchecked")
    public StaticList() {
        list = (E[]) new Object[MAX_SIZE];
    }

    @SuppressWarnings("unchecked")
    public StaticList(int maxSize) {
        list = (E[]) new Object[maxSize];
    }

    @Override
    public void add(E value) throws FullListException {
        if(isFull()) throw new FullListException("Static List is Full!");
        list[size++] = value;

    }

    @Override
    public void insert(E value) {
        if(isFull()) throw new FullListException("Static List is Full!");

        for (int i = size; i > 0; i--) {
            list[i] = list[i-1];
        }
        list[0] = value;

    }

    @Override
    public void insert(int index, E value) {
        if(isFull()) throw new FullListException("Static List is Full!");
        if(index <= 0) {
            insert(value);
        } else if (index >= size) {
            add(value);
        } else {
            for (int i = size; i > index; i--) {
                list[i] = list[i-1];
            }
            list[index] = value;
        }

    }

    public boolean contains(E value) {
        for (int i = 0; i < size; i++) {
            if (value == list[i]) return true;
        }
        return false;
    }

    @Override
    public E removeLast() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException("Static List is Empty!");
        return list[--size];
    }

    @Override
    public E removeFirst() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException("Static List is Empty!");
        return removeByIndex(0);
    }

    @Override
    public E removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException {
        if (isEmpty()) throw new EmptyListException("Static List is Empty!");
        checkIndex(index);
        E value = list[index];
        size--;
        for (int i = 0; i < size; i++) {
            list[i] = list[i+1];
        }
        return value;
    }

    @Override
    public boolean set(int index, E value) throws EmptyListException {
        if (isEmpty()) throw new EmptyListException("Static List is Empty!");
        checkIndex(index);
        list[index] = value;
        return false;
    }

    @Override
    public E get(int index) throws EmptyListException {
        if (isEmpty()) throw new EmptyListException("Static List is Empty!");
        return list[index];
    }

    @Override
    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index<0 || index>=size)
            throw new IndexOutOfBoundsException(
                    "Available indexes are " +
                    "[0 -> "+(size-1)+"]");
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    @Override
    public String toString() {
        String listData = "[";
        for (int i = 0; i < size; i++) {
            listData += list[i];
            if (i < size - 1) {
                listData += ", ";
            }
        }
        return listData + "]";
    }
}
