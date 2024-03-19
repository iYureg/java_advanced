package gb.junior.Lesson_3_Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserializer {
    public static void main(String[] args) throws Exception {
        String str = "";
        FileInputStream fis = new FileInputStream("serialized.bat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        str = (String) ois.readObject();
        System.out.println(str);
    }

}
