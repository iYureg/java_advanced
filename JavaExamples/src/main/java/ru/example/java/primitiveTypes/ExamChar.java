package ru.example.java.primitiveTypes;

public class ExamChar {
    public static void main(String[] args) {
        Character character = 'a';
        String str = Integer.toBinaryString(character);
        System.out.println(Character.getNumericValue(character));
        System.out.println(Character.toChars(character));
        System.out.println(str);
    }
}
