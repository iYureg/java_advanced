package task1;

import task1.Backup;

import java.io.IOException;

public class CopyFolderFiles {
    public static void main(String[] args) {
        // task_1
        //Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup
        try {
            Backup.copyFolder("./JavaCore","./backup");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
