package ru.example.java.looping;

public class NestedLoop {
    public static void main(String[] args) {

        System.out.println("Вот мой прямоугольник!");
        int rows = 6, columns = 34;
        for (int x = 1; x <= rows; x++)
        {
            for (int y = 1; y <= columns; y++)
            {
                if (x == 1 || x == rows)
                    System.out.print("-");
                else if (y==1 || y==columns)
                    System.out.print("|");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        int week =4;
        int day =7;

        for (int i=1; i <= week; i++) // the outer loop
        {
            System.out.println("Week: " + i);

            for (int j=1; j <= day; j++) // the inner loop
            {
                System.out.println("\t Day: " + j); // \t is escape character for TABs
            }
        }

        // Another example of using Nested Loops
        int i,j;
        for (i = 7; i >= 1; i--)
        {
            for (j = 0; j < i; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
