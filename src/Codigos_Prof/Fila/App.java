package Codigos_Prof.Fila;

import Codigos_sala._Queue_.Collections._Priority_Queue._Heap_.Collections.Heap;

public class App {
    public static void main(String[] args) throws Exception {
//        DynamicQueue<String> minhaFila = new DynamicQueue<>();
//        minhaFila.enqueue("Emanuelle");
//        minhaFila.enqueue("Luis Augusto");
//        minhaFila.enqueue("Arthur Wermont");
//        minhaFila.enqueue("A");
//
//        System.out.println(minhaFila);
//        System.out.println("Tamanho: "+minhaFila.size());
//        System.out.println("Primeiro(a): "+minhaFila.first());
//
//        System.out.println("Removendo:"+minhaFila.dequeue());
//        System.out.println(minhaFila);
//
//        DynamicDeque<String> myDeque = new DynamicDeque<>();
//        myDeque.add("Vivian");
//        myDeque.add("Gabriel");
//        myDeque.insert("Guilherme");
//        myDeque.removeLast();
//        System.out.println(myDeque);
//        System.out.println(myDeque.printReverse());

        Heap<Integer, String> meuHeap = new Heap<>();
        meuHeap.enqueue(2, "Emanuelle");
        meuHeap.enqueue(56, "Arthur");
        meuHeap.enqueue(69, "Cu");
        meuHeap.enqueue(99, "Bunda");
        meuHeap.enqueue(24, "Brabo");
        System.out.println(meuHeap);
    }
}
