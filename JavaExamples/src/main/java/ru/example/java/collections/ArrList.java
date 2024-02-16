package ru.example.java.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrList {
    public static void main(String[] args) {
        ArrayList<Character> charList = new ArrayList<>(); // init capacity - default (0)
        charList.add('a');
        ArrayList<String> strList = new ArrayList<>(charList.size()); // init capacity = charList.size() = 1

        ArrayList<Integer> shorts = new ArrayList<>();
        for (int i = Short.MIN_VALUE; i < Short.MAX_VALUE; i++){
            shorts.add(i);
        }
        System.out.printf("Size of shorts = %d", shorts.size());
    }
}
