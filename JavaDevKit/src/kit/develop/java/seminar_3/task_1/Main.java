package kit.develop.java.seminar_3.task_1;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CommonClass<String, DataInputStream, Integer> myclass = new CommonClass<>("abc", new DataInputStream(System.in), 10);
        System.out.println(myclass.getClassName());

        CommonClass<StringBuilder, DataInputStream, Float> myClass2 = new CommonClass<>(new StringBuilder(), new DataInputStream(System.in), 10.0f);
        System.out.println(myClass2.getClassName());
    }
}
