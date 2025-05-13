package Codigos_sala._Recursion_;

public class Recursao {
    public static long factorial(long n) {
        if (n < 0) throw new RuntimeException("Apenaas existem fatorial de " +
                "números maiores ou iguais a zero");
        if (n == 0) {
            return 1;
        }
        return n*factorial(n-1);
    }

    public static int metodoRecursivoErrado(int x) {
        System.out.println(x);
        x++;
        if (x == 200000) {
            return 0;
        }
        return metodoRecursivoErrado(x);
    }

    private static int linearSum(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index];
        }
        int aux = linearSum(array,index + 1);
        return array[index] + aux;
    }

    public static int linearSum(int[] array) {
        return linearSum(array, 0);
    }
}
