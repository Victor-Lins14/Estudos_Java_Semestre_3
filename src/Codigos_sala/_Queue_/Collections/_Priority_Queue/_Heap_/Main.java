package Codigos_sala._Queue_.Collections._Priority_Queue._Heap_;

import Codigos_sala._Queue_.Collections._Priority_Queue._Heap_.Collections.Heap;

public class Main {
    public static void main(String[] args) {
        Heap<Integer,String> meuHeap2 = new Heap<>();
        meuHeap2.enqueue(18, "18");
        meuHeap2.enqueue(5, "5");
        meuHeap2.enqueue(12, "12");
        meuHeap2.enqueue(20, "20");
        meuHeap2.enqueue(9, "9");
        meuHeap2.enqueue(7, "7");
        System.out.println(meuHeap2);
        meuHeap2.dequeue();
        System.out.println(meuHeap2);
        meuHeap2.dequeue();
        System.out.println(meuHeap2);
    }
}
