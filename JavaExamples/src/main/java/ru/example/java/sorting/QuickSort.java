package ru.example.java.sorting;

import java.util.Arrays;
import java.util.List;

public class QuickSort {



    public static List<Integer> sort(Integer[] array, int start, int end){
        int left = start;
        int right = end;
        int pivot = array[(start + end) / 2];

        do {
            while (array[left] < pivot) left++;
            while (array[right] > pivot) right--;

            if(left <= right){
                if (left < right){
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                }
                left++;
                right--;
            }
        } while (left <= right);

        if (left < end) sort(array, left, end);
        if (start < right) sort(array, start, right);

        return Arrays.asList(array);
    }
}
