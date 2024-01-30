package ru.example.java.primitiveTypes;

public class TypeCasting {
    public static void main(String[] args) {

        int num1 = (int) 55.90;
        int num2 = (int) 79.30;
        int num3 = (int) 168.088;

        double num4 = (double) 4;
        double num5 = (double) 9876;
        double num6 = (double) 13;

        System.out.println("num1 is " + num1 + " - " + Integer.class.getSimpleName());
        System.out.println("num2 is " + num2 + " - " + Integer.class.getSimpleName());
        System.out.println("num3 is " + num3 + " - " + Integer.class.getSimpleName());
        System.out.println("num4 is " + num4 + " - " + Double.class.getSimpleName());
        System.out.println("num5 is " + num5 + " - " + Double.class.getSimpleName());
        System.out.println("num6 is " + num6 + " - " + Double.class.getSimpleName());

        int n = 5, m = 2;
        double ans = n / (double) m;


        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(ans);

        int i = 9;
        double d = i; // Automatic casting: int to double

        System.out.println(i);      // Outputs 9
        System.out.println(d);   // Outputs 9.0

        double d2 = 9.78;
        int i2 = (int) d2; // Manual casting: double to int

        System.out.println(d2);   // Outputs 9.78
        System.out.println(i2);      // Outputs 9
    }
}
