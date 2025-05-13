package Codigos_Prof.Fila.collections.PriorityQueue;


import java.util.Comparator;


public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {

    class Node{
        Node next;
        Node prev;
        Entry<K,V> entry;
        public Node(Entry<K, V> entry) {
            this.entry = entry;
        }   
        public Node(K key, V value){
            entry = new PriorityEntry(key, value);
        }
    }

    class PriorityEntry implements Entry<K,V>{
        private K key;
        private V value;
        
        public PriorityEntry(K key, V value) {
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

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
        
        
    }
    
    protected int size;
    protected Node first;
    protected Node last;

    protected Comparator<K> myComparator;

    public AbstractPriorityQueue() {
        myComparator = new MyComparator<>();
    }

    protected int compare(Entry<K,V> e1, Entry<K,V> e2){
        return myComparator.compare(e1.getKey(), e2.getKey());
    }

    protected int compare(Node n1, Node n2){
        return compare(n1.entry,n2.entry);
    }

    @Override
    public boolean isEmpty() {        
        return size==0;
    }

    @Override
    public int size() {        
        return size;
    }

    @Override
    public String toString() {
        String priorityQueueData = "";
        Node auxNode = first;
        while(auxNode!=null){
            priorityQueueData += auxNode.entry;
            auxNode = auxNode.next;
            if(auxNode!=null){
                priorityQueueData += ", ";
            }
        }
        return priorityQueueData;
    }


    

    
}
