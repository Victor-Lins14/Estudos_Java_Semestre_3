package Codigos_Prof.Fila.collections.PriorityQueue;

public class Heap<K,V> extends AbstractHeap<K,V> {

    @Override
    public Entry<K, V> dequeue() {
        Entry<K,V> entry = maxPriority();
        heap[0] = heap[size-1];
        if(size > 1) sinkDown(0);
        size--;
        return entry;
    }
    protected void sinkDown(int min){
        int current;
        int leftChild,rightChild;
        do{
            current = min;
            leftChild = leftChild(current);
            rightChild = rightChild(current);

            if(leftChild < size-1 && compare(leftChild, min)<0){
                // key1 = heap[leftChild].getKey()
                // key2 = heap[min].getKey()
                // if (key1 > key2) -> compare(leftChild, min) < 0 ::: Entra
                // if (key1 < key2) -> compare(leftChild, min) > 0 ::: Não entra
                // if (key1 == key2) -> compare(leftChild, min) == 0 ::: Não entra
                min = leftChild;
            }
            if(rightChild < size-1 && compare(rightChild, min)<0){
                // key1 = heap[rightChild].getKey()
                // key2 = heap[min].getKey()
                // if (key1 > key2) -> compare(rightChild, min) < 0 ::: Entra
                // if (key1 < key2) -> compare(rightChild, min) > 0 ::: Não entra
                // if (key1 == key2) -> compare(rightChild, min) == 0 ::: Não entra
                min = rightChild;
            }                        
            if(current!=min){
                swap(min, current);          
            }
        }while(current!=min);
    }

    private void bubblingUp(int current){
        int parent = parent(current);
        while(current > 0 && compare(current, parent) < 0){
            // key1 = heap[atual].getKey()
            // key2 = heap[parent].getKey()
            // if (key1 > key2) -> compare(atual, parent) < 0 ::: Entra
            // if (key1 < key2) -> compare(atual, parent) > 0 ::: Não entra
            // if (key1 == key2) -> compare(atual, parent) == 0 ::: Não entra
            swap(current, parent);
            current = parent;
            parent = parent(current);
        }
    }

    @Override
    public void enqueue(K key, V value) {
        if(isFull()) throw new RuntimeException();        
        heap[size] = new HeapEntry(key, value);   
        bubblingUp(size++);             
    }

    @Override
    public Entry<K, V> maxPriority() {
        if(isEmpty()) throw new RuntimeException();
        return heap[0];
    }
    

}
