package Codigos_sala._Stacks_;

import Codigos_sala._Stacks_.Collections.StaticStack1;

public class Main {
    public static void main(String[] args) throws Exception {
        StaticStack1<Integer> minhaPilha = new StaticStack1<>(10);

        minhaPilha.push(2);
        minhaPilha.push(3);
        minhaPilha.push(8);
        minhaPilha.push(68);
        System.out.println(minhaPilha);

        System.out.println("Removendo o topo: " +minhaPilha.pop());

        System.out.println(minhaPilha);
    }
}
