package ru.example.java.operators;

public class BinOperations {
    public static void main(String[] args) {
        int num = 10;

        System.out.println(num >> 2 << 2);
        System.out.println(num << 2);

        System.out.println(num | 10);
        System.out.println(num & 7);
    }
}
