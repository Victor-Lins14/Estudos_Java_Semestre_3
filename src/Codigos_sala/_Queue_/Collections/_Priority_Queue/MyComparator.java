package Codigos_sala._Queue_.Collections._Priority_Queue;

import java.util.Comparator;

public class MyComparator<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {

//        if(o1 instanceof String) {
//            if(((UnsortedPriorityQueue)o1).size() == 1) {
//                return 1;
//            }
//        }

        return ((Comparable<T>)o1).compareTo(o2);
    }
}
