package ru.example.java.objOP;

public class Overloader {
    private static class Show{

        static void showType(int value){
            System.out.printf("\nvalue: %d type: %s", value, Integer.class.getSimpleName());
        }

        static void showType(String value){
            System.out.printf("\nvalue: %s type: %s", value, String.class.getSimpleName());
        }
    }


    public static void main(String[] args) {
        Show.showType(10);
        Show.showType("string");
    }
}
