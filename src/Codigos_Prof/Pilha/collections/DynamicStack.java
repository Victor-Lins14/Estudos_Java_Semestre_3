package Codigos_Prof.Pilha.collections;


import java.util.EmptyStackException;

public class DynamicStack<E> implements Stack<E> {

    
    class Node{
        E value;
        Node next;
        public Node(E value){
            this.value = value;
            next = null;
        }
        @Override
        public String toString() {
            return "[" + value + "]";
        }

        
    }

    private Node top;
    private int height;

    
    
    @Override
    public int height() {        
        return height;
    }

    @Override
    public boolean isEmpty() {        
        // if(top == null){
        //     return true;
        // }
        // return false;
        return top == null;
    }

    @Override
    public E pop() {
        E value = top();
        top = top.next;
        height--;
        return value;
    }

    @Override
    public void push(E value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        height++;       
        
    }


    @Override
    public E top() {        
        if(isEmpty()) throw new EmptyStackException();        
        return top.value;
    }

    @Override
    public String toString() {
        String dataString = "top -> ";

        Node auxNode = top;
        while (auxNode!=null) {
            dataString += auxNode;
            auxNode = auxNode.next;
            if(auxNode!=null){
                dataString += "\n       ";
            }
            
        }
        if(isEmpty()){
            return "";
        }else{
            return dataString + " <- bottom";
        }
        // return isEmpty()?"":dataString+" <- bottom";
    }


    

    

}
