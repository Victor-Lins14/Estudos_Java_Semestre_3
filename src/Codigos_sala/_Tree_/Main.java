package Codigos_sala._Tree_;

import Codigos_sala._Tree_.Colletions.BinarySearchTree;
import Codigos_sala._Tree_.Colletions.RecursiveBinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> mySBT = new BinarySearchTree<>();

        mySBT.insert(200);
        mySBT.insert(50);
        mySBT.insert(250);
        mySBT.insert(25);
        mySBT.insert(55);
        mySBT.insert(230);
        mySBT.insert(300);
        mySBT.insert(60);
        mySBT.insert(220);
        mySBT.insert(225);


        System.out.println();
        System.out.println(mySBT.treeTraversal("preOrder"));
        mySBT.delete(225);
        System.out.println(mySBT.treeTraversal("preOrder"));
        System.out.println(mySBT.internalNodeCount());
        System.out.println(mySBT.isFull());


    }
}
