package Codigos_sala._Queue_.Collections._Queues_;

public abstract class AbstraticStaticQueue<E> implements Queue<E> {

    protected int size;
    protected E[] queue;
    private final int MAX_SIZE = 5;

    public AbstraticStaticQueue() {
        queue = (E[]) new Object[MAX_SIZE];
    }

    public AbstraticStaticQueue(int maxSize) {
        queue = (E[]) new Object[maxSize];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    protected boolean isFull() {
        return size == queue.length;
    }
}
