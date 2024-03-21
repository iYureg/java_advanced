package gb.junior.Webinar_3_serialization_plus_jdbc.homework;

import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {

        // create table
//        System.out.println(DBHandler.createTable("students"));


        // insert
        for (int i = 1; i <= 10; i++) {
            DBHandler.insertData("students", i,"ivan_" +i, "ivanov_" + i, i * i);
        }


        //update
        DBHandler.updateById("students", 5, "petr", "petrov");
        DBHandler.updateById("students", 50, "sidr", "sidorov");
        DBHandler.updateById("students", 8, "sidr", "sidorov");

        // read
        DBHandler.readTable("students");

        // delete
        DBHandler.deleteAll("students");
        DBHandler.readTable("students");


    }
}
