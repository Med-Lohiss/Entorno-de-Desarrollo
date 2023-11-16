package es.iessoterohernandez.daw.endes.fibonacci;

public class Fibonacci {
    public void imprimirSecuenciaFibonacci(int x) {
        for (int i = 0; i < x; i++) {
            System.out.print(calcularFibonacci(i) + " ");
        }
    }

    private int calcularFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
        }
    }
}