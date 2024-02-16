package ru.example.java.iterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Iterate {
    public static void main(String[] args) {
        Collection<String> colors = List.of("Белый", "Черный", "Красный", "Зеленый", "Синий");

        Iterator<String> iterator = colors.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        for(String s : colors) System.out.print(s + " ");
    }
}
