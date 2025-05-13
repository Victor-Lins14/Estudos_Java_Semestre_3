package Codigos_sala._Lists_.Collections;

import Codigos_sala._Lists_.Exceptions.EmptyListException;

public class DoublyLinkedList<E> extends DynamicList<E> {

    //Com erros TODO
    public DoublyLinkedList<E> copy() {
        DoublyLinkedList<E> novaLista = new DoublyLinkedList<>();

        Node auxNode = head;
        for (int i = 0; i < size; i++) {
            novaLista.add(auxNode.value);
            auxNode = auxNode.next;
        }

        return novaLista;
    }

    public DoublyLinkedList(E[] array) {
        for (E value: array){
            if (value!= null) add(value);
        }
    }

    //Com erros TODO revisar
    public DoublyLinkedList(DoublyLinkedList<E> array) {
        if (array.size == 0) throw new EmptyListException("Ta vazio");

//        for (E value: array) {
//
//        }
        Node auxNode2 = array.head;
        head = auxNode2;
        Node auxNode = new Node(auxNode2.value);
        for (int i = 0; i < array.size; i++) {
            auxNode = new Node(auxNode2.value);
            auxNode = auxNode.next;
            size++;
        }

        tail = array.tail;

//        Node auxNode = head;
//        for (int i = 0; i < size; i++) {
//            this.add(auxNode.value);
//            auxNode = auxNode.next;
//        }
    }

    public DoublyLinkedList() {};

    public DoublyLinkedList<E> removeFirst(int index) {
        if (isEmpty()) throw new EmptyListException("DLL esta vazia");
        checkIndex(index);
        DoublyLinkedList<E> listaRemovida = new DoublyLinkedList<>();
        if (index == size-1) {
            listaRemovida.head = head;
            listaRemovida.tail = tail;
            head = null;
            tail = null;
        } else {
            Node auxNode = index >= size/2 ? getNodeFromTail(index) : getNode(index);
            listaRemovida.head = head;
            listaRemovida.tail = auxNode;
            head = auxNode.next;
            head.before.next = null;
            head.before = null;
        }
        size -= index+1;
        listaRemovida.size = index + 1;
        return listaRemovida;
    }
//    //Com erros TODO revisar
//    public DoublyLinkedList<E> removeFirst(int index) {
//        if(isEmpty()) throw new EmptyListException("DLL esta vazia");
//        DoublyLinkedList<E> listaRemovida = new DoublyLinkedList<>();
//        Node auxNode = head;
//        for (int i = 0; i < index; i++) {
//            listaRemovida.add(auxNode.value);
//            auxNode = auxNode.next;
//            size--;
//        }
//
//        if (size == 1) {
//            head = null;
//            tail = null;
//        } else {
//            head = getNode(index);
//            head.before = null;
//        }
//        return listaRemovida;
//    }

    //Com erros TODO revisar
    public DoublyLinkedList<E> removeLast(int index) {
        if(isEmpty()) throw new EmptyListException("DLL esta vazia");
        checkIndex(index);
        DoublyLinkedList<E> listaRemovida = new DoublyLinkedList<>();

        if (index == 0) {
            listaRemovida.head = head;
            listaRemovida.tail = tail;
            head = null;
            tail = null;
        }else{
            Node auxNode = getNode(index-1);
            listaRemovida.head = auxNode;
            listaRemovida.tail = tail;
            tail = auxNode.before;
            tail.next.before = null;
            tail.next = null;
        }
        size -= index+1;
        listaRemovida.size = index+1;
        return listaRemovida;
    }
//    //Com erros TODO revisar
//    public DoublyLinkedList<E> removeLast(int index) {
//        if(isEmpty()) throw new EmptyListException("DLL esta vazia");
//        DoublyLinkedList<E> listaRemovida = new DoublyLinkedList<>();
//        Node auxNode = getNode(index);
//        int tam = size;
//        for (int i = index; i < tam; i++) {
//            listaRemovida.add(auxNode.value);
//            auxNode = auxNode.next;
//            size--;
//        }
//        if(size == 1){
//            head = null;
//            tail = null;
//        }else{
//            tail = getNode(index-1);
//            tail.next = null;
//        }
//        return listaRemovida;
//    }


