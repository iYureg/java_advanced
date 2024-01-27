package ru.example.java.files;


import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsExamp {

    public static void main(String[] args) {

        Path filePath = Paths.get("C:\\Users\\User\\Pictures\\WBOSS.png");
        Path fileName = filePath.getFileName();
        System.out.println("Filename: " + fileName);

        Path parent = filePath.getParent();
        System.out.println("Parent directory: " + parent);

        boolean endWithTxt = filePath.endsWith("WBOSS.png");
        System.out.println("Ends with filepath: " + endWithTxt);

        endWithTxt = filePath.endsWith("png");
        System.out.println("Ends with string: " + endWithTxt);

        boolean startsWithPics = filePath.startsWith("C:/");
        System.out.println("Starts with filepath: " + startsWithPics);

        System.out.println(filePath.isAbsolute());

        Path pathFirst = Paths.get("E:\\txt\\dsfs.txt");
        System.out.println(pathFirst.normalize());

        Path pathSecond = Paths.get("cd ..\\..\\..\\..\\txt\\dsfs.txt");
        System.out.println(pathSecond.normalize());


    }
}
