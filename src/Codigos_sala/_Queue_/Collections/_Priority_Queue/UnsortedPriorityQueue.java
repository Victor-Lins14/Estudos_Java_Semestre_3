package Codigos_sala._Queue_.Collections._Priority_Queue;

import Codigos_sala._Queue_.Exceptions.EmptyQueueException;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    private Node getMaxPriorityNode() { // O(n)
        if(isEmpty()) throw new EmptyQueueException();
        Node maxPriority = first;
        Node auxNode = first.next;
        while (auxNode!=null) {
            int comp = compare(auxNode, maxPriority);
            // auxNode < maxPriority -> comp < 0
            // auxNode > maxPriority -> comp > 0
            // auxNode == maxPriority -> comp == 0
            if (comp < 0) {
                maxPriority = auxNode;
            }
            auxNode = auxNode.next;
        }
        return maxPriority;
    }


    @Override
    public Entry<K, V> dequeue() { // O(n)
        Node toRemove = getMaxPriorityNode();
        if (toRemove == first) {
            first = first.next;
            if (size == 1) {
                last = first;
            } else {
                first.prev = null;
            }
        } else if (toRemove == last) {
            last = last.prev;
            last.next = null;
        } else {
            toRemove.next.prev = toRemove.prev;
            toRemove.prev.next = toRemove.next;
        }
        size--;
        return toRemove.entry;
    }

    @Override
    public void enqueue(K key, V value) { //O(1)
        Node newNode = new Node(key, value);
        if(isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;
        size++;
    }

    @Override
    public Entry<K, V> maxPriority() {
        return getMaxPriorityNode().entry;
    }

    public void updateKey(K key, K newKey) {
        Node auxNode = first;
        boolean exception = false;
        while (auxNode != null) {
            int comp = myComparator.compare(auxNode.entry.getKey(), key);
            if (comp == 0) {
                V value = auxNode.entry.getValue();
                auxNode.entry = new PriorityEntry(newKey, value);
                exception = true;
            }
            auxNode = auxNode.next;
        }
        if (!exception) throw new EmptyQueueException("Esta key não existe");
    }

    public void updateKey1(K key, K newKey) {
        Entry<K, V> auxEntry = getEntryByKey(key);
        auxEntry.setKey(newKey);
    }

    public Entry<K, V> getEntryByKey(K key) {
        Node auxNode = first;
        Node node = getMaxPriorityNode();
        boolean exception = false;
        for (int i = 0; i < size; i++) {
            if (auxNode.entry.getKey() == key) {
                node = auxNode;
                exception = true;
            }
            auxNode = auxNode.next;
        }
        if (!exception) throw new EmptyQueueException("Essa key não existe");
        return node.entry;
    }

}
