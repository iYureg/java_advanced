package ru.example.java.looping;

import java.util.Scanner;

public class BreakContinue {
    public static void main(String[] args) {
        int number = 97;
        boolean flag = false;

        System.out.println("Проверим, простое ли число: " + number);
        for (int divisor = 2; divisor < number; divisor++) {
            int remainder = number % divisor; //The modulo operator gives the remainder of the division involved.
            if (remainder == 0) {
                System.out.println("Не простое число, потому что делится на " + divisor + ".");
                break; //Exit the for loop
            }
            if (divisor == number - 1) {
                System.out.println("Простое число!");
                flag = true;
            }

        }

        if (flag == false) {
            System.out.println("\nНайдем количество делителей этого числа.");
            int factor = 2;
            while (factor < number) {
                int remainder = number % factor; //The modulo operator gives the remainder of the division involved.
                factor++;
                if (remainder != 0) {
                    continue; //Proceed to the next iteration of the loop, ignoring the rest of this iteration.
                }
                System.out.println(factor - 1 + " делитель числа " + number);
            }
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int num = scanner.nextInt();
            if (num == 0) break;
            else if (num % 2 == 0) System.out.println("even");
            else System.out.println("odd");
            continue;
        }


        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {

            if (i % 5 == 0) {
                continue;
            } else if (i % 7 == 0) {
                System.out.println(i + ": stopped");
                break;
            } else {
                System.out.println(i);
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            for (int j = 0; j < 5; j++) {
                System.out.println(j);
                break;
            }
        }
    }
}
