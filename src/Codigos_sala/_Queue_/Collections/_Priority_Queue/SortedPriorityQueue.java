package Codigos_sala._Queue_.Collections._Priority_Queue;

import Codigos_sala._Queue_.Exceptions.EmptyQueueException;

public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    @Override
    public Entry<K, V> dequeue() { //O(1)
        if (isEmpty()) throw new EmptyQueueException();

        // Retorna o primeiro elemento da fila (maior prioridade)
        Entry<K, V> result = first.entry;

        // Remove o primeiro elemento
        first = first.next;
        if (first == null) {
            // Se a fila ficou vazia
            last = null;
        } else {
            first.prev = null;
        }
        size--;

        return result;
    }

    @Override
    public void enqueue(K key, V value) { //O(n)
        Node newNode = new Node(key, value);

        // Caso especial: fila vazia
        if (isEmpty()) {
            first = last;
            last = newNode;
            size++;
            return;
        }

        // Caso especial: nova entrada tem prioridade menor que o primeiro elemento
        // (lembre-se que valores menores indicam maior prioridade nesta implementação)
        if (compare(newNode, first) <= 0) {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
            size++;
            return;
        }

        // Caso especial: nova entrada tem prioridade maior que o último elemento
        // (deve ser adicionado ao final)
        if (compare(newNode, last) > 0) {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
            size++;
            return;
        }

        // Caso geral: percorre a lista para encontrar a posição correta de inserção
        Node current = first;
        while (current != null && compare(newNode, current) > 0) {
            current = current.next;
        }

        // Insere o novo nó antes do nó current
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    @Override
    public Entry<K, V> maxPriority() { //O(1)
        if (isEmpty()) throw new EmptyQueueException();

        // Retorna o primeiro elemento da fila (maior prioridade)
        // sem removê-lo
        return first.entry;
    }
}