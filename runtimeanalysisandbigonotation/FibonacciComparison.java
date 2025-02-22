package com.bridgelabz.runtimeanalysisandbigonotation;



public class FibonacciComparison {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int first = 0, second = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public static void main(String[] args) {
        int n = 40;

        long startTimeRecursive = System.nanoTime();
        int fibRec = fibonacciRecursive(n);
        long endTimeRecursive = System.nanoTime();
        System.out.println("Recursive Fibonacci(" + n + "): " + fibRec);
        System.out.println("Recursive Time: " + (endTimeRecursive - startTimeRecursive) / 1_000_000 + " ms");

        long startTimeIterative = System.nanoTime();
        int fibIter = fibonacciIterative(n);
        long endTimeIterative = System.nanoTime();
        System.out.println("Iterative Fibonacci(" + n + "): " + fibIter);
        System.out.println("Iterative Time: " + (endTimeIterative - startTimeIterative) / 1_000_000 + " ms");
    }
}

