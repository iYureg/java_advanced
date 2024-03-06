package ru.example.java.sorting;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static List<Integer> sort(Integer[] array){
        boolean flag;

        do {
            flag = true;
            for (int i = 0; i < array.length - 1; i++) {
                if(array[i] > array[i + 1]){
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = false;
                }
            }
        } while (!flag);
        return Arrays.asList(array) ;
    }
}
