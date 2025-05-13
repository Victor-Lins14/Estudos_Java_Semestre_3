package Codigos_sala._Matrix_;

public class Main {
    static long cont = 0;
    public static void main(String[] args) {
        int[][][] matriz3D = {
                {
                    {1, 9, 9},
                    {9, 9, 9},
                    {9, 9, 9}
                },
                {
                    {9, 9, 9},
                    {9, 1, 9},
                    {9, 9, 9}
                },
                {
                    {9, 9, 9},
                    {9, 9, 9},
                    {9, 9, 1}
                }
        };

//        System.out.println(traco3DVersao1(matriz3D));
//        System.out.println(traco3DVersao2(matriz3D));
//        System.out.println(traco3DVersao3(matriz3D));
        System.out.println(funcaoMisteriosa(33));
        System.out.println(cont);
    }

    public static void qualquerCoisa(int[][][] matriz) {

    }

    public static long funcaoMisteriosa(long n) {
        cont++;
        if (n == 1) {
            return 1;
        }
        return funcaoMisteriosa(n-1) + funcaoMisteriosa(n-1);
    }

    public static int traco3DVersao1(int[][][] matriz) {
        int soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                for (int k = 0; k < matriz[i][j].length; k++) {
                    if (i == j && j == k) {
                        soma += matriz[i][j][k];
                    }
                }
            }
        }
        return soma;
    }
    public static int traco3DVersao2(int[][][] matriz) {
        int soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    soma += matriz[i][j][j];
                }

            }
        }
        return soma;
    }

    public static int traco3DVersao3(int[][][] matriz) {
        int soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            soma += matriz[i][i][i];
        }
        return soma;
    }
}
