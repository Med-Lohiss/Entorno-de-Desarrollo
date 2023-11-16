package es.iessoterohernandez.daw.endes.fibonacciMain;

import es.iessoterohernandez.daw.endes.fibonacci.Fibonacci;


public class FibonacciMain {
    public static void main(String[] args) {
            Fibonacci fibonacci = new Fibonacci();
            int cantidadNumeros = 10; // Este nùmero puede cambiar para imprimir la secuencia hasta la posición deseada!
            fibonacci.imprimirSecuenciaFibonacci(cantidadNumeros);
        }
    }
