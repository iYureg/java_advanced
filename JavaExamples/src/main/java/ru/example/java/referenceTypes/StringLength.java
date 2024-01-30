package ru.example.java.referenceTypes;

public class StringLength {

    static String word = "Java";

    public static void main(String[] args) {
        System.out.printf("The word is: %s length of word is: %d\n",word, word.length());
        System.out.printf("Let's repeat 5 times: %s\n",word.repeat(5));
        System.out.printf("Repeat: %s and check length: %d\n",word.repeat(5), word.repeat(5).length());
        System.out.printf("Repeat and show half of word: %s", word.repeat(5).substring(0, word.repeat(5).length() / 2));
    }
}
