package Codigos_sala._Queue_.Collections._Deque_;

public abstract class AbstraticDeque<E> implements Deque<E> {
    protected int size;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
