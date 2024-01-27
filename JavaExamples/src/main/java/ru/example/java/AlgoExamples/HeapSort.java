package ru.example.java.AlgoExamples;

import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] array = new int[10_000_000];
        for (int i = 0; i < array.length; i++) array[i] = r.nextInt(Integer.MAX_VALUE);
        System.out.print("Not sorted: ");
        for (int i = 0; i < 10; i++) System.out.printf("%d ",array[i]);


        System.out.println();
        long timer = System.currentTimeMillis();
        sort(array);
        System.out.printf("timer: %dms\n",System.currentTimeMillis() - timer);

        System.out.print("Sorted: ");
        for (int i = 0; i < 10; i++) System.out.printf("%d ",array[i]);
    }

    public static void sort(int[] arr){
        // построение кучи (перегруппируем массив)
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            heapify(arr, arr.length, i);
        }

        // один за другим извлекаем элементы из кучи
        for (int i = arr.length - 1; i >= 0 ; i--) {
            // перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // вызываем процедуру heapify на уменьшеной куче
            heapify(arr, i, 0);
        }
    }
    public static void heapify(int[] arr, int size, int root){
        int larg = root; // наибольший элемент как корень
        int lCh = 2 * root + 1; // левый = 2 * корень + 1
        int rCh = 2 * root + 2; // правый = 2 * корень + 2

        // если левый потомок больше корня
        if(lCh < size && arr[lCh] > arr[larg]) larg = lCh;
        // если правый потомок больше, чем самый большой элемент на данный момент
        if(rCh < size && arr[rCh] > arr[larg]) larg = rCh;


        // если самый большой элемент не корень
        if(larg != root) {
            int temp = arr[root];
            arr[root] = arr[larg];
            arr[larg] = temp;

            // рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, size, larg);
        }
    }
}
