package Codigos_Prof.Pilha.collections;


public interface Stack<E> {
    void push(E value);
    E pop();
    E top(); //E peek();
    int height();
    boolean isEmpty();
}
