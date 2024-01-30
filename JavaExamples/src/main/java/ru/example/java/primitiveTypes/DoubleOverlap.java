package ru.example.java.primitiveTypes;

public class DoubleOverlap {
    public static void main(String[] args) {

        // int x = 1.1;  // the variable x is an int and the value 1.1 is a double.
        double y = 1;   // convert the int to a double automatically.

        double d;
        d = 1 / 2;
        System.out.println(d);
        d = 1.0 / 2.0;
        System.out.println(d);



        double floatDivision = 15.0 / 2;
        int intDivision = 15 / 2;
        int remainder = 15 % 2;

        System.out.println("Floating-Point Division = " + floatDivision);
        System.out.println("Integer Division = " + intDivision);
        System.out.println("remainder = " + remainder);
    }
}