    //Com erros TODO revisar
    public DoublyLinkedList<E> removeByIndex(int index1, int index2) {
        if (index1 > index2) {
            int aux = index1;
            index1 = index2;
            index2 = aux;
        }
        DoublyLinkedList<E> listaRemovida = null;
        if (index1 == 0) {
            listaRemovida = removeFirst(index2);
        } else if (index2 == size-1) {
            listaRemovida = removeLast(index1);
        } else {
            Node auxNode1 = getNode(index1);
            Node auxNode2 = getNode(index2);
            listaRemovida = new DoublyLinkedList<>();
            listaRemovida.head = auxNode1;
            listaRemovida.tail = auxNode2;
            auxNode1.before.next = auxNode2.next;
            auxNode2.next.before = auxNode1.before;
            auxNode1.before = null;
            auxNode2.next = null;
            size -= (index2+index1-1);
            listaRemovida.size = (index2+index1-1);
        }

        return listaRemovida;
    }
//    //Com erros TODO revisar
//    public DoublyLinkedList<E> removeByIndex(int index1, int index2) {
//        if(isEmpty()) throw new EmptyListException("DLL esta vazia");
//        DoublyLinkedList<E> listaRemovida = new DoublyLinkedList<>();
//        Node auxNode = getNode(index1);
//        for (int i = index1; i <= index2; i++) {
//            listaRemovida.add(auxNode.value);
//            auxNode = auxNode.next;
//            size--;
//        }
//        if(size == 1) {
//            head = null;
//            tail = null;
//        } else if (index1 != 0) {
//            Node auxNode1 = getNode(index1);
//            Node auxNode2 = getNode(index2);
//            auxNode1.before.next = auxNode2.next;
//            auxNode2.before.next = auxNode1.before;
//        }
//
//        return listaRemovida;
//    }
//
    Node getNodeFromTail(int index) {
        Node auxNode = tail;
        for(int i = size-1; i > index; i--) {
            auxNode = auxNode.before;
        }
        return auxNode;
    }

    @Override
    public void add(E value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.before = tail;
        }
        tail = newNode;
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
    public E removeLast() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException("DLL is empty");
        E value = tail.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.before;
            tail.next = null;
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
            head.before = null;
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
//            Node auxNode = index >= size/2 ? getNodeFromTail(index-1) : getNode(index-1);
            //Usando auxNode == Node no index-1
//            value = auxNode.next.value;
            //Primeiro jeito
//            auxNode.next.next.before = auxNode;    //auxNode.next = auxNode.next.next;   x
//            auxNode.next = auxNode.next.next;      //auxNode.next.next.before = auxNode; x
            //Segundo jeito
//            auxNode.next = auxNode.next.next;
//            auxNode.next.before = auxNode.next.before.before;
            size--;
        }
        return value;
    }

    @Override
    public boolean set(int index, E value) throws EmptyListException {
        if (isEmpty()) throw new EmptyListException("DLL is empty");
        checkIndex(index);
        Node auxNode = index >= size/2 ? getNodeFromTail(index) : getNode(index);
        auxNode.value = value;
        return true;
    }

    @Override
    public E get(int index) throws EmptyListException {
        if (isEmpty()) throw new EmptyListException("DLL is empty");
        checkIndex(index);
        Node auxNode = index >= size/2 ? getNodeFromTail(index) : getNode(index);
        return auxNode.value;
    }

    public boolean contains(E value) throws EmptyListException {
        if (isEmpty()) throw new EmptyListException("DLL is empty");
        Node auxNode = head;
        for (int i = 0; i < size; i++) {
            auxNode = auxNode.next;
            if (auxNode.value == value) return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        String dataString = "[";
        Node auxNode = head;
        while(auxNode != null) {
            dataString += auxNode.value;
            if (auxNode.next != null) dataString += " ⇄ "; // "\u21c4"
            auxNode = auxNode.next;
        }
        return dataString + "]";
    }

    public String printReverse(){
        String listData = "[";
        Node auxNode = tail;
        while (auxNode!=null) {
            listData += auxNode.value;
            if (auxNode.before != null) listData += " ⇄ "; // "\u21c4"
            auxNode = auxNode.before;
        }
        return listData + "]";
    }
}









