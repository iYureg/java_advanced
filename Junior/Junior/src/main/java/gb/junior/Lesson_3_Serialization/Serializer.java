package gb.junior.Lesson_3_Serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serializer {
    public static void main(String[] args) throws Exception {
        String str = "Всем привет!";
        FileOutputStream fos = new FileOutputStream("serialized.bat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(str);
        oos.close();
    }
}
