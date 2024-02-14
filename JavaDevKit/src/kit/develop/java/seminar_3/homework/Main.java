package kit.develop.java.seminar_3.homework;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=".repeat(20) + "Task 1" + "=".repeat(20));

        Number result = Calculator.sum(3, 1);
        System.out.println(result);

        result = Calculator.mul(3.3, 8);
        System.out.println(result);

        result = Calculator.div(8, 3);
        System.out.println(result);

        result = Calculator.sbt(2, 2.2);
        System.out.println(result);

        // -------------------
        System.out.println("=".repeat(20) + " Task 2 " + "=".repeat(20));
        Integer[] arr1 = {1,2,3,4,5};
        Integer[] arr2 = {8,5,2,4,6};
        Short[] arr3 = {1,2,3,4,5};
        String[] arr4 = {"a", "b", "1", "2"};
        String[] arr5 = {"1", "2", "3", "4", "5"};
        String[] arr6 = {"1", "2", "a", "b"};

        System.out.println(arraysCompare(arr1,arr2));
        System.out.println(arraysCompare(arr1,arr3));
        System.out.println(arraysCompare(arr1,arr5));
        System.out.println(arraysCompare(arr4,arr5));
        System.out.println(arraysCompare(arr4,arr6));


        // ---------------------
        System.out.println("=".repeat(20) + " Task 3 " + "=".repeat(20));
        Pair<String, Integer> pair1 = new Pair<>("String", 1);
        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());
        System.out.println(pair1.toString());

        Pair<Long, Character> pair2 = new Pair<>(2L,'a');
        System.out.println(pair2.toString());

    }


    private static <T> boolean arraysCompare(T[] a1, T[] a2){
       return a1.length == a2.length && a1.getClass().getName().equals(a2.getClass().getName());
    }
}
