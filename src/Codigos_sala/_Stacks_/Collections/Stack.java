package Codigos_sala._Stacks_.Collections;

public interface Stack<E> {
    void push(E value);
    E pop();
    E top(); // E peek();
    int height();
    boolean isEmpty();
}
