package ru.example.java.objOP;

import java.util.ArrayList;

public class AvgCalculator {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) arr.add(i);


        System.out.println(getAverageOf(arr));
    }

    public static double getAverageOf(ArrayList<Integer> numbers) {
        int sum = 0;
        for (Integer elem : numbers) sum += elem;
        System.out.println("sum: "+sum);
        System.out.println("size: " + numbers.size());
        return (double) sum / numbers.size();
    }

}
