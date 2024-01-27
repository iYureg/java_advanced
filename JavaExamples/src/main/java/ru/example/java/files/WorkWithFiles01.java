package ru.example.java.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WorkWithFiles01 {
    public static void main(String[] args) {
        try {
            Path file = Files.createFile(Paths.get("text.txt"));
            Files.write(file, List.of("text ".repeat(20).split(" ")), StandardCharsets.UTF_8);
            List<String> list = Files.readAllLines(Paths.get("text.txt"), StandardCharsets.UTF_8);
            for(String line : list)
                System.out.println(line);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File folder = new File(".");
        for(File file : folder.listFiles()) System.out.println(file.getName());

        System.out.println("folder.isDirectory(): " + folder.isDirectory());
        System.out.println("folder.isFile(): " + folder.isFile());

        File file = new File("text.txt");
        System.out.println("file.length: " + file.length());
        System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());
        System.out.println("folder.getTotalSpace(): " + folder.getTotalSpace());
        System.out.println("file.delete(): " + file.delete());
        System.out.println("file.exists(): " + file.exists());
        System.out.println("folder.getFreeSpace(): " + folder.getFreeSpace());
    }
}
