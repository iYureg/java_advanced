package ru.example.java.inputOutputStream;

import java.io.*;

public class FileIOStream {
    public static void main(String[] args) {

        byte[] byteToWrite = {0, 10, 12, 14, 55, 13, 23};
        byte[] byteToRead = new byte[10];

        File file = new File("bytes.txt");

        try{
            System.out.println("Begin");
            FileOutputStream outFile = new FileOutputStream(file);
            outFile.write(byteToWrite); outFile.close();
            System.out.println("Bytes written");

            FileInputStream inFile = new FileInputStream(file);
            int bytesAvailable = inFile.available();
            System.out.println("Ready to read " + bytesAvailable + " bytes");

            int count = inFile.read(byteToRead, 0 , bytesAvailable);
            for (int i = 0; i < count; i++)
                System.out.print(" " + byteToRead[i]);

            System.out.println(); inFile.close();
            System.out.println("Input stream closed");



        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
