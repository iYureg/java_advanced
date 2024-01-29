package ru.example.java.looping;

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
            if (divisor == number - 1){
                System.out.println("Простое число!");
                flag = true;
            }

        }

        if(flag == false){
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
    }
}
