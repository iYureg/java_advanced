package ru.gb.jcore.view;

import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);

    public int getValue(String str){
        System.out.printf("%s", str);
        return in.nextInt();
    }

    public void print(int value, String str){
        System.out.printf("%s %d\n", str, value);
    }
}
