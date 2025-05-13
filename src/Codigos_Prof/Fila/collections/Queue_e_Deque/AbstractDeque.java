package Codigos_Prof.Fila.collections.Queue_e_Deque;

public abstract class AbstractDeque<E> implements Deque<E> {

    protected int size;

    @Override
    public boolean isEmpty() {        
        return size == 0;
    }

    @Override
    public int size() {        
        return size;
    }



}
