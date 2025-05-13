package Codigos_sala._Lists_;

import Codigos_sala._Lists_.Collections.*;

public class Main {
    public static void main(String[] args) throws Exception {
        DoublyLinkedList<Integer> myDLL = new DoublyLinkedList<>();

        int tamanho = 10;
        for (int i = 0; i < 10; i++) {
            myDLL.add(i);
        }


        System.out.println("myDLL: " + myDLL);
//        System.out.println(myDLL.removeByIndex(1,5));
//        System.out.println("lista removida: " + myDLL.removeLast(0));
        System.out.println("lista removida: " + myDLL.removeFirst(4));
        System.out.println("myDLL: " + myDLL);
        System.out.println("myDLL ao contrario: " + myDLL.printReverse());

//        int n = 5;
//        System.out.println(fatorial(n, 0));
    }

//    public static int fatorial(int n, int i) {
//        if (n<0) throw new IllegalArgumentException("n deve ser maior ou igual a zero");
//
//        if(i == n) {
//            return 1;
//        }
//        ++i;
//        int fat = fatorial(n, i);
//
//        int resultado = i * fat;
//
//        System.out.println("("+i+"*"+fat+")");
//
//        return resultado;
//
////        return ++i * fatorial(n, i);
//    }

}
