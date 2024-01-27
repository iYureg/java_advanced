package ru.example.java.conditions;

import java.util.Scanner;

public class TernaryOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int n = scanner.nextInt();

        // YOUR CODE HERE: If 'n' is less than 5, output 'LOW'. If 'n' is exactly 5, output 'MID'. If 'n' is greater than 5, output 'HIGH'.
        String result = n == 5 ? "MID" : n > 5 ? "HIGH" : "LOW";
        System.out.println(result);
    }
}
