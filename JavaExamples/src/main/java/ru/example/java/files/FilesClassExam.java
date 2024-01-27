package ru.example.java.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FilesClassExam {

    public static void main(String[] args) {
        try {
            // create file
            Path file = Files.createFile(Paths.get("./filesCreateFile.txt"));
            System.out.print("Was the file captured successfully in ./dir? ");
            System.out.println(Files.exists(Paths.get("./filesCreateFile.txt")));


            // create dir
            Path testDirectory = Files.createDirectory(Paths.get("./testing"));
            System.out.print("Was the test directory created successfully? ");
            System.out.println(Files.exists(Paths.get("./testing")));


            // move file
            file = Files.move(file, Paths.get("./testing/filesCreateFile.txt"), REPLACE_EXISTING);
            System.out.print("Is our file still in the ./dir? ");
            System.out.println(Files.exists(Paths.get("./filesCreateFile.txt")));
            System.out.print("Has our file been moved to testing dir? ");
            System.out.println(Files.exists(Paths.get("./testing/filesCreateFile.txt")));

            // copy file
            Path copyFile = Files.copy(file, Paths.get("./filesCreateFile.txt"), REPLACE_EXISTING);
            System.out.print("Has our file been copied to ./dir? ");
            System.out.println(Files.exists(Paths.get("./filesCreateFile.txt")));



            // delete file
            Files.delete(file);
            Files.delete(copyFile);
            // delete dir
            Files.delete(testDirectory);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
