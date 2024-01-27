package ru.example.java.AlgoExamples;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] array = new int[10_000_000];
        for (int i = 0; i < array.length; i++) array[i] = r.nextInt(Integer.MAX_VALUE);
        System.out.print("Not sorted: ");
        for (int i = 0; i < 10; i++) System.out.printf("%d ",array[i]);


        System.out.println();
        long timer = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        System.out.printf("timer: %dms\n",System.currentTimeMillis() - timer);

        System.out.print("Sorted: ");
        for (int i = 0; i < 10; i++) System.out.printf("%d ",array[i]);
    }

    public static void quickSort(int[] arr, int start, int end){
        int left = start;
        int right = end;
        int pivot = arr[(start + end) / 2];

        do {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if(left <= right) {
                if(left < right){
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
                left++;
                right--;
            }
        } while (left <= right);

        if(left < end) quickSort(arr, left, end);
        if(start < right) quickSort(arr, start, right);
    }
}
