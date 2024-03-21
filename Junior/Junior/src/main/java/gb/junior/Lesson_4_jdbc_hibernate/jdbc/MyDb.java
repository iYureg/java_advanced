package gb.junior.Lesson_4_jdbc_hibernate.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class MyDb {
    private static final Properties properties = setProps();
    private static final String URL = properties.getProperty("db.url");
    private static final String LOGIN = properties.getProperty("db.login");
    private static final String PASSWORD = properties.getProperty("db.password");

    private static Properties setProps() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("Junior/Junior/src/main/resources/db.config")) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }

    public static void getConnect() {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.execute("DROP SCHEMA junior_test");
            statement.execute("CREATE SCHEMA junior_test");
//            statement.execute("DROP TABLE `junior_test.junior`;");
            statement.execute("USE junior_test");
            statement.execute("CREATE TABLE junior (`id` INT NOT NULL, `name` VARCHAR(45) NULL, `surname` VARCHAR(45) NULL, PRIMARY KEY(`id`));");
            statement.execute("USE junior_test");
            statement.execute("INSERT INTO junior (id,surname,name) VALUES (1, \"Иванов\", \"Иван\")");
            statement.execute("INSERT INTO junior (id,surname,name) VALUES (2, \"Петров\", \"Петр\")");
            statement.execute("INSERT INTO junior (id,surname,name) VALUES (3, \"Сидоров\", \"Сидор\")");


            ResultSet resultSet = statement.executeQuery("SELECT * FROM junior_test.junior;");
            while (resultSet.next()){
                System.out.println(resultSet.getString(3) +
                        " " + resultSet.getString(2) +
                        " " + resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
