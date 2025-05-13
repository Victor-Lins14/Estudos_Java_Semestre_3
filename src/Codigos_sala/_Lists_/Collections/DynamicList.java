package Codigos_sala._Lists_.Collections;

public abstract class DynamicList<E> implements List<E> {

    class Node {
        E value;
        Node next;
        Node before;
        public Node(E value) {
            this.value = value;
        }
    }

    protected int size;
    protected Node head;
    protected Node tail;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    protected void checkIndex(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    protected Node getNode(int index) {
        Node auxNode = head;
        for (int i = 0; i < index; i++) {
            auxNode = auxNode.next;
        }
        return auxNode;
    }

    @Override
    public String toString() {
        String dataString = "[";
        Node auxNode = head;
        while(auxNode != null) {
            dataString += auxNode.value;
            if (auxNode.next != null) dataString += " -> ";
            auxNode = auxNode.next;
        }
        return dataString + "]";
    }
}
