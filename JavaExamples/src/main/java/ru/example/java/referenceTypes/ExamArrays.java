package ru.example.java.referenceTypes;

import java.util.Arrays;

public class ExamArrays {
    static int[][][] array = new int[3][3][3];
    static String[] weekDays = new String[] {"Monday ", "Tuesday ", "Wednesday ", "Thursday ", "Friday ","Saturday ","Sunday "};
    static int[] primes = {2, 3, 5, 7, 11, 13, 17};


    public static void main(String[] args) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("[ ");
            for (int j = 0; j < array.length; j++) {
                System.out.print("[ ");
                for (int k = 0; k < array.length; k++) {

                    System.out.print(array[i][j][k]);
                }
                System.out.println(" ]");
            }
            System.out.println("]");
        }
        System.out.println("]");

        for (int i=0; i<7; i++)
        {
            System.out.print(weekDays[i]);
            System.out.println(primes[i]);
        }

        System.out.println(Arrays.toString(getLettersList("letters")));
    }

    public static String[] getLettersList(String value){
        String[] letters = new String[value.length()];
        for (int i = 0; i < value.length(); i++) {
            letters[i] = value.substring(i, i+1);
        }
        return letters;
    }
}
