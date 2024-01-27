package ru.example.java.AlgoExamples;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class FibonacciRec {
    public static int fibSum(int position, AtomicLong count) {
        count.incrementAndGet();
        if (position == 1 || position == 2){
            return 1;
        }
        return fibSum(position - 1, count) + fibSum(position - 2, count);
    }

    public static void main(String[] args) {
        AtomicLong c = new AtomicLong(0);
        int fibo = fibSum(11, c);
        System.out.printf("Fibonacci sum: %d operations: %d", fibo, c.get());
    }
}
