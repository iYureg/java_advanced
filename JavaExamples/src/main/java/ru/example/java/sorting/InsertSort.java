package ru.example.java.sorting;

import java.util.Arrays;
import java.util.List;

public class InsertSort {

    public static List<Integer> sort(Integer[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return Arrays.asList(array);
    }
}
