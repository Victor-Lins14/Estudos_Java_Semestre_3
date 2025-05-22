package Codigos_sala._Hash_.collections;

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
        return null;
    }

    @Override
    public Entry<K, V> delete(K key) {
        return null;
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
