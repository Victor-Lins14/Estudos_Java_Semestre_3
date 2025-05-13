package Codigos_sala._Queue_;


import Codigos_sala._Queue_.Collections._Priority_Queue.UnsortedPriorityQueue;
import Codigos_sala._Queue_.Collections._Queues_.DynamicQueue;
import Codigos_sala._Queue_.Collections._Queues_.DynamicQueueStack;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        UnsortedPriorityQueue<Integer, String> myPriorityQueue = new UnsortedPriorityQueue<>();
        myPriorityQueue.enqueue(1, "Victor");
        myPriorityQueue.enqueue(2, "Gabriel");
        myPriorityQueue.enqueue(3, "Lorenzo");
        myPriorityQueue.enqueue(4, "Diogo");
        myPriorityQueue.enqueue(5, "BalkanRage");

        System.out.println(myPriorityQueue);
        myPriorityQueue.updateKey(1, 6);
        myPriorityQueue.updateKey(5, 1);
        System.out.println(myPriorityQueue);
        System.out.println(myPriorityQueue.maxPriority());
        System.out.println(myPriorityQueue.getEntryByKey(4)+"\n\n");


        DynamicQueueStack<Integer> myDynamicQueue = new DynamicQueueStack<>();

        for (int i = 0; i < 20; i++) {
            myDynamicQueue.enqueue(i);
        }

        System.out.println(myDynamicQueue);

        DynamicQueue<Integer> myDynamicQueue2 = new DynamicQueue<>();

        for (int i = 0; i < 20; i++) {
            myDynamicQueue2.enqueue(i);
        }

        System.out.println(myDynamicQueue2);

    }
}
