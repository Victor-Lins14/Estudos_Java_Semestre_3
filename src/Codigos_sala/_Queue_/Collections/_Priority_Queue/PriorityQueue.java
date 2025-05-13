package Codigos_sala._Queue_.Collections._Priority_Queue;

public interface PriorityQueue<K, V> {
    void enqueue(K key, V value);
    Entry<K, V> dequeue();
    Entry<K, V> maxPriority();
    int size();
    boolean isEmpty();
}
