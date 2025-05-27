package Codigos_sala._Tree_;

import Codigos_sala._Tree_.Colletions.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> mySBT = new BinarySearchTree<>();

        mySBT.insert(7);
        mySBT.insert(200);
        mySBT.insert(2);
        mySBT.insert(4);
        mySBT.insert(6);
        mySBT.insert(12);
        mySBT.insert(10);
        mySBT.insert(3);
        mySBT.insert(8);

        System.out.println(mySBT.treeTraversal());
    }
}
