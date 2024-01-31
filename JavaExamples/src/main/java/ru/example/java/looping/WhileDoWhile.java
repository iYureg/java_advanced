package ru.example.java.looping;

import java.util.Scanner;

public class WhileDoWhile {
    public static void main(String[] args) {
        // region
        char letter = 'A';
        while (letter <= 'Z') {
            System.out.print(letter);
            letter++;
        }
        System.out.println();
        // end region


        try (Scanner scanner = new Scanner(System.in)) {
            // region
//
            int value;
            do {
                value = scanner.nextInt();
                System.out.println(value);
            } while (value != 0);
//


            // end region

            // region
//
            int sum = 0;
            while (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
//
            // end region


            int sum2 = 0;
            do {
                sum2 += scanner.nextInt();
            } while (scanner.hasNextInt() && scanner.nextInt() != 0);
            System.out.println(sum);


        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
