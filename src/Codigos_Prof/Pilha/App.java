package Codigos_Prof.Pilha;


import Codigos_Prof.Pilha.collections.DynamicStack;

public class App {
    public static void main(String[] args) throws Exception {
        DynamicStack<Integer> minhaPilha = new DynamicStack<>();
        minhaPilha.push(5);
        minhaPilha.push(3);
        minhaPilha.push(1);
        System.out.println(minhaPilha);
 


      
    }
}
