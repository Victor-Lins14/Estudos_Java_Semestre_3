package Codigos_sala._Hash_.collections;

public abstract class AbstractHashTable<K, V> implements Map<K, V> {


    class Node {
        Node next;
        Node prev;
        Entry<K, V> entry;

        public Node (Entry<K,V> entry) {
            this.entry = entry;
        }

        public Node(K key, V value) {
            this.entry = new HashEntry(key, value);
        }
    }

    class HashEntry implements Entry<K, V> {
        private K key;
        private V value;

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }


        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + ": " + value+ "}";
        }
    }

    protected int size;
    protected Node[] hashTable;

    public AbstractHashTable(int mapSize) {
        hashTable = (Node[]) new AbstractHashTable<?,?>.Node[mapSize];
    }

    @Override
    public int size() {
        return size;
    }

    protected int hashFunction(K key) {
        if (key instanceof String) {
            return compression(hashCode((String) key));
        }
        throw new RuntimeException("Key data type is not supported yet");
    }

    public int compression(int hashCode) {
        return hashCode>=0? hashCode%hashTable.length : (hashCode*-1)%hashTable.length;
    }

    public static int hashCode(String key) {
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) {
            hashCode = (hashCode<<5) | hashCode>>>27;
            hashCode += key.charAt(i);
        }
        return hashCode;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }


}
