package ru.example.java.inputOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayIOStreamExamp {

    public static void main(String[] args) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        out.write(1);
        out.write(-1);
        out.write(0);


        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());

        int value = in.read();
        System.out.println("First element is - " + value);

        value = in.read();
        System.out.println("Second element is - " + value +
                ". If (byte)value - " + (byte)value);

        value = in.read();
        System.out.println("Third element is - " + value);
    }
}
