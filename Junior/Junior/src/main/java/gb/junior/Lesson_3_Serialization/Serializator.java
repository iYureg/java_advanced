package gb.junior.Lesson_3_Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializator {
    public static void main(String[] args) throws Exception{
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Character.getName(i));
        }

        serialObj(list, "serialized.bat");

        ArrayList<String> deSerialList = null;
        deSerialList = (ArrayList<String>) deSerialObj("serialized.bat");
        System.out.println(deSerialList);
    }

    public static void serialObj(Object o, String file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(o);
//        fos.close();
        oos.close();
    }

    public static Object deSerialObj(String file) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
//        fis.close();
//        ois.close();
        return ois.readObject();
    }
}
