package Codigos_sala._Hash_.collections;

import Codigos_sala._Hash_.exceptions.EmptyHashTableException;
import Codigos_sala._Hash_.exceptions.FullHashTableException;

public class HashTable<K, V> extends AbstractHashTable<K, V> {

    public HashTable(int mapSize) {
        super(mapSize);
    }

    @Override
    public void set(K key, V value) {
        Node newNode = new Node(key, value);
        int index = hashFunction(key);

        if (hashTable[index] == null) {
            hashTable[index] = newNode;
        } else {
            Node auxNode = hashTable[index];
            while (auxNode!=null) {
                if (key.equals(auxNode.entry.getKey())) {
                    auxNode.entry.setValue(value);
                    return;
                }
                auxNode = auxNode.next;
            }

            newNode.next = hashTable[index];
            hashTable[index].prev = newNode;
            hashTable[index] = newNode;
        }
        size++;
    }

    @Override
    public Entry<K, V> get(K key) {
        if (isEmpty()) throw new EmptyHashTableException("HashTable está vazia");
        return getNodeByKeyAtIndex(key, hashFunction(key)).entry;
    }

    private Node getNodeByKeyAtIndex(K key, int index) {
        Node auxNode = hashTable[index];
        while (auxNode!=null) {
            if (key.equals(auxNode.entry.getKey())) {
                return auxNode;
            }
            auxNode = auxNode.next;
        }
        return null;
    }

    @Override
    public Entry<K, V> delete(K key) {
        int index = hashFunction(key);
        Node toRemove = getNodeByKeyAtIndex(key, index);
        if (toRemove == null) return null;
        if (toRemove == hashTable[index]) {
            hashTable[index] = hashTable[index].next;
            if (hashTable[index] != null) {
                hashTable[index].prev = null;
            }
        } else if (toRemove.next == null) {
            toRemove.prev.next = null;
        } else {
            toRemove.next.prev = toRemove.prev;
            toRemove.prev.next = toRemove.next;
        }
        size--;
        return toRemove.entry;
    }

    @Override
    public String toString() {
        String hashData = "";

        for (int i = 0; i < hashTable.length; i++) {
            hashData += "[" + i + "]:";
            Node auxNode = hashTable[i];
            while (auxNode!=null){
                hashData += auxNode.entry;
                if (auxNode.next!=null) {
                    hashData += " -> ";
                }
                auxNode = auxNode.next;
            }
            hashData += "\n";
        }
        return hashData;
    }
}
