package ru.example.java.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static Random rnd = new Random();

    public static void main(String[] args) {

//        Integer[] integers = new Integer[10000];

        Integer[] integers = new Integer[1000000];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = rnd.nextInt(1_000_000);
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(integers[i] + " ");
        }
        System.out.println();

        long timer = System.currentTimeMillis();
//        List<Integer> sorted = InsertSort.sort(integers);  // 10k 300ms

//        List<Integer> sorted = BubbleSort.sort(integers);  // 10k 600ms
        List<Integer> sorted = QuickSort.sort(integers, 0, integers.length - 1); // 1kk 250ms !


        for (int i = 0; i < 10; i++) {
            System.out.print(sorted.get(i) + " ");
        }
        System.out.println();
        System.out.printf("timer: %dms", System.currentTimeMillis() - timer);
    }
}
