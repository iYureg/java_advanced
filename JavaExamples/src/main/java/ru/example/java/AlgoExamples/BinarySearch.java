package ru.example.java.AlgoExamples;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[100_000_000];
        for (int i = 0; i < array.length; i++) array[i] = i + 1;


        long timer = System.currentTimeMillis();
        binarySearch(array, 39_999_999, 0, array.length - 1);
        System.out.printf("binSearch: %dms",System.currentTimeMillis() - timer);


        System.out.println();

        timer = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 39_999_999) System.out.printf("indexSearch: %dms ",System.currentTimeMillis() -timer );
        }
    }

    public static int binarySearch(int[] arr, int value, int min, int max){
        int midPoint;

        if (max < min) {
            return -1;
        } else {
            midPoint = (max - min) / 2 + min;
        }

        if (arr[midPoint] < value) {
            return binarySearch(arr, value, midPoint + 1, max);
        } else {
            if (arr[midPoint] > value){
                return binarySearch(arr, value, min, midPoint - 1);
            } else {
               return midPoint;
            }
        }
    }
}
