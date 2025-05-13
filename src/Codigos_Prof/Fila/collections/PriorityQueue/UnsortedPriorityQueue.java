package Codigos_Prof.Fila.collections.PriorityQueue;


import Codigos_Prof.Fila.exceptions.EmptyQueueException;

public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    private Node getMaxPriorityNode(){ // O(n)
        if(isEmpty()) throw new EmptyQueueException();
        Node maxPriority = first;
        Node auxNode = first.next;
        while(auxNode!=null){
            int comp = compare(auxNode, maxPriority);
            if(comp < 0){
                maxPriority = auxNode;
            }
            auxNode = auxNode.next;
        }
        return maxPriority;
    }

    @Override
    public Entry<K, V> dequeue() { // O(n)
        Node toRemove = getMaxPriorityNode();
        if(toRemove == first){
            first = first.next;
            if(size == 1){
                last = first;
            }else{
                first.prev = null;
            }
        }else if(toRemove == last){
            last = last.prev;
            last.next = null;
        }else{
            toRemove.next.prev = toRemove.prev;
            toRemove.prev.next = toRemove.next;
        }
        size--;
        return toRemove.entry;
    }

    @Override
    public void enqueue(K key, V value) { //O(1)
        Node newNode = new Node(key,value);
        if(isEmpty()){
            first = newNode;
        }else{
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;
        size++;        
    }

    @Override
    public Entry<K, V> maxPriority() { //O(n)
        return getMaxPriorityNode().entry;
    }

    

}
