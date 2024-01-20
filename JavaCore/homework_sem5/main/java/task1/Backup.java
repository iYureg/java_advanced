package task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Написать функцию, создающую резервную копию всех файлов
 * в директории(без поддиректорий) во вновь созданную папку ./backup
 */
public class Backup {

    public Backup() {
    }

    /**
     * Method makes backup directory without subdirectory
     *
     * @param s source path
     * @param t target path
     * @return boolean
     */
    public static boolean copyFolder(String s, String t) throws IOException {
        boolean flag = false;

        File folder = Paths.get(s).toFile();
        File backupFolder = Paths.get(t).toFile();

        if(!backupFolder.exists())
        {
            Path toBackupDir = Files.createDirectories(Paths.get(backupFolder.getPath()));
            System.out.printf("created %s dir\n", toBackupDir.toString());
        }
        if(folder.isDirectory() && folder.listFiles() != null){
            for (File file : folder.listFiles()) {
                if (file.isFile()) {
                    Files.copy(Paths.get(file.getPath()), Paths.get(backupFolder.getPath()+"/"+file.getName()), REPLACE_EXISTING);
                    System.out.printf("File %s coped.\n", file.getName());
                }
            }
        }
        return flag;
    }
}
