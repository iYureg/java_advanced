package ru.example.java.conditions;

import java.util.Scanner;

public class ConditionIsCube {

    public static void main( String args[] ){
        Scanner sc = new Scanner( System.in );
        System.out.print("Input a number: ");
        int num = sc.nextInt();
        int n = (int) Math.round(Math.pow(num, 1.0/3.0)); // корень числа

        if((num == n * n * n))
        {
            System.out.print("Number is a cube.");
        }
        else
        {
            System.out.print("Number is not a cube.");
        }
    }
}
