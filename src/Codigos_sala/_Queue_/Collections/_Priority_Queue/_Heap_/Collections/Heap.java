package Codigos_sala._Queue_.Collections._Priority_Queue._Heap_.Collections;


import Codigos_sala._Queue_.Collections._Priority_Queue._Heap_.Exceptions.FullQueueException;
import Codigos_sala._Queue_.Collections._Priority_Queue.Entry;
import Codigos_sala._Queue_.Exceptions.EmptyQueueException;

public class Heap<K, V> extends AbstractHeap<K, V> {

    @Override
    public void enqueue(K key, V value) {
        if (isFull()) throw new FullQueueException();
        heap[size] = new HeapEntry(key, value);
        bubblingUp(size);
        size++;
    }

    public void bubblingUp(int atual) {
        int parent = parent(atual);
        while(atual > 0 && compare(atual,parent) < 0) {
            // key1 = heap[atual].getKey()
            // key2 = heap[parent].getKey()
            // if (key1 > key2) -> compare(atual, parent) > 0 ::: Não entra
            // if (key1 < key2) -> compare(atual, parent) < 0 ::: Entra
            // if (key1 == key2) -> compare(atual, parent) == 0 ::: Não entra
            swap(atual,parent);
            atual = parent;
            parent = parent(atual);
        }
    }

    @Override
    public Entry<K, V> dequeue() {
        Entry<K, V> entry = maxPriority();
        heap[0] = heap[size-1];
        if (size>1) {
            sinkDown(0);
        }
        size--;
        return entry;
    }

    public void sinkDown(int min) {
        int leftChild, rightChild, current;

        do{
            current = min;
            leftChild = leftChild(current);
            rightChild = rightChild(current);


            if (leftChild < size-1 && compare(leftChild, min) < 0) {
                if (heap[leftChild] != null) System.out.println("leftChild.key = " + heap[leftChild].getKey() + " < " + heap[min].getKey());
                // key1 = heap[leftChild].getKey()
                // key2 = heap[min].getKey()
                // if (key1 > key2) -> compare(leftChild, min) > 0 ::: Não entra
                // if (key1 < key2) -> compare(leftChild, min) < 0 ::: Entra
                // if (key1 == key2) -> compare(leftChild, min) == 0 ::: Não entra
                min = leftChild;
            }


            if (rightChild < size-1 && compare(rightChild, min) < 0) {
                if (heap[leftChild] != null) System.out.println("rightChild.key = " + heap[rightChild].getKey() + " < " + heap[min].getKey());
                // key1 = heap[rightChild].getKey()
                // key2 = heap[min].getKey()
                // if (key1 > key2) -> compare(rightChild, min) > 0 ::: Não entra
                // if (key1 < key2) -> compare(rightChild, min) < 0 ::: Entra
                // if (key1 == key2) -> compare(rightChild, min) == 0 ::: Não entra
                min = rightChild;
            }

            if (current != min){
                swap(current, min);
            }

        } while(current!=min);

    }

    @Override
    public Entry<K, V> maxPriority() {
        if(isEmpty()) throw new EmptyQueueException();
        return heap[0];
    }
}
