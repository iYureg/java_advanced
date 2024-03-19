package gb.junior.Lesson_3_Serialization;

import java.io.IOException;
import java.io.Serializable;

public class UserSerializer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        User user = new User("ivan", "ivanov", "ivanovich");
//        Serializator.serialObj(user, "serialized.bat");

        User userFromFile = (User) Serializator.deSerialObj("serialized.bat");
        System.out.println(userFromFile.toString());
    }

    static class User implements Serializable {
        public String fName;
        public String lName;
        public String patronymic;

        public User(String fName, String lName, String patronymic) {
            this.fName = fName;
            this.lName = lName;
            this.patronymic = patronymic;
        }

        @Override
        public String toString() {
            return String.format("%s %s. %s.",
                    lName.toUpperCase().charAt(0) + lName.substring(1),
                    fName.toUpperCase().charAt(0),
                    patronymic.toUpperCase().charAt(0));
        }
    }

}
