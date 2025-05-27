package Codigos_sala._Hash_;

import Codigos_sala._Hash_.collections.HashTable;

public class Main {
    public static void main(String[] args) {
//        byte b1 = 0b0110_0010;
//        System.out.println(b1);
//
//        byte b2 = (byte)(b1<<2);
//        System.out.println(b2);
//
//        byte b3 = (byte)(b1>>>6);
//        System.out.println(b2 | b3);
        HashTable<String, Integer> zara = new HashTable<>(1);
        zara.set("Sapato B", 50);
        zara.set("Perfume", 88);
        zara.set("Cropped P", 120);
        zara.set("Jersey P", 320);
        zara.set("Perfume", 10);
        System.out.println(zara);
        zara.delete("Perfume");
        System.out.println(zara);

    }

    public static int compression(int hashCode, int N) {
        return hashCode>=0? hashCode%N : (hashCode*-1)%N;
    }

    public static int hashCode(String key) {
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) {
            hashCode = (hashCode<<5) | hashCode>>>27;
            hashCode += key.charAt(i);
        }
        return hashCode;
    }

}
