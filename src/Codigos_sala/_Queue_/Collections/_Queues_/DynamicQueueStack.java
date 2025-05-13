package Codigos_sala._Queue_.Collections._Queues_;

import Codigos_sala._Queue_.Exceptions.EmptyQueueException;
import Codigos_sala._Queue_.Exceptions.FullQueueException;
import Codigos_sala._Stacks_.Collections.DynamicStack;
import Codigos_sala._Stacks_.Collections.Stack;
import Codigos_sala._Stacks_.Collections.StaticStack2;

public class DynamicQueueStack<E> implements Queue<E> {

    private final DynamicStack<E> pilha1;
    private final DynamicStack<E> pilha2;

    public DynamicQueueStack() {
        pilha1 = new DynamicStack<>();
        pilha2 = new DynamicStack<>();
    }


    @Override
    public void enqueue(E value) {
        pilha1.push(value);
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Fila está vazia");
        }

        // Transferir todos os elementos da pilha1 para a pilha2
        while (pilha1.height() > 1) {
            pilha2.push(pilha1.pop());
        }

        // Pegar o último elemento da pilha1 (que é o primeiro da fila)
        E toRemove = pilha1.pop();

        // Devolver todos os elementos da pilha2 para a pilha1
        while (!pilha2.isEmpty()) {
            pilha1.push(pilha2.pop());
        }

        return toRemove;
    }

    @Override
    public E first() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Fila está vazia");
        }

        // Transferir todos os elementos da pilha1 para a pilha2
        while (pilha1.height() > 1) {
            pilha2.push(pilha1.pop());
        }

        // Pegar o último elemento da pilha1 (que é o primeiro da fila)
        E toRemove = pilha1.pop();

        // Coloca o resultado de volta na pilha2
        pilha2.push(toRemove);

        // Devolver todos os elementos da pilha2 para a pilha1
        while (!pilha2.isEmpty()) {
            pilha1.push(pilha2.pop());
        }

        return toRemove;
    }

    @Override
    public int size() {
        return pilha1.height();
    }

    @Override
    public boolean isEmpty() {
        return pilha1.isEmpty();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        String aux = "";
        String queueData = "  \\/First\n [";

        // Transferimos todos os elementos para a pilha2 (invertendo a ordem)
        while (!pilha1.isEmpty()) {
            pilha2.push(pilha1.pop());
        }

        // Agora percorremos a pilha2 (que está na ordem correta da fila)
        while (!pilha2.isEmpty()) {
            E elemento = pilha2.pop();
            String dado = elemento.toString();
            queueData += dado;
            if (!pilha2.isEmpty()) {
                for(int j = 0; j < dado.length(); j++){
                    aux += " ";
                }
                aux += "  ";
                queueData += ", ";
            }
            // Colocamos de volta na pilha1
            pilha1.push(elemento);
        }
        return queueData + "]\n"+aux+"  /\\Last";
    }
}
