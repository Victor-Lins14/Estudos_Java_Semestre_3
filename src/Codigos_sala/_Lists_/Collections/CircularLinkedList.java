package Codigos_sala._Lists_.Collections;

import Codigos_sala._Lists_.Exceptions.EmptyListException;

public class CircularLinkedList<E> extends DoublyLinkedList<E> {


    @Override
    public E removeLast() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException("DLL is empty");
        E value = tail.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.before;
            tail.next = head;
            head.before = tail;
        }
        size--;
        return value;
    }

    @Override
    public E removeFirst() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException("DLL is empty");
        E value = head.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.before = tail;
            tail.next = head;
        }
        size--;
        return value;
    }

    @Override
    public E removeByIndex(int index) throws EmptyListException {
        if (isEmpty()) throw new EmptyListException("DLL is empty");
        checkIndex(index);
        E value = null;
        if (index == 0) {
            value = removeFirst();
        } else if (index == size-1) {
            value = removeLast();
        } else {
            Node auxNode = index >= size/2 ? getNodeFromTail(index) : getNode(index);
            value = auxNode.value;
            auxNode.before.next = auxNode.next;
            auxNode.next.before = auxNode.before;
            size--;
        }
        return value;
    }

    @Override
    public void add(E value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.before = tail;
            tail = newNode;
        }
        tail.next = head;
        head.before = tail;
        size++;
    }

    @Override
    public void insert(E value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.before = newNode;
            head = newNode;
        }
        tail.next = head;
        head.before = tail;
        size++;
    }

    @Override
    public void insert(int index, E value) {
        if (index<=0) {
            insert(value);
        } else if (index >= size){
            add(value);
        } else {
            Node auxNode = index >= size/2 ? getNodeFromTail(index) : getNode(index);
            Node newNode = new Node(value);
            newNode.next = auxNode;
            newNode.before = auxNode.before;
            auxNode.before.next = newNode;
            auxNode.before = newNode;
            size++;
        }
    }

    @Override
    public boolean set(int index, E value) throws EmptyListException {
        return super.set(index, value);
    }

    @Override
    public E get(int index) throws EmptyListException {
        return super.get(index);
    }

    @Override
    public String toString() {
//        StringBuilder dataString = new StringBuilder("[");
        String dataString = "[";
        Node auxNode = head;
//        for (int i = 0; i < size; i++) {
//            dataString += auxNode.value; //dataString.append(auxNode.value);
//            if (i != size-1) {
//                dataString += " ⇄ "; //dataString.append(" ⇄ "); // "\u21c4"
//            }
//            auxNode = auxNode.next;
//        }
        while(auxNode != tail) {
            dataString += auxNode.value; //dataString.append(auxNode.value);
            if (auxNode.next != tail) dataString += " ⇄ "; //dataString.append(" ⇄ "); // "\u21c4"
            auxNode = auxNode.next;
        }
        return dataString + "]";
    }

    @Override
    public String printReverse(){
//        StringBuilder listData = new StringBuilder("[");
        String listData = "[";
        Node auxNode = tail;
//        for (int i = size-1; i >= 0 ; i--) {
//            listData += auxNode.value; //listData.append(auxNode.value);
//            if (i != 0) {
//                listData += " ⇄ "; //listData.append(" ⇄ "); // "\u21c4"
//            }
//            auxNode = auxNode.before;
//        }
        while (auxNode!=head) {
            listData += auxNode.value; //listData.append(auxNode.value);
            if (auxNode.before != head) listData += " ⇄ "; //listData.append(" ⇄ "); // "\u21c4"
            auxNode = auxNode.before;
        }
        return listData + "]";
    }

    public void shiftLeft(int shift) {
        for (int i = 0; i < shift; i++) {
            head = head.next;
            tail = tail.next;
            tail.next = head;
            head.before = tail;
        }
    }

    public void shiftRight(int shift) {
        for (int i = 0; i < shift; i++) {
            head = head.before;
            tail = tail.before;
            tail.next = head;
            head.before = tail;
        }
    }

    public void reverse() {

        Node aux = head;
        for (int i = 0; i < size; i++) {
            Node temp = aux.next;
            aux.next = aux.before;
            aux.before = temp; // temp ~= aux.next
            aux = temp;
        }

        Node temp = head;
        head = tail;
        tail = temp;
    }
}
