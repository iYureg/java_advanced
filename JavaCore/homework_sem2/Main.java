package JavaCore.homework_sem2;

import java.util.Arrays;
import java.util.Random;

import JavaCore.homework_sem2.Task1.EvensCounter;
import JavaCore.homework_sem2.Task2.DifferenceFinder;
import JavaCore.homework_sem2.Task3.NeighborChecker;

/**
 * 1. Написать метод, возвращающий количество чётных элементов массива.
 * countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3,
 * 5]) → 0
 * 
 * 2. Написать функцию, возвращающую разницу между самым большим и самым ма-
 * леньким элементами переданного не пустого массива.
 * 
 * 3. Написать функцию, возвращающую истину, если в переданном массиве есть два
 * соседних элемента, с нулевым значением.
 */
public class Main {
    static Random r = new Random();

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++)
            array[i] = r.nextInt(5);

        // Task_1
        System.out.printf("Количество четных чисел в массиве: %s - : %d ", Arrays.toString(array),
                EvensCounter.count(array));

        // Task_2
        System.out.printf("\nРазница между макс и мин элементами: %s -: %d ", Arrays.toString(array),
                DifferenceFinder.find(array));

        // Task_3
        System.out.printf("\nЕсть ли соседние нули в массивеЖ %s -: %s ", Arrays.toString(array),
                NeighborChecker.chekZero(array));

    }

}