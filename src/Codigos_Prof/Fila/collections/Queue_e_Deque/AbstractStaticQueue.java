package Codigos_Prof.Fila.collections.Queue_e_Deque;

public abstract class AbstractStaticQueue<E> implements Queue<E> {

    protected int size;
    protected E[] queue;
    private final int MAX_SIZE = 5;
    public AbstractStaticQueue(){
        queue = (E[]) new Object[MAX_SIZE];
    }
    public AbstractStaticQueue(int maxSize){
        queue = (E[]) new Object[maxSize];
    }

    @Override
    public boolean isEmpty() {        
        return size == 0;
    }


    public boolean isFull(){
        return size == queue.length;
    }

    @Override
    public int size() {        
        return size;
    }


    
}
